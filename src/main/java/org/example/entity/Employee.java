package org.example.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private BigDecimal salary;

    @ManyToOne
    private Company company;
//    private Set<DrivingLicence> drivingLicense;

    @OneToMany(mappedBy = "employee")
    private Set<Transport> transports;

    @ManyToMany(mappedBy = "employees")
    private Set<Category> categories;
}
