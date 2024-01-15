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

    public Package() {
    }

    public Package(BigDecimal weight_kg, BigDecimal price_per_kg) {
        this.weight_kg = weight_kg;
        this.price_per_kg = price_per_kg;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getWeight_kg() {
        return weight_kg;
    }

    public void setWeight_kg(BigDecimal weight_kg) {
        this.weight_kg = weight_kg;
    }

    public BigDecimal getPrice_per_kg() {
        return price_per_kg;
    }

    public void setPrice_per_kg(BigDecimal price_per_kg) {
        this.price_per_kg = price_per_kg;
    }

    public Set<CargoType> getCargoTypes() {
        return cargoTypes;
    }

    public void setCargoTypes(Set<CargoType> cargoTypes) {
        this.cargoTypes = cargoTypes;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", weight_kg=" + weight_kg +
                '}';
    }
}
