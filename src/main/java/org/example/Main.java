package org.example;

import org.example.configuration.SessionFactoryUtil;
import org.example.dao.*;
import org.example.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactoryUtil.getSessionFactory().openSession();

        Company company1 = new Company("SAP", LocalDate.of(2000,01,01));
        Category category = new Category("B");
        Driver driver12 = new Driver("Krischo", BigDecimal.valueOf(3000));
        VehicleType vehicleType = new VehicleType("truck");
        Vehicle vehicle = new Vehicle("Audi a5", "CA 1558 AX", 20, BigDecimal.valueOf(30), company1, vehicleType);
        Transport transport = new Transport("Etropole", "Sofia", LocalDate.of(2024,01,01), LocalDate.of(2024,01,05), company1, vehicle, category, driver12);

//        VehicleTypeDao.readVehicleTypes().forEach(System.out::println);
        VehicleDao.readVehicles().forEach(System.out::println);
//        CompanyDao.createCompany(company1);
//        CategoryDao.createCategory(category);
//        DriverDao.createDriver(driver12);
//        VehicleTypeDao.createVehicleType(vehicleType);
//        VehicleDao.createVehicle(vehicle);
//        TransportDao.createTransport(transport);


//        TransportDao.getTransportsDTO().stream().forEach(System.out::println);

//        Driver driver1 = new Driver("Kris", BigDecimal.valueOf(5000));
//        Driver driver2 = new Driver("Iv", BigDecimal.valueOf(4000));
//        Driver driver3 = new Driver("Dan", BigDecimal.valueOf(6000));
//        Driver driver4 = new Driver("Kam", BigDecimal.valueOf(4000));


//        DriverDao.readDrivers().stream().forEach(System.out::println);
//        DriverDao.createDriver(driver1);
//        DriverDao.createDriver(driver2);
//        DriverDao.createDriver(driver3);
//
//        DriverDao.updateDriver(driver4);

//        DriverDao.deleteDriver(DriverDao.getDriverById(4));

//        TransportDao.getTransportsDTO().stream().forEach(System.out::println);


//        System.out.println(TransportDao.getTransports());
//        Company company1 = new Company("SAP", LocalDate.of(2000,01,01));
//        Company company2 = new Company("Nestle", LocalDate.of(2012,11,19));
//        Company company3 = new Company("Pisnami", LocalDate.of(2012,11,19));
//
////        SAVE COMPANIES
//        List<Company> companies = new ArrayList<>();
//        companies.add(company2);
//        companies.add(company3);
//        CompanyDao.saveCompanies(companies);
//
////        //CREATE COMPANY
//        CompanyDao.createCompany(company1);
////
//////        //GET COMPANY BY ID
//        System.out.println(CompanyDao.getCompanyById(2));
////
//////        //SOUT COMPANIES
//        CompanyDao.readCompanies().stream().forEach(System.out::println);
////
//////        //UPDATE COMPANY
//        company2.setId(3);
//        CompanyDao.updateCompany(company2);
////
////        //DELETE COMPANY
//        Company company4 = CompanyDao.getCompanyById(3);
//        CompanyDao.deleteCompany(company4);

//        CompanyDao.companiesFindByInitialCapitalBetween(BigDecimal.valueOf(1000), BigDecimal.valueOf(3000));
//
//        System.out.println("---------------------------------------------");
//        CompanyDao.findByWithNameStartingWithInitialCapitalGreaterThan("Le",BigDecimal.valueOf(1000))
//                .stream().forEach(System.out::println);
//
//
//        System.out.println("---------------------------------------------");
//        System.out.println(CompanyDao.sumInitialCapital());
//
//        CompanyDao.readCompanies().forEach(System.out::println);
//        System.out.println("---------------------------------------------");
//        CompanyDao.readCompanies1().forEach(System.out::println);
//
////        CompanyDao.getCompanyEmployees(1).stream().forEach(System.out::println);
//
//        Driver driver12 = new Driver("Krischoy", BigDecimal.valueOf(3000));
//
//        Package packagge = new Package(BigDecimal.valueOf(2), BigDecimal.valueOf(4.55));
//        CargoType cargoType = new CargoType(packagge);
//        System.out.println(cargoType);
//
//        VehicleType vehicleType = new VehicleType("truck");
//        Vehicle vehicle = new Vehicle("Audi a5", "CA 1558 AX", 20, BigDecimal.valueOf(30), company1, vehicleType);
//        System.out.println(vehicle);
//
//        VehicleDao.updateVehicle(vehicle);
////        VehicleDao.readVehicles();

    }
}