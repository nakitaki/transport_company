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

    private BigDecimal pricePerPerson;

    @OneToMany(mappedBy = "passengers")
    private Set<CargoType> cargoTypes;

    public Passengers() {
    }

    public Passengers(int count, BigDecimal pricePerPerson) {
        this.count = count;
        this.pricePerPerson = pricePerPerson;
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

    public BigDecimal getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(BigDecimal price_per_person) {
        this.pricePerPerson = price_per_person;
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
                "id=" + id +
                ", count=" + count +
                '}';
    }
}
