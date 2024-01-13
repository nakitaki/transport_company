package org.example.entity;

import jakarta.persistence.*;
import org.hibernate.type.SerializableType;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "transport")
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String starting_point;

    private String end_point;

    private LocalDate departure_date;

    private LocalDate arrival_date;

    private boolean isPaid;

    @ManyToOne
    private TransportCompany company;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Costumer costumer;

    @ManyToOne
    private Employee employee;

    @ManyToMany
    private Set<CargoType> cargoTypes;


}
