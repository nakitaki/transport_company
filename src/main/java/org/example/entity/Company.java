package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private LocalDate foundationDate;

//    private BigDecimal overcharge;

    @OneToMany(mappedBy = "company")
    private Set<Employee> employees;

    @OneToMany(mappedBy = "company")
    private Set<Vehicle> vehicles;

    @OneToMany(mappedBy = "company")
    private Set<Transport> transports;


    public Company() {
    }

    public Company(String name, LocalDate foundationDate) {
        this.name = name;
        this.foundationDate = foundationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foundationDate=" + foundationDate +
                '}';
    }
}
