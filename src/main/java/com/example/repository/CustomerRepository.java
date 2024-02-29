package com.example.repository;

import com.example.model.Calendar;
import com.example.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository  extends JpaRepository<Customer, Long>, CustomerRepositoryCustomized{
    List<Customer> findByEventName(String customerName);
}
