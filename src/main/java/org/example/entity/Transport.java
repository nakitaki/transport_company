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

    private String startingPoint;

    private String destination;

    private LocalDate departureDate;

    private LocalDate arrivalDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @ManyToMany(mappedBy = "transports")
    private Set<CargoType> cargoTypes;

    public Transport() {
    }

    public Transport(String startingPoint, String destination, LocalDate departureDate, LocalDate arrivalDate) {
        this.startingPoint = startingPoint;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }


    public Transport(String startingPoint, String destination, LocalDate departureDate, LocalDate arrivalDate, Company company, Vehicle vehicle, Category category, Driver driver) {
        this.startingPoint = startingPoint;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.company = company;
        this.vehicle = vehicle;
        this.category = category;
        this.driver = driver;
    }


    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", starting_point='" + startingPoint + '\'' +
                ", end_point='" + destination + '\'' +
                ", departure_date=" + departureDate +
                ", arrival_date=" + arrivalDate +
                '}';
    }
}

//TODO Set<CargoType>?????
