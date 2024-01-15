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

    public Passengers() {
    }

    public Passengers(int count, BigDecimal price_per_person) {
        this.count = count;
        this.price_per_person = price_per_person;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getPrice_per_person() {
        return price_per_person;
    }

    public void setPrice_per_person(BigDecimal price_per_person) {
        this.price_per_person = price_per_person;
    }

    public Set<CargoType> getCargoTypes() {
        return cargoTypes;
    }

    public void setCargoTypes(Set<CargoType> cargoTypes) {
        this.cargoTypes = cargoTypes;
    }

    @Override
    public String toString() {
        return "Passengers{" +
//                "id=" + id +
                ", count=" + count +
                '}';
    }
}
