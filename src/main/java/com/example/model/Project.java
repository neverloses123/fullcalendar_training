package com.example.model;

import jakarta.persistence.*;

/**
 * @author 2400048
 */
@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int projectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_customer")
    private String projectCustomer;

    @Column(name = "project_member")
    private String projectMember;

    @Column(name = "project_state")
    private String projectState;

    public int getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCustomer() {
        return projectCustomer;
    }
    public void setProjectCustomer(String projectCustomer) {
        this.projectCustomer = projectCustomer;
    }

    public String getProjectMember() {
        return projectMember;
    }
    public void setProjectMember(String projectMember) {
        this.projectMember = projectMember;
    }

    public String getProjectState() {
        return projectState;
    }
    public void setProjectState(String projectState) {
        this.projectState = projectState;
    }
}
