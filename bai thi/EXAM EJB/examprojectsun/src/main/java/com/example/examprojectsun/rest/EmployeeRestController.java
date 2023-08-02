package com.example.examprojectsun.rest;

import com.example.examprojectsun.dao.EmployeeRepository;
import com.example.examprojectsun.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeRepository repository;

    @Autowired
    public EmployeeRestController(EmployeeRepository theEmployeeRepository){
            repository=theEmployeeRepository;
    }

    @GetMapping("/employee")
    public List<Employee> all(){
        return repository.findAll();
    }
    @PostMapping("/employee")
    public Employee newEmployee(@RequestBody Employee newEmployee){
        return repository.save(newEmployee);
    }
}
