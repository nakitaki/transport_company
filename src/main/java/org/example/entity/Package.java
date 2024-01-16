package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "package")
public class Package{
    @Id
    @Column(name="id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @DecimalMin(value = "0.1", message = "Weight should be at least 0.1!")
    @Column(name="weight_kg", nullable = false)
    private BigDecimal weightKg;

    @DecimalMin(value = "1", message = "Price per kg should be at least 1!")
    @Column(name="price_per_kg", nullable = false)
    private BigDecimal pricePerKg;

    @OneToMany(mappedBy = "aPackage")
    private Set<CargoType> cargoTypes;

    public Package() {
    }

    public Package(BigDecimal weightKg, BigDecimal pricePerKg) {
        this.weightKg = weightKg;
        this.pricePerKg = pricePerKg;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(BigDecimal weight_kg) {
        this.weightKg = weight_kg;
    }

    public BigDecimal getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(BigDecimal price_per_kg) {
        this.pricePerKg = price_per_kg;
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
                ", weight_kg=" + weightKg +
                '}';
    }
}
