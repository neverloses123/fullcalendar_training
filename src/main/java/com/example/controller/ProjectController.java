package com.example.controller;



import com.example.model.Calendar;
import com.example.model.Customer;
import com.example.model.Project;
//import com.example.service.CustomerService;
import com.example.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
//    private CustomerService customerService;
    @RequestMapping("/listAll")
    public String getAll(Model model)
    {
        List<Project> list = projectService.findAllDetail(null);
        model.addAttribute("list",list);
        return "calendar";
    }
    @PostMapping("/save")
    public String saveProject(@ModelAttribute("project") Project project,
                            @RequestParam("projectName") String projectName,
                            @RequestParam("projectCustomerId") int projectCustomerId,
                            @RequestParam("projectMemberId") int projectMemberId,
                            @RequestParam("projectState") String projectState,
                            Model model)
    {
        if(project.getProjectId()==0) {
            project.setProjectName(projectName);
            project.setProjectCustomerId(projectCustomerId);
            project.setProjectMemberId(projectMemberId);
            project.setProjectState(projectState);
        }
        projectService.save(project);
        List<Project> list = projectService.findAllDetail(null);
        model.addAttribute("list",list);
        return "calendar";
    }
    @PostMapping("/del")
    public String delProject(@ModelAttribute("project") Project project,
                           @RequestParam("projectNameDel") String projectNameDel,
                           Model model)
    {
        if(project.getProjectId()==0)
        {
            project.setProjectName(projectNameDel);
        }
//        projectService.deleteProjectByName(projectNameDel);
//        List<Project> list = projectService.findAllDetail(null);
//        model.addAttribute("list",list);
        return "calendar";
    }

    @GetMapping("/edit/{legacy_customer_id}")
    public String editProject(@ModelAttribute int projectId, Model model)
    {
        Project project=projectService.get(projectId);

//        List<Customer> industryList= customerService.getAllCustomer();

//        model.addAttribute("industries", industryList);
        model.addAttribute("project",project);
        model.addAttribute("functionTitle","編輯客戶");
        model.addAttribute("submitTitle","確認變更");
        return "project";
    }
}
