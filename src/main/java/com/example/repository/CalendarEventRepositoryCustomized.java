package com.example.repository;

import com.example.model.Calendar;

import java.sql.Date;
import java.util.List;

public interface CalendarEventRepositoryCustomized {
    public  List<Calendar> findAllDetail(Calendar eventCalendar);
}
