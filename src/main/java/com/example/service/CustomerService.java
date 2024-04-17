//package com.example.service;
//
//import com.example.model.Customer;
//import com.example.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//public class CustomerService {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//    @Transactional(rollbackFor = Exception.class)
//    public List<Customer> getAllCustomer() {
//        List<Customer> customerList = customerRepository.findAll();
//        return customerList;
//    }
//}
