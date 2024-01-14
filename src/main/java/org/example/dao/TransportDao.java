package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Transport;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TransportDao {
    public static void createTransport(Transport transport){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(transport);
            transaction.commit();
        }
    }

    public static Transport getTransportById(long id){
        Transport transport;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            transport = session.get(Transport.class, id);
            transaction.commit();
        }
        return transport;
    }

    public static void saveTransports(List<Transport> transportList){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            transportList.stream().forEach(session::persist);
            transaction.commit();
        }
    }

    public static List<Transport> readTransports(){
        List<Transport> transports;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            transports =  session.createQuery("SELECT c FROM Transport c", Transport.class)
                    .getResultList();
            transaction.commit();
        }
        return transports;
    }

    public static void updateTransport(Transport transport){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(transport);
            transaction.commit();
        }
    }

    public static void deleteTransport(Transport transport){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(transport);
            transaction.commit();
        }
    }

}
