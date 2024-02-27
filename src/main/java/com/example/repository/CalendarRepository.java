package com.example.repository;

import com.example.model.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 2400048
 */
@Repository("calendarEventRepository")
@EnableJpaRepositories("com.example.repository")
public interface CalendarRepository extends JpaRepository<Calendar, Long>, CalendarRepositoryCustomized
{
    List<Calendar> findByEventName(String eventName);

}

