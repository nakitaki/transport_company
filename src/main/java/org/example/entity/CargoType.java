package org.example.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.UniqueElements;

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

//    @ManyToMany(mappedBy = "cargoTypes")
//    private Set<Transport> transports;


    @OneToOne//(unique = true) //TODO
//    @UniqueElements
    private CargoDetails cargoDetails;

    public CargoType() {
    }

    public CargoType(Package aPackage) {
        this.aPackage = aPackage;
    }

    public CargoType(Passengers passengers) {
        this.passengers = passengers;
    }

    public CargoType(Package aPackage, Passengers passengers) {
        this.aPackage = aPackage;
        this.passengers = passengers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Package getAPackage() {
        return aPackage;
    }

    public void setAPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    public Passengers getPassengers() {
        return passengers;
    }

    public void setPassengers(Passengers passengers) {
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
