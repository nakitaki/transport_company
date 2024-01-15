package org.example.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "costumer")
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private BigDecimal balance;

    @OneToMany(mappedBy = "costumer")
    private Set<CargoDetails> cargoDetails;

    public Costumer() {
    }

    public Costumer(String name) {
        this.name = name;
        this.balance = BigDecimal.ZERO;
    }

    public Costumer(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CargoDetails> getCargoDetails() {
        return cargoDetails;
    }

    public void setCargoDetails(Set<CargoDetails> cargoDetails) {
        this.cargoDetails = cargoDetails;
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
