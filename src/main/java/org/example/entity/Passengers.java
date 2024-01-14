package org.example.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "passengers")
public class Passengers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int count;

    private BigDecimal price_per_person;

    @OneToMany(mappedBy = "passengers")
    private Set<CargoType> cargoTypes;
}