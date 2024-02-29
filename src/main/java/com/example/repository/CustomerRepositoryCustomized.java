package com.example.repository;

import com.example.model.Customer;

import java.util.List;

public interface CustomerRepositoryCustomized {
    List<Customer> findAllDetail(Customer customer);
}
