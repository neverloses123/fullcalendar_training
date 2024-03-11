package com.example.repository;

import com.example.model.Calendar;
import com.example.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 2400048
 */
public interface CustomerRepository  extends JpaRepository<Customer, Long>, CustomerRepositoryCustomized{
    List<Customer> findByCustomerName(String customerName);
}
