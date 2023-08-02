package com.example.examprojectsun.service;

import com.example.examprojectsun.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    void save(Employee theEmployee);
}
