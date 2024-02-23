package com.example.controller;

import com.example.model.Calendar;
import com.example.service.CalendarEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/api/calendar")
public class CalendarController {

    @Autowired
    CalendarEventService calendarEventService;
    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello from Thymeleaf!");
        return "test";
    }
    @RequestMapping("/getAll")
    public String getAll(Model model) {

        List<Calendar> list = calendarEventService.findAllDetail(null);
        model.addAttribute("list",list);
        return "calendar";
    }


    @PostMapping("/save")
    public String saveEvent(@ModelAttribute("calendar") Calendar calendar,
                          @RequestParam("eventName") String eventName,
                          @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("startDate") Date startDate,
                          @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("endDate") Date endDate,Model model) {
        if(calendar.getEventId()==0) {
            calendar.setEventName(eventName);
            calendar.setEventStartDate(startDate);
            calendar.setEventEndDate(endDate);
        }
        calendarEventService.save(calendar);
        List<Calendar> list = calendarEventService.findAllDetail(null);
        model.addAttribute("list",list);
        return "calendar";
    }
    @PostMapping("/del")
    public String delEvent(@ModelAttribute("calendar") Calendar calendar,
                           @RequestParam("eventNameDel") String eventNameDel,Model model){
        if(calendar.getEventId()==0) {
            calendar.setEventName(eventNameDel);
        }
        calendarEventService.deleteEventByName(eventNameDel);
        List<Calendar> list = calendarEventService.findAllDetail(null);
        model.addAttribute("list",list);
        return "calendar";
    }
}
