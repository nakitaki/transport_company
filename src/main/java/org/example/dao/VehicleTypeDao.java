package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.VehicleType;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VehicleTypeDao {
    public static void createVehicleType(VehicleType vehicleType){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(vehicleType);
            transaction.commit();
        }
    }

    public static VehicleType getVehicleTypeById(long id){
        VehicleType vehicleType;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            vehicleType = session.get(VehicleType.class, id);
            transaction.commit();
        }
        return vehicleType;
    }

    public static void saveVehicleTypes(List<VehicleType> vehicleTypeList){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            vehicleTypeList.stream().forEach(session::persist);
            transaction.commit();
        }
    }

    public static List<VehicleType> readVehicleTypes(){
        List<VehicleType> vehicleTypes;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            vehicleTypes =  session.createQuery("SELECT c FROM VehicleType c", VehicleType.class)
                    .getResultList();
            transaction.commit();
        }
        return vehicleTypes;
    }

    public static void updateVehicleType(VehicleType vehicleType){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(vehicleType);
            transaction.commit();
        }
    }

    public static void deleteVehicleType(VehicleType vehicleType){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(vehicleType);
            transaction.commit();
        }
    }

}
