package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Driver;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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


}
