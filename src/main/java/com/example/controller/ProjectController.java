package com.example.controller;



import com.example.model.Calendar;
import com.example.model.Project;
import com.example.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * @author 2400048
 */
@Controller
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @RequestMapping("/listAll")
    public String getAll(Model model)
    {
        List<Project> list = projectService.findAllDetail(null);
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
        projectService.save(calendar);
        List<Project> list = projectService.findAllDetail(null);
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
        projectService.deleteEventByName(eventNameDel);
        List<Project> list = projectService.findAllDetail(null);
        model.addAttribute("list",list);
        return "calendar";
    }
}
