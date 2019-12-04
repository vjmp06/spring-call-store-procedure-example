package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import com.example.demo.domain.Employees;

public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Employees> getAllEmployees(Long codigo) {
        StoredProcedureQuery findByYearProcedure =
                em.createNamedStoredProcedureQuery("getAllEmployees");
        findByYearProcedure.registerStoredProcedureParameter(0, Long.class, ParameterMode.IN);
        findByYearProcedure.setParameter(0, codigo);
        return findByYearProcedure.getResultList();
    }
}