package com.myview.springrestapi.service;

import com.myview.springrestapi.model.Employee;
import com.myview.springrestapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getEmployees(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC, "id");
        return employeeRepository.findAll(pages).getContent();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        throw new RuntimeException("Employee not found for id: "+id);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        //here employee will have id, hence save will update the record
       return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
       return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
        return employeeRepository.findByNameAndLocation(name, location);
    }

    @Override
    public List<Employee> getEmployeesByKeyword(String keyword) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        return employeeRepository.findByNameContaining(keyword, sort);
    }

    @Override
    public List<Employee> getEmployeesByNameOrLocation(String name, String location) {
        return employeeRepository.getEmployeesByNameOrLocation(name, location);
    }

    @Override
    public Integer deleteEmployeeByName(String name) {
        return employeeRepository.deleteEmployeeByName(name);
    }
}
