package com.example.asmcustomerapi.dao;

import com.example.asmcustomerapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findAllByOrderByLastNameAsc();
    List<Customer> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name,String lname);
}
