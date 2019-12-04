package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Employees;
import com.example.demo.repository.EmployeeRepository;

@CrossOrigin("*")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/{codigo}")
    public ResponseEntity<List<Employees>> getAllEmployees(@PathVariable Long codigo ) {
        Iterable<Employees> employees = employeeRepository.getAllEmployees(codigo);

        List<Employees> target = new ArrayList<>();
        employees.forEach(target::add);
        return ResponseEntity.status(HttpStatus.OK).body(target);

    }
    
    @RequestMapping(value = "teste/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employees> getAllEmployeeById(@PathVariable(name = "id") long id) {

        Employees one = employeeRepository.findOne(id);
        return new ResponseEntity<Employees>(one, HttpStatus.OK);
    }
}