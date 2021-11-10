package com.myview.springrestapi.model;

import com.myview.springrestapi.request.EmployeeRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Name shouldn't be null")
    private String name;

    @OneToOne
    private Department department;

    public Employee(EmployeeRequest request) {
        this.name= request.getName();
    }
}
