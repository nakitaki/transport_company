package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Company;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CompanyDao {

    public static void createCompany(Company company){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(company);
            transaction.commit();
        }
    }

    public static Company getCompanyById(long id){
        Company company;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            company = session.get(Company.class, id);
            transaction.commit();
        }
        return company;
    }

    public static void saveCompanies(List<Company> companyList){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            companyList.stream().forEach((com)-> session.persist(com));
            transaction.commit();
        }
    }

    public static List<Company> readCompanies(){
        List<Company> companies;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            companies =  session.createQuery("SELECT c FROM Company c", Company.class)
                    .getResultList();
            transaction.commit();
        }
        return companies;
    }

    public static void updateCompany(Company company){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(company);
            transaction.commit();
        }
    }

}
