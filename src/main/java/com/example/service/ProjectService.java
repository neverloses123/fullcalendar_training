package com.example.service;

import com.example.model.Calendar;
import com.example.model.Customer;
import com.example.model.Member;
import com.example.model.Project;
import com.example.repository.*;
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
    private CustomerRepository customerRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ProjectRepositoryImpl projectRepositoryImpl;
    public List<Project> findAllDetail(Project project)
    {
        //List<Project> projectList = projectRepositoryImpl.findAllDetail(project);
        List<Project> projectList = projectRepository.findAll();
        return projectList;
    }
    public List<Customer> getAllCustomer(){
        List<Customer> customerList = customerRepository.findAll();
        return customerList;
    }
    public List<Member> getAllMember(){
        List<Member> memberList = memberRepository.findAll();
        return memberList;
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(Project project)
    {
        boolean NEWPROJECT=false;
        if(project.getProjectId()==0){NEWPROJECT=true;}

        if(NEWPROJECT){
            String eventName=project.getProjectName();
            project.setProjectName(eventName);
            projectRepository.save(project);

            int projectCustomerId=project.getProjectCustomerId();
            project.setProjectCustomerId(projectCustomerId);
            projectRepository.save(project);

            int projectMemberId=project.getProjectMemberId();
            project.setProjectMemberId(projectMemberId);
            projectRepository.save(project);

            String projectState=project.getProjectState();
            project.setProjectState(projectState);
            projectRepository.save(project);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteProjectByName(String delName)
    {
        Calendar calendar = eventRepository.findByEventName(delName).get(0);
        if (calendar != null)
        {
            eventRepository.delete(calendar);
        }
    }
    public Project get(int id) {
        return projectRepository.findById((long) id).get();
    }
}
