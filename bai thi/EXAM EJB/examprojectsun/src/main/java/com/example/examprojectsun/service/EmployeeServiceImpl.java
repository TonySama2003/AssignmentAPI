package com.example.examprojectsun.service;

import com.example.examprojectsun.dao.EmployeeRepository;
import com.example.examprojectsun.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository=theEmployeeRepository;
    }
    @Override
    public List<Employee> findAll(){
        return employeeRepository.findAllByOrderByNameAsc();
    }
    @Override
    public void save(Employee theEmployee){
        employeeRepository.save(theEmployee);
    }
}
