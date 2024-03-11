package com.example.repository;

import com.example.model.Customer;

import java.util.List;

/**
 * @author 2400048
 */
public interface CustomerRepositoryCustomized {
    List<Customer> findAllDetail(Customer customer);

}
