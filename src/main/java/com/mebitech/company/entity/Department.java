package com.mebitech.company.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="department")
public class Department {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;


    @Column(name="name")
    @NotEmpty
    @Size(max=20)
    private String name;

    @OneToMany(fetch = FetchType.EAGER,mappedBy="department")
    private List<Employee> employees;



}
