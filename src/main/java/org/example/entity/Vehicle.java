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

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", passenger_capacity=" + passenger_capacity +
                ", weight_capacity=" + weight_capacity +
                ", company=" + company +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
