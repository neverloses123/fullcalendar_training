package com.example.model;

import jakarta.persistence.*;

/**
 * @author 2400048
 */
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int projectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "customer_id")
    private int projectCustomerId;

    @Column(name = "member_id")
    private int projectMemberId;

    @Column(name = "project_state")
    private String projectState;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectCustomerId() {
        return projectCustomerId;
    }

    public void setProjectCustomerId(int projectCustomerId) {
        this.projectCustomerId = projectCustomerId;
    }

    public int getProjectMemberId() {
        return projectMemberId;
    }

    public void setProjectMemberId(int projectMemberId) {
        this.projectMemberId = projectMemberId;
    }

    public String getProjectState() {
        return projectState;
    }

    public void setProjectState(String projectState) {
        this.projectState = projectState;
    }
}
