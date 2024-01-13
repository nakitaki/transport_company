package org.example.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "package")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal weight_kg;

    private BigDecimal price_per_kg;

    @OneToMany(mappedBy = "aPackage")
    private Set<CargoType> cargoTypes;



}
