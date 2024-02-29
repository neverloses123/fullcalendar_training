package com.example.model;

import jakarta.persistence.*;


@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_address")
    private String customerAddress;
    @Column(name = "customer_tel")
    private int customerTel;
    @Column(name = "customer_mail")
    private String customerMail;

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {this.customerName = customerName;}

    public String getCustomerAddress() {
        return customerAddress;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getCustomerTel() {
        return customerTel;
    }
    public void setCustomerTel(int customerTel) {this.customerTel = customerTel;}

    public String getCustomerMail() {
        return customerMail;
    }
    public void setCustomerMail(String customerMail) {this.customerName = customerMail;}

}
