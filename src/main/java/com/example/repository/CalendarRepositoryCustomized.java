package com.example.repository;

import com.example.model.Calendar;

import java.util.List;

/**
 * @author 2400048
 */
public interface CalendarRepositoryCustomized
{
    public  List<Calendar> findAllDetail(Calendar calendar);
}
