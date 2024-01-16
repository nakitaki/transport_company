package org.example.dao;

import jakarta.persistence.criteria.*;
import org.example.configuration.SessionFactoryUtil;
import org.example.dto.DriverDto;
import org.example.dto.DriverDto;
import org.example.entity.*;
import org.example.exceptions.DriverNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.*;

public class DriverDao {
    public static void createDriver(Driver driver){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(driver);
            transaction.commit();
        }
    }

    public static Driver getDriverById(long id){
        Driver driver;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            driver = session.get(Driver.class, id);
            transaction.commit();
        }
        return driver;
    }

    public static void saveDrivers(List<Driver> driverList){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            driverList.stream().forEach(session::persist);
            transaction.commit();
        }
    }

    public static List<Driver> readDrivers(){
        List<Driver> drivers;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            drivers =  session.createQuery("SELECT c FROM Driver c", Driver.class)
                    .getResultList();
            transaction.commit();
        }
        return drivers;
    }

    public static void updateDriver(Driver driver){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(driver);
            transaction.commit();
        }
    }

    public static void deleteDriver(Driver driver){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(driver);
            transaction.commit();
        }
    }

    public static void saveOrUpdateDriver(Driver driver){
        if(driver == null){
            throw new IllegalArgumentException("The driver cannot be null");
        }
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.merge(driver);
            transaction.commit();
        }
    }

    public static List<DriverDto> getDriversDTO() {
        List<DriverDto> driverDtos;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            driverDtos = session
                    .createQuery("select new org.example.dto.DriverDto(i.id, i.name, i.salary, i.company) " +
                            "from Driver i", DriverDto.class)
                    .getResultList();
            transaction.commit();
        }
        return driverDtos;
    }

    public static void addCategoryToDriver(Category category, Driver driver) throws DriverNotFoundException {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            if(driver == null) {
                throw new DriverNotFoundException("Driver should not be null");
            }
            if(driver.getCategories() == null){
                Set<Category> categories = new HashSet<>();
                driver.setCategories(categories);

            }
            driver.getCategories().add(category);

            CategoryDao.saveOrUpdateCategory(category);
            DriverDao.saveOrUpdateDriver(driver);

            transaction.commit();
        }
    }

    public static List<Driver> orderBySalaryAsc() {
        List<Driver> drivers;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Driver> criteriaQuery = builder.createQuery(Driver.class);
            Root<Driver> root = criteriaQuery.from(Driver.class);

            criteriaQuery.select(root)
                    .orderBy(builder.asc(root.get("salary")));

            Query<Driver> query = session.createQuery(criteriaQuery);
            drivers = query.getResultList();
            transaction.commit();
        }

        return drivers;
    }

    public static List<Driver> orderBySalaryDesc() {
        List<Driver> drivers;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Driver> criteriaQuery = builder.createQuery(Driver.class);
            Root<Driver> root = criteriaQuery.from(Driver.class);

            criteriaQuery.select(root)
                    .orderBy(builder.desc(root.get("salary")));

            Query<Driver> query = session.createQuery(criteriaQuery);
            drivers = query.getResultList();
            transaction.commit();
        }

        return drivers;
    }


    public static List<Category> DriverCategories(long driverID) {
        List<Category> categories;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Category> cr = cb.createQuery(Category.class);
            Root<Category> root = cr.from(Category.class);
            Join<Category, Driver> join = root.join("drivers");

            cr.select(root).where(cb.equal(join.get("id"), driverID));

            Query<Category> query = session.createQuery(cr);
            categories = query.getResultList();
        }
        return categories;
    }

    public static int countDriverCategories(long driverID) {
        return DriverDao.DriverCategories(driverID).size();
    }

    public static List<Driver> orderByCategoriesCount() {
        List<Driver> drivers;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            drivers = session.createQuery("FROM Driver d", Driver.class).getResultList();

            drivers.sort(Comparator.comparing(driver -> countDriverCategories(driver.getId())));
            transaction.commit();
        }
        return drivers;
    }






}
