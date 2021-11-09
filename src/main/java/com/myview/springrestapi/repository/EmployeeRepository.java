package com.myview.springrestapi.repository;

import com.myview.springrestapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);
    List<Employee> findByNameAndLocation(String name, String location);
    List<Employee> findByNameContaining(String keyword);
}
