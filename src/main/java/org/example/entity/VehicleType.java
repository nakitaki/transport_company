package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.CollectionId;

import java.util.Set;

@Entity
@Table(name = "vehicle_type")
public class VehicleType {
    @Id
    @Column(name="id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type", unique = true)
    @Pattern(regexp = "^[a-z_]+$", message = "The vehicle type should contain only lowercase letters and underscores.")
    private String type;

    @OneToMany(mappedBy = "vehicleType")
    private Set<Vehicle> vehicles;

    public VehicleType() {
    }

    public VehicleType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "VehicleType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
