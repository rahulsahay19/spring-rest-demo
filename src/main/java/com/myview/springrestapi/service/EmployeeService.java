package com.myview.springrestapi.service;

import com.myview.springrestapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees(int pageNumber, int pageSize);
    Employee saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    void deleteEmployee(Long id);
    Employee updateEmployee(Employee employee);
    List<Employee> getEmployeesByName(String name);
    List<Employee> getEmployeesByNameAndLocation(String name, String location);
    List<Employee> getEmployeesByKeyword(String keyword);
    List<Employee> getEmployeesByNameOrLocation(String name, String location);
}
