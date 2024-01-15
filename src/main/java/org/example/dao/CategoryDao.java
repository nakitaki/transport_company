package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryDao {
    public static void createCategory(Category category){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(category);
            transaction.commit();
        }
    }

    public static Category getCategoryById(long id){
        Category category;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            category = session.get(Category.class, id);
            transaction.commit();
        }
        return category;
    }

    public static void saveCategories(List<Category> categoryList){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            categoryList.stream().forEach(session::persist);
            transaction.commit();
        }
    }

    public static List<Category> readCategories(){
        List<Category> categories;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            categories =  session.createQuery("SELECT c FROM Category c", Category.class)
                    .getResultList();
            transaction.commit();
        }
        return categories;
    }

    public static void updateCategory(Category category){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(category);
            transaction.commit();
        }
    }

    public static void deleteCategory(Category category){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(category);
            transaction.commit();
        }
    }

    public static void saveOrUpdateCategory(Category category) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            // it used to be saveOrUpdate(), but it's deprecated
            session.merge(category);
            transaction.commit();
        }
    }

}
