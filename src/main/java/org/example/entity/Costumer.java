package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "costumer")
public class Costumer {

    @Id
    @Column(name="id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Driver name cannot be blank!")
    @Pattern(regexp = "^[A-Z].*", message = "Company should start with a capital letter!")
    @Column(name="name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "costumer")
    private Set<CargoType> cargoTypes;

    public Costumer() {
    }

    public Costumer(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Costumer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
