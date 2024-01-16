package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "transport")
public class Transport {

    @Id
    @Column(name="id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Starting point name cannot be blank!")
    @Column(name="starting_point", nullable = false)
    private String startingPoint;

    @NotBlank(message = "Destination name cannot be blank!")
    @Column(name="destination", nullable = false)
    private String destination;

    @Column(name="departure_date", nullable = false)
    private LocalDate departureDate;

    @Column(name="arrival_date", nullable = false)
    private LocalDate arrivalDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @ManyToMany
    private Set<CargoType> cargoTypes;

    public Transport() {
    }

    public Transport(String startingPoint, String destination, LocalDate departureDate, LocalDate arrivalDate) {
        this.startingPoint = startingPoint;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public Transport(String startingPoint, String destination, LocalDate departureDate, LocalDate arrivalDate, Vehicle vehicle, Category category) {
        this.startingPoint = startingPoint;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.vehicle = vehicle;
        this.category = category;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Set<CargoType> getCargoTypes() {
        return cargoTypes;
    }

    public void setCargoTypes(Set<CargoType> cargoTypes) {
        this.cargoTypes = cargoTypes;
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

