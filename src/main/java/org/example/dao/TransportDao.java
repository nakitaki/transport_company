package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.dto.TransportDto;
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

    public static List<Transport> getTransports() {
        List<Transport> transports;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            transports = session.createQuery("Select i From Transport i", Transport.class)
                    .getResultList();
            transaction.commit();
        }
        return transports;
    }

    public static List<TransportDto> getTransportsDTO() {
        List<TransportDto> transportDtos;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            transportDtos = session
                    .createQuery("select new org.example.dto.TransportDto(i.id, i.startingPoint, i.destination," +
                            " i.departureDate, i.arrivalDate, i.vehicle, i.driver) " +
                            "from Transport i", TransportDto.class)
                    .getResultList();
            transaction.commit();
        }
        return transportDtos;
    }

}
