package org.example.dao;

import jakarta.persistence.Query;
import org.example.configuration.SessionFactoryUtil;
import org.example.entity.CargoType;
import org.example.entity.Costumer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CostumerDao {
    public static void createCostumer(Costumer costumer){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(costumer);
            transaction.commit();
        }
    }

    public static Costumer getCostumerById(long id){
        Costumer costumer;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            costumer = session.get(Costumer.class, id);
            transaction.commit();
        }
        return costumer;
    }

    public static void saveCostumers(List<Costumer> costumerList){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            costumerList.stream().forEach(session::persist);
            transaction.commit();
        }
    }

    public static List<Costumer> readCostumers(){
        List<Costumer> costumers;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            costumers =  session.createQuery("SELECT c FROM Costumer c", Costumer.class)
                    .getResultList();
            transaction.commit();
        }
        return costumers;
    }

    public static void updateCostumer(Costumer costumer){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(costumer);
            transaction.commit();
        }
    }

    public static void deleteCostumer(Costumer costumer){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(costumer);
            transaction.commit();
        }
    }

    public static List<CargoType> getUnpaidCargosForClient(long clientId) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            List<CargoType> cargos = new ArrayList<>();

            String hql = "from CargoType ct where ct.costumer.id = :clientId and ct.isPaid = false";
            Query query = session.createQuery(hql);
            query.setParameter("clientId", clientId);
            cargos = query.getResultList();

            transaction.commit();

            return cargos;
        }
    }




}
