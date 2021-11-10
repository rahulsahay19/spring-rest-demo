package com.myview.springrestapi.controller;

import com.myview.springrestapi.model.Department;
import com.myview.springrestapi.model.Employee;
import com.myview.springrestapi.repository.DepartmentRepository;
import com.myview.springrestapi.repository.EmployeeRepository;
import com.myview.springrestapi.request.EmployeeRequest;
import com.myview.springrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController //@Controller + @ResponseBody
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Value("${spring.application.name: Employee Tracker}")
    private String appName;

    @Value("${spring.application.version: Default Version}")
    private String version;

    @GetMapping("/version")
    public String getVersion(){
        return appName + " - " + version;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){

        return new ResponseEntity<List<Employee>>(employeeService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeRequest employeeRequest){
        Department dept = new Department();
        dept.setName(employeeRequest.getDepartment());
        dept = departmentRepository.save(dept);
        Employee emp = new Employee(employeeRequest);
        emp.setDepartment(dept);
        emp = employeeRepository.save(emp);
        return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        System.out.println("Updating the employee data for the employee: " + id);
        employee.setId(id);
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }
}
