package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.CargoType;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.List;

public class CargoTypeDao {
    public static void createCargoType(CargoType cargoType){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(cargoType);
            transaction.commit();
        }
    }

    public static CargoType getCargoTypeById(long id){
        CargoType cargoType;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            cargoType = session.get(CargoType.class, id);
            transaction.commit();
        }
        return cargoType;
    }

    public static void saveCargoTypes(List<CargoType> cargoTypeList){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            cargoTypeList.stream().forEach(session::persist);
            transaction.commit();
        }
    }

    public static List<CargoType> readCargoTypes(){
        List<CargoType> cargoTypes;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            cargoTypes =  session.createQuery("SELECT c FROM CargoType c", CargoType.class)
                    .getResultList();
            transaction.commit();
        }
        return cargoTypes;
    }

    public static void updateCargoType(CargoType cargoType){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(cargoType);
            transaction.commit();
        }
    }

    public static void deleteCargoType(CargoType cargoType){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(cargoType);
            transaction.commit();
        }
    }

    public static void saveOrUpdateCargoType(CargoType cargoType) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(cargoType);
            transaction.commit();
        }
    }



}
