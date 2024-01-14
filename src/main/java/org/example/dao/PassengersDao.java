package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Passengers;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PassengersDao {
    public static void createPassengers(Passengers passengers){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(passengers);
            transaction.commit();
        }
    }

    public static Passengers getPassengersById(long id){
        Passengers passengers;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            passengers = session.get(Passengers.class, id);
            transaction.commit();
        }
        return passengers;
    }

    public static void savePassengersList(List<Passengers> passengersList){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            passengersList.stream().forEach(session::persist);
            transaction.commit();
        }
    }

    public static List<Passengers> readPassengersList(){
        List<Passengers> passengersList;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            passengersList =  session.createQuery("SELECT c FROM Passengers c", Passengers.class)
                    .getResultList();
            transaction.commit();
        }
        return passengersList;
    }

    public static void updatePassengers(Passengers passengers){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(passengers);
            transaction.commit();
        }
    }

    public static void deletePassengers(Passengers passengers){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(passengers);
            transaction.commit();
        }
    }

}
