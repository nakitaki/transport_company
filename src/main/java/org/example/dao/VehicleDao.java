package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VehicleDao {

    public static void createVehicle(Vehicle vehicle){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(vehicle);
            transaction.commit();
        }
    }

    public static Vehicle getVehicleById(long id){
        Vehicle vehicle;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            vehicle = session.get(Vehicle.class, id);
            transaction.commit();
        }
        return vehicle;
    }

    public static void saveVehicles(List<Vehicle> vehicleList){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            vehicleList.stream().forEach(session::persist);
            transaction.commit();
        }
    }

    public static List<Vehicle> readVehicles(){
        List<Vehicle> vehicles;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            vehicles =  session.createQuery("SELECT c FROM Vehicle c", Vehicle.class)
                    .getResultList();
            transaction.commit();
        }
        return vehicles;
    }

    public static void updateVehicle(Vehicle vehicle){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(vehicle);
            transaction.commit();
        }
    }

    public static void deleteVehicle(Vehicle vehicle){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(vehicle);
            transaction.commit();
        }
    }

}
