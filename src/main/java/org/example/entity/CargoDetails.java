package org.example.entity;

import jakarta.persistence.*;

@Entity
public class CargoDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean isPaid;

    @ManyToOne(fetch = FetchType.LAZY)
    private Transport transport;

    @ManyToOne(fetch = FetchType.LAZY)
    private Costumer costumer;

    @OneToOne(mappedBy = "cargoDetails")
    private CargoType cargoType;

    public CargoDetails() {
    }

    public CargoDetails(boolean isPaid, Transport transport, Costumer costumer, CargoType cargoType) {
        this.isPaid = isPaid;
        this.transport = transport;
        this.costumer = costumer;
        this.cargoType = cargoType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    @Override
    public String toString() {
        return "CargoDetails{" +
                "id=" + id +
                ", isPaid=" + isPaid +
                ", transport=" + transport +
                ", costumer=" + costumer +
                ", cargoType=" + cargoType +
                '}';
    }
}
