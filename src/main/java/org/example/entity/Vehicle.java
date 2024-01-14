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

    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "vehicle")
    private Set<Transport> transports;

    @ManyToOne
    private VehicleType vehicleType;


}
