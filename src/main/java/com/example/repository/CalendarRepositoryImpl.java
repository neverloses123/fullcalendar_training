package com.example.repository;

import com.example.model.Calendar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.*;

/**
 * @author 2400048
 */
public class CalendarRepositoryImpl implements CalendarRepositoryCustomized
{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Calendar> findAllDetail(Calendar calendar)
    {

        StringBuilder sb = new StringBuilder();
        sb.append(
                "select a.*,b.project_name from event" +
                        " a left join project b on b.project_id=a.project_id where 1=1"
        );

        Query query = (Query) entityManager.createNativeQuery(sb.toString());
        List<Calendar> result =query.getResultList();

        return result;
    }


}
