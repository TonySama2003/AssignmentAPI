package com.example.asmcustomerapi.service;

import com.example.asmcustomerapi.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int theId);

    void save(Customer theCustomer);

    void deleteById(int theId);

    List<Customer> searchBy(String theName);
}
