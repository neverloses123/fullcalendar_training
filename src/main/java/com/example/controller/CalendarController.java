package com.example.controller;

import com.example.model.Calendar;
import com.example.service.CalendarService;
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

    @Autowired
    CalendarService calendarService;
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
}
