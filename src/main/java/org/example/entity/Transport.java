package org.example.entity;

import jakarta.persistence.*;

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
    private Company company;

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

    public Transport() {
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", starting_point='" + starting_point + '\'' +
                ", end_point='" + end_point + '\'' +
                ", departure_date=" + departure_date +
                ", arrival_date=" + arrival_date +
                ", isPaid=" + isPaid +
                ", company=" + company +
                ", vehicle=" + vehicle +
                ", category=" + category +
                ", costumer=" + costumer +
                ", employee=" + employee +
                '}';
    }
}
