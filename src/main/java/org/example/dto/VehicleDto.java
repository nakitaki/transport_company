package org.example.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.example.entity.Company;
import org.example.entity.Transport;
import org.example.entity.VehicleType;

import java.math.BigDecimal;
import java.util.Set;

public class VehicleDto {
    private long id;

    private String model;

    private String licensePlate;

    private VehicleType vehicleType;

    public VehicleDto(long id, String model, String licensePlate, VehicleType vehicleType) {
        this.id = id;
        this.model = model;
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "VehicleDto{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", vehicleType=" + vehicleType.getType() +
                '}';
    }
}
