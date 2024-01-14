package org.example.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "vehicle_type")
public class VehicleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String type;

    @OneToMany(mappedBy = "vehicleType")
    private Set<Vehicle> vehicles;

    public VehicleType() {
    }

    @Override
    public String toString() {
        return "VehicleType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
