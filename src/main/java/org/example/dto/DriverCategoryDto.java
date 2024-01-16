package org.example.dto;

import org.example.dao.DriverDao;
import org.example.entity.Category;
import org.example.entity.Driver;

import java.util.List;

public class DriverCategoryDto {
    private Driver driver;
    private List<Category> categories;

    public DriverCategoryDto(Driver driver, List<Category> categories) {
        this.driver = driver;
        this.categories = categories;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "DriverCategoryDto{" +
                "driver=" + driver +
                ", categories=" + categories +
                '}';
    }
}
