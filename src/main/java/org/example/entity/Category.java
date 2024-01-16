package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name="id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Driver name cannot be blank!")
    @Pattern(regexp = "^[A-Z].*", message = "License should start with a capital letter!")
    @Column(name="category", nullable = false, unique = true)
    private String category;

    @OneToMany(mappedBy = "category")
    private Set<Transport> transports;

    @ManyToMany(mappedBy = "categories")
    private Set<Driver> drivers;

    public Category() {
    }

    public Category(String category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String license) {
        this.category = license;
    }

    public Set<Transport> getTransports() {
        return transports;
    }

    public void setTransports(Set<Transport> transports) {
        this.transports = transports;
    }

    public Set<Driver> getEmployees() {
        return drivers;
    }

    public void setEmployees(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", license='" + category + '\'' +
                '}';
    }
}