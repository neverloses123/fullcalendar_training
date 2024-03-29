package com.example.service;

import com.example.model.Calendar;
import com.example.model.Project;
import com.example.repository.CalendarRepository;
import com.example.repository.CalendarRepositoryImpl;
import com.example.repository.ProjectRepository;
import com.example.repository.ProjectRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author 2400048
 */
@Service
@Transactional
public class CalendarService
{
    @Autowired
    private CalendarRepository eventRepository;
    @Autowired
    private CalendarRepositoryImpl calendarRepositoryImpl;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectRepositoryImpl projectRepositoryImpl;
    public List<Calendar> findAllDetail(Calendar eventName)
    {
        List<Calendar> calendarList = calendarRepositoryImpl.findAllDetail(eventName);
        return calendarList;
    }
    public Calendar get(String eventName)
    {
        Calendar calendar=eventRepository.findByEventName(eventName).get(0);
        return calendar;
    }
    @Transactional(rollbackFor = Exception.class)
    public void save(Calendar calendar)
    {
        boolean NEWPROJECT=false;
        if(calendar.getEventId()==0){NEWPROJECT=true;}

            if(NEWPROJECT){
                String eventName=calendar.getEventName();
                calendar.setEventName(eventName);
                eventRepository.save(calendar);

                Date eventStartDate=calendar.getEventStartDate();
                calendar.setEventStartDate(eventStartDate);
                eventRepository.save(calendar);

                Date eventEndDate=calendar.getEventEndDate();
                calendar.setEventEndDate(eventEndDate);
                eventRepository.save(calendar);
                }
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteEventByName(String delName)
    {
        Calendar calendar = eventRepository.findByEventName(delName).get(0);
        if (calendar != null)
        {
            eventRepository.delete(calendar);
        }
    }

    public List<Project> getAllProject(){
        List<Project> projectList = projectRepository.findAll();
        return projectList;
    }

    public Calendar get(int id) {
        return eventRepository.findById((long) id).get();
    }

}




