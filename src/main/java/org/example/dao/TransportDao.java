package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.dto.TransportDto;
import org.example.entity.CargoType;
import org.example.entity.Transport;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            transports =  session.createQuery("SELECT t FROM Transport t", Transport.class)
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

    public static void saveOrUpdateTransport(Transport transport) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(transport);
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
            transports = session.createQuery("Select t From Transport t", Transport.class)
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
                    .createQuery("select new org.example.dto.TransportDto(t.id, t.startingPoint, t.destination," +
                            " t.departureDate, t.arrivalDate, t.vehicle, t.driver) " +
                            "from Transport t", TransportDto.class)
                    .getResultList();
            transaction.commit();
        }
        return transportDtos;
    }

    public static void addCargoToTransport(CargoType cargo, Transport transport) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            if (transport == null) {
                transport = new Transport();
            }
            if (transport.getCargoTypes() == null){
                Set<CargoType> cargos = new HashSet<>();
                transport.setCargoTypes(cargos);
            }
            transport.getCargoTypes().add(cargo);
            // if the cargo is not in the database => add it; same for the driver
            CargoTypeDao.saveOrUpdateCargoType(cargo);
            TransportDao.saveOrUpdateTransport(transport);

            transaction.commit();
        }
    }

//        public static BigDecimal calculateTotalCostForTransport(long transportId) {
//            BigDecimal totalCost = BigDecimal.ZERO;
//            try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
//                Transaction transaction = session.beginTransaction();
//
//                List<BigDecimal> packageCosts = session.createQuery(
//                                "SELECT p.cost FROM CargoType p WHERE p.transport_id = :transportId",
//                                BigDecimal.class)
//                        .setParameter("transportId", transportId)
//                        .getResultList();
//
//                for (BigDecimal cost : packageCosts) {
//                    totalCost = totalCost.add(cost);
//                }
//
//                transaction.commit();
//            }
//            return totalCost;
//        }


}
