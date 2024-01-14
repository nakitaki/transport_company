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

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
//    private Set<DrivingLicence> drivingLicense;

    @OneToMany(mappedBy = "employee")
    private Set<Transport> transports;

    @ManyToMany(mappedBy = "employees")
    private Set<Category> categories;

    public Employee() {
    }

    public Employee(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name, BigDecimal salary, Company company) {
        this.name = name;
        this.salary = salary;
        this.company = company;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", company=" + company +
                '}';
    }
}
