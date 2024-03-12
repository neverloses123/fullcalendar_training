package com.example.controller;

import com.example.model.Calendar;
import com.example.model.Project;
import com.example.service.CalendarService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author 2400048
 */
@Controller
@RequestMapping("/api/calendar")
public class CalendarController {


    CalendarController(){super();}

    Logger logger = LoggerFactory.getLogger(CalendarController.class);
    @Autowired
    private CalendarService calendarService;
    @RequestMapping("/getAll")
    public String getAll(Model model)
    {

        List<Calendar> list = calendarService.findAllDetail(null);
        model.addAttribute("list",list);
        return "calendar";
    }


    @PostMapping("/save")
    public String saveEvent(@ModelAttribute("calendar") Calendar calendar,
                          @RequestParam("eventName") String eventName,
                          @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("startDate") Date startDate,
                          @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("endDate") Date endDate,
                            Model model)
    {
        if(calendar.getEventId()==0) {
            calendar.setEventName(eventName);
            calendar.setEventStartDate(startDate);
            calendar.setEventEndDate(endDate);
        }
        calendarService.save(calendar);
        List<Calendar> list = calendarService.findAllDetail(null);
        model.addAttribute("list",list);
        return "calendar";
    }
    @PostMapping("/del")
    public String delEvent(@ModelAttribute("calendar") Calendar calendar,
                           @RequestParam("eventNameDel") String eventNameDel,
                           Model model)
    {
        if(calendar.getEventId()==0)
        {
            calendar.setEventName(eventNameDel);
        }
        calendarService.deleteEventByName(eventNameDel);
        List<Calendar> list = calendarService.findAllDetail(null);
        model.addAttribute("list",list);
        return "calendar";
    }

    @GetMapping("/edit/{event_id}")
    public String editEvent(@PathVariable int event_id, Model model){
        List<Project> projectList = calendarService.getAllProject();
        model.addAttribute("project", projectList);
        String projectStr = new Gson().toJson(projectList);
        model.addAttribute("projectStr", projectStr);
        model.addAttribute("mode", "edit");
        Calendar calendar = calendarService.get(event_id);
        model.addAttribute("calendar", calendar);
//      model.addAttribute("curProject", calendar.getProjectId());
        model.addAttribute("functionTitle", "編輯客戶");
        model.addAttribute("submitTitle", "確認變更");
        return "calendar_edit";
    }
}
