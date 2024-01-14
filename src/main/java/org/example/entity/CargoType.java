package org.example.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cargo_type")
public class CargoType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Package aPackage;

    @ManyToOne
    private Passengers passengers;

    @ManyToMany(mappedBy = "cargoTypes")
    private Set<Transport> transports;

}
