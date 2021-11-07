package com.myview.springrestapi.service;

import com.myview.springrestapi.model.Employee;
import com.myview.springrestapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
//    private static List<Employee> list = new ArrayList<>();
//    static {
//        Employee emp = new Employee();
//        emp.setName("John");
//        emp.setEmail("john@gmail.com");
//        emp.setAge(27L);
//        emp.setDepartment("CS");
//        emp.setLocation("Bangalore");
//        list.add(emp);
//        emp = new Employee();
//        emp.setName("Tom");
//        emp.setEmail("tom@gmail.com");
//        emp.setAge(28L);
//        emp.setDepartment("CS");
//        emp.setLocation("Bangalore");
//        list.add(emp);
//    }
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
