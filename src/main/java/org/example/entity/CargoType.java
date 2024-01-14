package org.example.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cargo_type")
public class CargoType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Package aPackage;

    @ManyToOne(fetch = FetchType.LAZY)
    private Passengers passengers;

    @ManyToMany(mappedBy = "cargoTypes")
    private Set<Transport> transports;

    public CargoType() {
    }

    public CargoType(Package aPackage) {
        this.aPackage = aPackage;
    }

    public CargoType(Package aPackage, Passengers passengers) {
        this.aPackage = aPackage;
        this.passengers = passengers;
    }


    @Override
    public String toString() {
        return "CargoType{" +
                "id=" + id +
                ", aPackage=" + aPackage +
                ", passengers=" + passengers +
                '}';
    }
}
