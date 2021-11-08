package com.myview.springrestapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

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
    private Long age = 0L;
    private String location;
    @Email(message = "Please enter valid email address")
    private String email;
    @NotBlank(message = "Department shouldn't be null")
    private String department;
    @CreationTimestamp
    @Column(name="created_at")
    private Date createdAt;
    @UpdateTimestamp
    @Column(name="updated_at")
    private Date updatedAt;
}
