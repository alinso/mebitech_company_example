package com.mebitech.company.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="meeting")
public class Meeting  implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    @NotEmpty
    @Size(max=20)
    private String name;

    @Column(name="description")
    @NotEmpty
    private String description;

    @ManyToMany(cascade = CascadeType.MERGE , fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinTable(
            name = "department_meeting",
            joinColumns = { @JoinColumn(name = "meeting_id") },
            inverseJoinColumns = { @JoinColumn(name = "department_id") }
    )
    Set<Department> departments = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
}
