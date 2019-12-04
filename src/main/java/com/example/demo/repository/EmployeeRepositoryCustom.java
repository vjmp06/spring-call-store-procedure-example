package com.example.demo.repository;

import java.util.List;

import com.example.demo.domain.Employees;

public interface EmployeeRepositoryCustom {

    List<Employees> getAllEmployees(Long codigo);
}
