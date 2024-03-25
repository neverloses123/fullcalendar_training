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
@Service
@Transactional
public class ProjectService {

    @Autowired
    private CalendarRepository eventRepository;
    @Autowired
    private CalendarRepositoryImpl calendarRepositoryImpl;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectRepositoryImpl projectRepositoryImpl;
    public List<Project> findAllDetail(Project project)
    {
        List<Project> projectList = projectRepositoryImpl.findAllDetail(project);
        return projectList;
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(Calendar calendar)
    {
        boolean NEWPROJECT=false;
        if(calendar.getEventId()==0){NEWPROJECT=true;}

        if(NEWPROJECT){
            String eventName=calendar.getEventName();
            calendar.setEventName(eventName);
            projectRepository.save();
            Date eventStartDate=calendar.getEventStartDate();
            calendar.setEventStartDate(eventStartDate);
            projectRepository.save();

            Date eventEndDate=calendar.getEventEndDate();
            calendar.setEventEndDate(eventEndDate);
            projectRepository.save();
        }
    }
}
