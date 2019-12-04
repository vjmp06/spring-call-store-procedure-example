package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Employees;

public interface EmployeeRepository extends CrudRepository<Employees, Long>, EmployeeRepositoryCustom {


}