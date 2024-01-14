package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDao {
    public static void createEmployee(Employee employee){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
        }
    }

    public static Employee getEmployeeById(long id){
        Employee employee;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);
            transaction.commit();
        }
        return employee;
    }

    public static void saveEmployees(List<Employee> employeeList){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            employeeList.stream().forEach(session::persist);
            transaction.commit();
        }
    }

    public static List<Employee> readEmployees(){
        List<Employee> employees;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            employees =  session.createQuery("SELECT c FROM Employee c", Employee.class)
                    .getResultList();
            transaction.commit();
        }
        return employees;
    }

    public static void updateEmployee(Employee employee){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        }
    }

    public static void deleteEmployee(Employee employee){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(employee);
            transaction.commit();
        }
    }


}
