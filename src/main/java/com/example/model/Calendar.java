package com.example.model;

import jakarta.persistence.*;

import java.util.Date;

/**
 * @author 2400048
 */
@Entity
@Table(name="event")
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private int eventId;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_start_date")
    private Date eventStartDate;

    @Column(name = "event_end_date")
    private Date eventEndDate;

    @Column(name = "event_project")
    private String eventProject;

    public int getEventId() {
        return eventId;
    }


    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(Date eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public Date getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(Date eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public String getEventProject() {
        return eventProject;
    }

    public void setEventProject(String eventProject) {
        this.eventProject = eventProject;
    }
}