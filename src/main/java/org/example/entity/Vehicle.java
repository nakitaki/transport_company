package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Company name cannot be blank!")
    @Pattern(regexp = "^[A-Z].*", message = "Vehicle model should start with a capital letter!")
    @Column(name="model", nullable = false)
    private String model;

    @Column(name="license_plate", nullable = false)
    @Pattern(regexp = "^[A-Z0-9]+$", message = "The value should contain only uppercase letters and numbers.")
    private String licensePlate;

    @Column(name="passenger_capacity")
    private int passengerCapacity;

    @Column(name="weight_capacity")
    private BigDecimal weightCapacity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @OneToMany(mappedBy = "vehicle")
    private Set<Transport> transports;

    @ManyToOne(fetch = FetchType.LAZY)
    private VehicleType vehicleType;

    public Vehicle() {
    }

    public Vehicle(String model, String licensePlate, int passengerCapacity, BigDecimal weightCapacity) {
        this.model = model;
        this.licensePlate = licensePlate;
        this.passengerCapacity = passengerCapacity;
        this.weightCapacity = weightCapacity;
    }

    public Vehicle(String model, String licensePlate, int passengerCapacity, BigDecimal weightCapacity, VehicleType vehicleType) {
        this.model = model;
        this.licensePlate = licensePlate;
        this.passengerCapacity = passengerCapacity;
        this.weightCapacity = weightCapacity;
        this.vehicleType = vehicleType;
    }

    public Vehicle(String model, String licensePlate, int passengerCapacity, BigDecimal weightCapacity, Company company, VehicleType vehicleType) {
        this.model = model;
        this.licensePlate = licensePlate;
        this.passengerCapacity = passengerCapacity;
        this.weightCapacity = weightCapacity;
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

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passenger_capacity) {
        this.passengerCapacity = passenger_capacity;
    }

    public BigDecimal getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(BigDecimal weight_capacity) {
        this.weightCapacity = weight_capacity;
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
