package org.example.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String model;

    private String licensePlate;

    private int passenger_capacity;

    private BigDecimal weight_capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @OneToMany(mappedBy = "vehicle")
    private Set<Transport> transports;

    @ManyToOne(fetch = FetchType.LAZY)
    private VehicleType vehicleType;

    public Vehicle() {
    }

    public Vehicle(String model, String licensePlate, int passenger_capacity, BigDecimal weight_capacity) {
        this.model = model;
        this.licensePlate = licensePlate;
        this.passenger_capacity = passenger_capacity;
        this.weight_capacity = weight_capacity;
    }

    public Vehicle(String model, String licensePlate, int passenger_capacity, BigDecimal weight_capacity, VehicleType vehicleType) {
        this.model = model;
        this.licensePlate = licensePlate;
        this.passenger_capacity = passenger_capacity;
        this.weight_capacity = weight_capacity;
        this.vehicleType = vehicleType;
    }

    public Vehicle(String model, String licensePlate, int passenger_capacity, BigDecimal weight_capacity, Company company, VehicleType vehicleType) {
        this.model = model;
        this.licensePlate = licensePlate;
        this.passenger_capacity = passenger_capacity;
        this.weight_capacity = weight_capacity;
        this.company = company;
        this.vehicleType = vehicleType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getPassenger_capacity() {
        return passenger_capacity;
    }

    public void setPassenger_capacity(int passenger_capacity) {
        this.passenger_capacity = passenger_capacity;
    }

    public BigDecimal getWeight_capacity() {
        return weight_capacity;
    }

    public void setWeight_capacity(BigDecimal weight_capacity) {
        this.weight_capacity = weight_capacity;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", licensePlate='" + licensePlate + '\''+
                '}';
    }

}
