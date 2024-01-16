package org.example.dto;

import org.example.entity.*;

import java.time.LocalDate;
import java.util.Set;

public class TransportDto {
    private long id;

    private String startingPoint;

    private String destination;

    private LocalDate departureDate;

    private LocalDate arrivalDate;

    private Vehicle vehicle;

    private Driver driver;

    public TransportDto(long id, String startingPoint) {
        this.id = id;
        this.startingPoint = startingPoint;
    }

    public TransportDto(long id, String startingPoint, String destination, LocalDate departureDate, LocalDate arrivalDate, Vehicle vehicle, Driver driver) {
        this.id = id;
        this.startingPoint = startingPoint;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.vehicle = vehicle;
        this.driver = driver;
    }

    public TransportDto(long id, String startingPoint, String destination, LocalDate departureDate, LocalDate arrivalDate) {
        this.id = id;
        this.startingPoint = startingPoint;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
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
                ", vehicle=" + vehicle.getModel() +
                ", driver=" + driver.getName() +
                '}';
    }


//    @Override
//    public String toString() {
//        return "TransportDto{" +
//                "id=" + id +
//                ", startingPoint='" + startingPoint + '\'' +
//                ", destination='" + destination + '\'' +
//                ", departureDate=" + departureDate +
//                ", arrivalDate=" + arrivalDate +
//                '}';
//    }
}
