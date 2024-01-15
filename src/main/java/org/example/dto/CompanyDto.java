package org.example.dto;

import jakarta.persistence.*;
import org.example.entity.Driver;
import org.example.entity.Transport;
import org.example.entity.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class CompanyDto {
    private long id;

    private String name;

    public CompanyDto(long id, String name) {
        this.id = id;
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
        return "CompanyDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
