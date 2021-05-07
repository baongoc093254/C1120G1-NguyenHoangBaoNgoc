package com.example.repository;


import com.example.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {
    Page<Employee> findAll(Pageable pageable);

    @Query(value="select * " +
            "from employee e " +
            "join position p using(position_id) " +
            "join division d using(division_id) " +
            "join education_degree ed using(education_degree_id) " +
            "where concat(e.employee_name,e.employee_birthday, e.employee_id_card, e.employee_phone, e.employee_email, e.employee_address," +
            "p.position_name, d.division_name, ed.education_degree_name) like %?1%",
            nativeQuery = true)
    Page<Employee> findAllInputTex(String search, Pageable pageable);
    Page<Employee> findAllByNameContaining(String name,Pageable pageable);
    List<Employee> findAllByNameContaining(String name);



}

