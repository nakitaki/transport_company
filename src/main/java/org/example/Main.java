package org.example;

import org.example.configuration.SessionFactoryUtil;
import org.example.dao.*;
import org.example.entity.*;
import org.example.exceptions.DriverNotFoundException;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws DriverNotFoundException {

        SessionFactoryUtil.getSessionFactory().openSession();


        Company company1 = new Company("SAP", LocalDate.of(2000,01,01));
        //ADD CATEGORY TO DRIVER
        Category category1 = new Category("B");
        Category category2 = new Category("C");
        CategoryDao.saveOrUpdateCategory(category1);
        CategoryDao.saveOrUpdateCategory(category2);
        VehicleType vehicleType = new VehicleType("car");
        Vehicle vehicle1 = new Vehicle("Audi a5", "CA 1558 AX", 4, BigDecimal.valueOf(30), company1, vehicleType);
        Driver driver1 = new Driver("Krischo", BigDecimal.valueOf(3000), company1);
        Driver driver2 = new Driver("Ivcho", BigDecimal.valueOf(2000),company1);
        driver1.setId(1);
        CompanyDao.createCompany(company1);
        VehicleTypeDao.createVehicleType(vehicleType);
        VehicleDao.createVehicle(vehicle1);
        DriverDao.saveOrUpdateDriver(driver1);
        DriverDao.saveOrUpdateDriver(driver2);
        DriverDao.addCategoryToDriver(CategoryDao.getCategoryById(1), driver1);
        DriverDao.addCategoryToDriver(CategoryDao.getCategoryById(2), driver1);
        DriverDao.addCategoryToDriver(CategoryDao.getCategoryById(2), driver2);
        DriverDao.saveOrUpdateDriver(driver1);
        DriverDao.saveOrUpdateDriver(driver2);



        DriverDao.DriverCategories(driver1.getId()).forEach(System.out::println);
        DriverDao.DriverCategories(driver2.getId()).forEach(System.out::println);

//        System.out.println(DriverDao.countDriverCategories(driver1.getId()));
//        System.out.println(DriverDao.countDriverCategories(driver2.getId()));

//        DriverDao.orderByCategoriesCount().forEach(System.out::println);
        DriverDao.getDriversDTO().forEach(System.out::println);

//        CompanyDao.companyDriversAndCategories(1);

//        CompanyDao.companyDriversAndCategories(1).forEach((driver, categories) -> {
//            System.out.print(driver.getName());
//            System.out.println(categories);
//        });

////////////////////////////////////////////////////////////////////
        Transport transport = new Transport("Etropole", "zSofia", LocalDate.of(2024,01,01), LocalDate.of(2024,01,05), company1,vehicle1, category1, driver1);
        Transport transport1 = new Transport("Etropole", "Sofia", LocalDate.of(2020,10,20), LocalDate.of(2020,10,21), company1,vehicle1, category1, driver1);
        Transport transport2 = new Transport("Sofia", "Etropole", LocalDate.of(2021,10,20), LocalDate.of(2021,10,21), company1,vehicle1, category1, driver1);


//
        TransportDao.createTransport(transport);
        TransportDao.createTransport(transport1);
        TransportDao.createTransport(transport2);

        System.out.println("here1");
//        TransportDao.orderByDestinationDto().forEach(System.out::println);
        TransportDao.getTransportsDTO().forEach(System.out::println);
        System.out.println("here2");
        TransportDao.orderByDestination().forEach(System.out::println);

//
//        CompanyDao.getCompaniesDTO().forEach(System.out::println);
////
//        Passengers passengers = new Passengers(10, BigDecimal.valueOf(3));
//        Passengers passengers1 = new Passengers(30, BigDecimal.valueOf(3));
//        CargoType cargoType = new CargoType(passengers);
//        CargoType cargoType1 = new CargoType(passengers1);
////
//        PassengersDao.createPassengers(passengers);
//        PassengersDao.createPassengers(passengers1);
//        CargoTypeDao.saveOrUpdateCargoType(cargoType);
//        CargoTypeDao.saveOrUpdateCargoType(cargoType1);
////
//        TransportDao.addCargoToTransport(CargoTypeDao.getCargoTypeById(1), transport1);
//        TransportDao.addCargoToTransport(CargoTypeDao.getCargoTypeById(2), transport1);
//        TransportDao.saveOrUpdateTransport(transport1);

////////////////////////////////////////////////////////////////////////////////////////////




//
//        Set<Category> categorySet = new HashSet<>();
//        categorySet.add(CategoryDao.getCategoryById(1));
//        driver12.setCategories(categorySet);
//
//        DriverDao.updateDriver(driver12);
//
//        HashSet<Category> qualificationTypesEmployee1 = new HashSet<>();
//        qualificationTypesEmployee1.add(CategoryDao.getCategoryById(4));
//        qualificationTypesEmployee1.add(CategoryDao.getCategoryById(1));
//
//        Driver employee1 = new Driver("Krischo", BigDecimal.valueOf(3000));
//        employee1.setId(1);
////        employee1.setCompany(company1);
//        employee1.setCategories(qualificationTypesEmployee1);
//        DriverDao.saveOrUpdateDriver(employee1);




//        Company company1 = new Company("Speedy", LocalDate.of(1999,02,02));
//        Company company2 = new Company("Econt", LocalDate.of(2010,12,20));
////        company1.setId(1);
//        Driver driver1 = new Driver("Krischo", BigDecimal.valueOf(5000));
//        Driver driver2 = new Driver("Ivcho", BigDecimal.valueOf(2000));
//        Driver driver3 = new Driver("Dan", BigDecimal.valueOf(4000));
//        driver1.setCompany(company1);
//        driver2.setCompany(company1);
//        Category category = new Category("B");
//        VehicleType vehicleType = new VehicleType("car");
//        Vehicle vehicle1 = new Vehicle("Audi a5", "CA 1558 AX", 4, BigDecimal.valueOf(30), company1, vehicleType);
//        Vehicle vehicle2 = new Vehicle("Audi a3", "CA 1523 AX", 5, BigDecimal.valueOf(10), company1, vehicleType);
//        Transport transport = new Transport("Etropole", "Sofia", LocalDate.of(2024,01,01), LocalDate.of(2024,11,05), company1, vehicle1, category, driver1);
//        Transport transport1 = new Transport("Etropole", "Sofia", LocalDate.of(2020,10,20), LocalDate.of(2020,10,21), company1, vehicle1, category,driver1);
//        Transport transport2 = new Transport("Sofia", "Etropole", LocalDate.of(2021,10,20), LocalDate.of(2021,10,21), company2,vehicle2,category,driver1);
////
////
//        CompanyDao.createCompany(company1);
//        CompanyDao.createCompany(company2);
//
//        DriverDao.saveOrUpdateDriver(driver1);
//        DriverDao.saveOrUpdateDriver(driver2);
//        DriverDao.saveOrUpdateDriver(driver3);
//
//
//        CompanyDao.getCompaniesDTO().forEach(System.out::println);
//        CompanyDao.readCompanies().forEach(System.out::println);
//        CategoryDao.createCategory(category);
//        VehicleTypeDao.createVehicleType(vehicleType);
//        VehicleDao.createVehicle(vehicle1);
//        VehicleDao.createVehicle(vehicle2);
//
//        TransportDao.createTransport(transport);
//        TransportDao.createTransport(transport1);
//        TransportDao.createTransport(transport2);

//        TransportDao.getTransportsDTO().stream().forEach(System.out::println);
//        TransportDao.getTransports().stream().forEach(System.out::println);

//        CompanyDao.getCompanyDriversDTO(1).forEach(System.out::println);
//        DriverDao.getDriversDTO().forEach(System.out::println);
//        VehicleTypeDao.readVehicleTypes().forEach(System.out::println);
//        VehicleDao.getVehiclesDTO().forEach(System.out::println);
//        VehicleDao.readVehicles().forEach(System.out::println);
//        CompanyDao.createCompany(company1);


//        CategoryDao.createCategory(category);

//        System.out.println(PassengersDao.calculateCostForPassengersById(1));

//        Package pack = new Package(BigDecimal.valueOf(10), BigDecimal.valueOf(0.3));
//        PackageDao.createPackage(pack);

//        CargoType cargoType = CargoTypeDao.getCargoTypeById(1);
//        cargoType.setPaid(false);
//        CargoTypeDao.saveOrUpdateCargoType(cargoType);

//        System.out.println(CostumerDao.getUnpaidCargosForClient(1));
//        System.out.println("-------------------------------------------------");
//        CompanyDao.getFinishedTransports(3).forEach(System.out::println);
//        System.out.println("-------------------------------------------------");
//        System.out.println(CompanyDao.sumIncomeById(3));
//        System.out.println("-------------------------------------------------");
//        System.out.println(CompanyDao.sumIncomeById(1));
//        System.out.println(CompanyDao.sumIncomeById(2));
//        System.out.println(CompanyDao.sumIncomeById(3));
//        System.out.println("-------------------------------------------------");
//
//        CompanyDao.orderByIncome().forEach(System.out::println);

//        CompanyDao.findByWithNameStartingWith("To").forEach(System.out::println);
//        System.out.println(PackageDao.calculateCostForPackageById(3));
//        System.out.println(PassengersDao.calculateTotalCost());
//        System.out.println(CargoTypeDao.totalCost(2));
//        System.out.println(CargoTypeDao.costFromPackage(2));
//        System.out.println(CargoTypeDao.costFromPassengers(2));
//        Passengers passengers = new Passengers(10, BigDecimal.valueOf(3));
//        System.out.println(passengers.getPricePerPerson());
//        VehicleTypeDao.createVehicleType(vehicleType);
//        VehicleDao.createVehicle(vehicle);
//        TransportDao.createTransport(transport);

//        CompanyDao.OrderByName().forEach(System.out::println);


//        CompanyDao.getFinishedTransports(1).forEach(System.out::println);
//        System.out.println("finishedTransports");
//        CompanyDao.getCompanyTransports(1).forEach(System.out::println);
//        System.out.println("all transports");

//        CompanyDao.orderByNameAsc().forEach(System.out::println);
//        CompanyDao.orderByNameDesc().forEach(System.out::println);

//        DriverDao.getDriversDTO().forEach(System.out::println);
//        DriverDao.orderBySalaryAsc().forEach(System.out::println);
//        DriverDao.orderBySalaryDesc().forEach(System.out::println);
//        CompanyDao.TransportFromCompany(1).forEach(System.out::println);
//        TransportDao.cargosFromTransport(5).forEach(System.out::println);
//        System.out.println(TransportDao.costFromTransport(5));

//        CargoTypeDao.payCargo(CargoTypeDao.getCargoTypeById(1));


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