package org.example.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String license;

    @OneToMany(mappedBy = "category")
    private Set<Transport> transports;

    @ManyToMany
    private Set<Employee> employees;

}
