package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Package;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PackageDao {
    public static void createPackage(Package aPackage){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(aPackage);
            transaction.commit();
        }
    }

    public static Package getPackageById(long id){
        Package aPackage;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            aPackage = session.get(Package.class, id);
            transaction.commit();
        }
        return aPackage;
    }

    public static void savePackages(List<Package> aPackageList){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            aPackageList.stream().forEach(session::persist);
            transaction.commit();
        }
    }

    public static List<Package> readPackages(){
        List<Package> packages;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            packages =  session.createQuery("SELECT c FROM Package c", Package.class)
                    .getResultList();
            transaction.commit();
        }
        return packages;
    }

    public static void updatePackage(Package aPackage){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(aPackage);
            transaction.commit();
        }
    }

    public static void deletePackage(Package aPackage){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(aPackage);
            transaction.commit();
        }
    }

}
