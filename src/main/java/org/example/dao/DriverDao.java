package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.dto.DriverDto;
import org.example.dto.DriverDto;
import org.example.entity.Category;
import org.example.entity.Driver;
import org.example.exceptions.DriverNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DriverDao {
    public static void createDriver(Driver driver){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(driver);
            transaction.commit();
        }
    }

    public static Driver getDriverById(long id){
        Driver driver;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            driver = session.get(Driver.class, id);
            transaction.commit();
        }
        return driver;
    }

    public static void saveDrivers(List<Driver> driverList){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            driverList.stream().forEach(session::persist);
            transaction.commit();
        }
    }

    public static List<Driver> readDrivers(){
        List<Driver> drivers;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            drivers =  session.createQuery("SELECT c FROM Driver c", Driver.class)
                    .getResultList();
            transaction.commit();
        }
        return drivers;
    }

    public static void updateDriver(Driver driver){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(driver);
            transaction.commit();
        }
    }

    public static void deleteDriver(Driver driver){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(driver);
            transaction.commit();
        }
    }

    public static void saveOrUpdateDriver(Driver driver){
        if(driver == null){
            throw new IllegalArgumentException("The driver cannot be null");
        }
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.merge(driver);
            transaction.commit();
        }
    }

    public static List<DriverDto> getDriversDTO() {
        List<DriverDto> driverDtos;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            driverDtos = session
                    .createQuery("select new org.example.dto.DriverDto(i.id, i.name, i.salary, i.company) " +
                            "from Driver i", DriverDto.class)
                    .getResultList();
            transaction.commit();
        }
        return driverDtos;
    }

    public static void addCategoryToDriver(Category category, Driver driver) throws DriverNotFoundException {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            if(driver == null) {
                throw new DriverNotFoundException("Driver should noxt be null");
            }
            if(driver.getCategories() == null){
                Set<Category> categories = new HashSet<>();
                driver.setCategories(categories);

            }
            driver.getCategories().add(category);
            // if the qualification is not in the database => add it; same for the driver
            CategoryDao.saveOrUpdateCategory(category);
            DriverDao.saveOrUpdateDriver(driver);

            transaction.commit();
        }
    }




}
