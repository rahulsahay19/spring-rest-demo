package com.myview.springrestapi.controller;

import com.myview.springrestapi.model.Employee;
import com.myview.springrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //@Controller + @ResponseBody
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Value("${spring.application.name: Employee Tracker}")
    private String appName;

    @Value("${spring.application.version: Default Version}")
    private String version;

    @GetMapping("/version")
    public String getVersion(){
        return appName + " - " + version;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/employees")
    public String deleteEmployee(@RequestParam("id") Long id){
        employeeService.deleteEmployee(id);
        return "deleted employee with id: "+id;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){

        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        System.out.println("Updating the employee data for the employee: " + id);
        employee.setId(id);
        return employeeService.updateEmployee(employee);
    }
}
