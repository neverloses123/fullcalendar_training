package com.example.repository;

import com.example.model.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("calendarEventRepository")
@EnableJpaRepositories("com.example.repository")
public interface CalendarEventRepository extends JpaRepository<Calendar, Long>, CalendarEventRepositoryCustomized {
    List<Calendar> findByEventName(String eventName);

}

