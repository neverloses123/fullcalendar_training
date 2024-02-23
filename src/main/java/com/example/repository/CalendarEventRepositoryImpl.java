package com.example.repository;

import com.example.model.Calendar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.*;

public class CalendarEventRepositoryImpl implements CalendarEventRepositoryCustomized {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Calendar> findAllDetail(Calendar eventCalendar){

        StringBuilder sb = new StringBuilder();
        sb.append(
                "select * from calendar_event_master where 1=1"
        );

        Query query = (Query) entityManager.createNativeQuery(sb.toString());
        List<Calendar> result =query.getResultList();

        return result;
    }


}
