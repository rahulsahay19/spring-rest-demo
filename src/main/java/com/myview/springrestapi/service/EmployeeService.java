package com.myview.springrestapi.service;

import com.myview.springrestapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    void deleteEmployee(Long id);
    Employee updateEmployee(Employee employee);

}
