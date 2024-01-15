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
    private Set<Driver> drivers;

    public Category() {
    }

    public Category(String license) {
        this.license = license;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
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
                ", license='" + license + '\'' +
                '}';
    }
}