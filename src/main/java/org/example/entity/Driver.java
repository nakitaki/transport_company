package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @Column(name="id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Driver name cannot be blank!")
    @Pattern(regexp = "^[A-Z].*", message = "Company should start with a capital letter!")
    @Column(name="name", nullable = false)
    private String name;

    @Column(name = "salary")
    @DecimalMin(value = "1000.00", message = "Salary should be at least 1000.00")
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @OneToMany(mappedBy = "driver")
    private Set<Transport> transports;

    @ManyToMany
    private Set<Category> categories;

    public Driver() {
    }

    public Driver(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    public Driver(String name, BigDecimal salary, Company company) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Set<Transport> getTransports() {
        return transports;
    }

    public void setTransports(Set<Transport> transports) {
        this.transports = transports;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
