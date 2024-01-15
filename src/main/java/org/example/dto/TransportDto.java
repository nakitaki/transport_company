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

    public TransportDto(long id, String startingPoint, String destination, LocalDate departureDate, LocalDate arrivalDate, Vehicle vehicle, Driver driver) {
        this.id = id;
        this.startingPoint = startingPoint;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.vehicle = vehicle;
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
}
