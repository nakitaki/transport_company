package org.example.dao;

import jakarta.persistence.criteria.*;
import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Company;
import org.example.entity.Employee;
import org.example.exceptions.CompanyNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

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
            companyList.stream().forEach(session::persist);
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

    public static List<Company> readCompanies1(){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);

            cr.select(root);

            Query<Company> query = session.createQuery(cr);
            return query.getResultList();
        }
    }

    public static void updateCompany(Company company){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(company);
            transaction.commit();
        }
    }

    public static void deleteCompany(Company company){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(company);
            transaction.commit();
        }
    }

    public static List<Company> companiesFindByInitialCapitalBetween(BigDecimal top, BigDecimal bottom){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);

            cr.select(root).where(cb.between(root.get("initialCapital"), top, bottom));

            Query<Company> query = session.createQuery(cr);
            List<Company> companies = query.getResultList();
            return companies;
        }
    }

    public static List<Company> findByWithNameStartingWithInitialCapitalGreaterThan(String name, BigDecimal capital){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Company> query = builder.createQuery(Company.class);
            Root<Company> root = query.from(Company.class);

            Predicate greaterThanInitialCapital = builder.greaterThan(root.get("initialCapital"), capital);
            Predicate nameStartingWith = builder.like(root.get("name"), name + "%");

            query.select(root).where(builder.and(greaterThanInitialCapital,nameStartingWith));

            Query<Company> q = session.createQuery(query);
            List<Company> companies = q.getResultList();
            return companies;
        }
    }

    public static BigDecimal sumInitialCapital(){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
            Root<Company> root = query.from(Company.class);

            query.select(builder.sum(root.get("initialCapital")));

            Query<BigDecimal> q = session.createQuery(query);
            BigDecimal result = q.getSingleResult();
            return result;
        }
    }

    //EMPLOYEES
    public static Set<Employee> getCompanyEmployees(long companyId) {
        Company company;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Company> query = builder.createQuery(Company.class);
            Root<Company> root = query.from(Company.class);

            root.fetch("employees", JoinType.INNER); // Eagerly fetch employees

            query.select(root);
            query.where(builder.equal(root.get("id"), companyId));

            company = session.createQuery(query).getSingleResult();
        }
        return company.getEmployees();
    }










}
