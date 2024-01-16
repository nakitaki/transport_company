package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @Column(name="id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Company name cannot be blank!")
    @Size(max = 30, message = "Company name has to be with up to 30 characters!")
    @Pattern(regexp = "^[A-Z].*", message = "Company should start with a capital letter!")
    @Column(name="name", nullable = false)
    private String name;

    @PastOrPresent(message = "Foundation date cannot be in the future!")
    @Column(name="foundation_name")
    private LocalDate foundationDate;

    @Column(name = "overcharge")
    @DecimalMin(value = "0.01", message = "Overcharge should be at least 0.01!")
    private BigDecimal overcharge;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Driver> drivers;

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

    public Company(String name, LocalDate foundationDate, BigDecimal overcharge) {
        this.name = name;
        this.foundationDate = foundationDate;
        this.overcharge = overcharge;
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

    public BigDecimal getOvercharge() {
        return overcharge;
    }

    public void setOvercharge(BigDecimal overcharge) {
        this.overcharge = overcharge;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<Transport> getTransports() {
        return transports;
    }

    public void setTransports(Set<Transport> transports) {
        this.transports = transports;
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

//TODO remove initial capital
