package org.example.dao;

import jakarta.persistence.criteria.*;
import org.example.configuration.SessionFactoryUtil;
import org.example.dto.CompanyDto;
import org.example.dto.DriverCategoryDto;
import org.example.dto.DriverDto;
import org.example.dto.TransportDto;
import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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

    public static List<CompanyDto> getCompaniesDTO() {
        List<CompanyDto> companiesDtos;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            companiesDtos = session
                    .createQuery("select new org.example.dto.CompanyDto(i.id, i.name) " +
                            "from Company i", CompanyDto.class)
                    .getResultList();
            transaction.commit();
        }
        return companiesDtos;
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

//    public static List<Company> companiesFindByInitialCapitalBetween(BigDecimal top, BigDecimal bottom){
//        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
//            CriteriaBuilder cb = session.getCriteriaBuilder();
//            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
//            Root<Company> root = cr.from(Company.class);
//
//            cr.select(root).where(cb.between(root.get("initialCapital"), top, bottom));
//
//            Query<Company> query = session.createQuery(cr);
//            List<Company> companies = query.getResultList();
//            return companies;
//        }
//    }

//    public static List<Company> findByWithNameStartingWithInitialCapitalGreaterThan(String name, BigDecimal capital){
//        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaQuery<Company> query = builder.createQuery(Company.class);
//            Root<Company> root = query.from(Company.class);
//
//            Predicate greaterThanInitialCapital = builder.greaterThan(root.get("initialCapital"), capital);
//            Predicate nameStartingWith = builder.like(root.get("name"), name + "%");
//
//            query.select(root).where(builder.and(greaterThanInitialCapital,nameStartingWith));
//
//            Query<Company> q = session.createQuery(query);
//            List<Company> companies = q.getResultList();
//            return companies;
//        }
//    }

    public static List<Company> findByWithNameStartingWith(String name){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Company> query = builder.createQuery(Company.class);
            Root<Company> root = query.from(Company.class);

            Predicate nameStartingWith = builder.like(root.get("name"), name + "%");

            query.select(root).where(nameStartingWith);

            Query<Company> q = session.createQuery(query);
            List<Company> companies = q.getResultList();
            return companies;
        }
    }


//    public static BigDecimal sumInitialCapital(){
//        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
//            Root<Company> root = query.from(Company.class);
//
//            query.select(builder.sum(root.get("initialCapital")));
//
//            Query<BigDecimal> q = session.createQuery(query);
//            BigDecimal result = q.getSingleResult();
//            return result;
//        }
//    }



    //DRIVERS
    public static Set<Driver> getCompanyDrivers(long companyId) {
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
        return company.getDrivers();
    }

    public static List<DriverDto> getCompanyDriversDTO(long companyId) {
        List<DriverDto> employees;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            employees = session.createQuery(
                            "select new org.example.dto.DriverDto(e.id, e.name, e.salary, e.company) from Driver e" +
                                    " join e.company c" +
                                    " where c.id = :id",
                            DriverDto.class)
                    .setParameter("id", companyId)
                    .getResultList();
            transaction.commit();
        }
        return employees;
    }

    public static Set<Transport> getCompanyTransports(long companyId) {
        Company company;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Company> query = builder.createQuery(Company.class);
            Root<Company> root = query.from(Company.class);

            root.fetch("transports", JoinType.INNER); // Eagerly fetch employees

            query.select(root);
            query.where(builder.equal(root.get("id"), companyId));

            company = session.createQuery(query).getSingleResult();
        }
        return company.getTransports();
    }



//    public static List<Transport> getFinishedTransports1(long companyId) {
//        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//            List<Transport> transports = new ArrayList<>();
//
//            String hql = "from Transport t where t.company.id = :id and t.arrivalDate < :now";
//            Query query = session.createQuery(hql);
//            query.setParameter("id", companyId);
//            query.setParameter("now", LocalDate.now());
//            transports = query.getResultList();
//
//            transaction.commit();
//
//            return transports;
//        }
//    }

    public static List<Transport> getFinishedTransports(long companyId) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Transport> transports;

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Transport> criteriaQuery = builder.createQuery(Transport.class);
            Root<Transport> root = criteriaQuery.from(Transport.class);

            criteriaQuery.select(root)
                    .where(
                            builder.equal(root.get("company").get("id"), companyId),
                            builder.lessThan(root.get("arrivalDate"), LocalDate.now())
                    );

            Query<Transport> query = session.createQuery(criteriaQuery);
            transports = query.getResultList();

            transaction.commit();

            return transports;
        }
    }


    public static BigDecimal sumIncomeById(long id){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
            Root<Company> root = query.from(Company.class);

            List<Transport> transports = new ArrayList<>();
            transports = CompanyDao.getFinishedTransports(id);

            BigDecimal result = BigDecimal.ZERO;
            for (Transport t: transports) {
                result = result.add(TransportDao.costFromTransport(t.getId()));
            }
            return result;
        }
    }

    public static BigDecimal sumIncomeByIdOvercharge(long id){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
            Root<Company> root = query.from(Company.class);

            List<Transport> transports = new ArrayList<>();
            transports = CompanyDao.getFinishedTransports(id);
            BigDecimal overcharge = CompanyDao.getCompanyById(id).getOvercharge();

            BigDecimal result = BigDecimal.ZERO;
            for (Transport t: transports) {
                result = result.add(TransportDao.costFromTransport(t.getId()));
            }
            return result.multiply(overcharge);
        }
    }

    public static List<Company> orderByIncomeAsc() {
        List<Company> companies;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            String hql = "FROM Company c";
            companies = session.createQuery(hql, Company.class).getResultList();

            // Sort the companies based on sumIncome
            companies.sort(Comparator.comparing(company -> sumIncomeById(company.getId())));
            transaction.commit();
        }
        return companies;
    }





//    public static List<Company> orderByName1() {
//        List<Company> companies;
//        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//            companies = session.createQuery("Select c From Company c" +
//                    " order by c.name", Company.class).getResultList();
//            transaction.commit();
//        }
//        return companies;
//    }

    public static List<Company> orderByNameAsc() {
        List<Company> companies;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Company> criteriaQuery = builder.createQuery(Company.class);
            Root<Company> root = criteriaQuery.from(Company.class);

            criteriaQuery.select(root)
                    .orderBy(builder.asc(root.get("name")));

            Query<Company> query = session.createQuery(criteriaQuery);
            companies = query.getResultList();
            transaction.commit();
        }

        return companies;
    }

    public static List<Company> orderByNameDesc() {
        List<Company> companies;

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Company> criteriaQuery = builder.createQuery(Company.class);
            Root<Company> root = criteriaQuery.from(Company.class);

            criteriaQuery.select(root)
                    .orderBy(builder.desc(root.get("name")));

            Query<Company> query = session.createQuery(criteriaQuery);
            companies = query.getResultList();
            transaction.commit();
        }

        return companies;
    }

    public static Map<Driver, List<Category>> companyDriversAndCategories(long companyId) {
        Map<Driver, List<Category>> result = new HashMap<>();

        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
            Root<Driver> root = criteriaQuery.from(Driver.class);
            Join<Driver, Category> categoryJoin = root.join("categories");
            Join<Driver, Company> companyJoin = root.join("company");

            criteriaQuery.multiselect(
                    root.alias("driver"),
                    categoryJoin.alias("category")
            ).where(
                    builder.equal(companyJoin.get("id"), companyId)
            );

            Query<Object[]> query = session.createQuery(criteriaQuery);
            List<Object[]> resultList = query.getResultList();

            for (Object[] row : resultList) {
                Driver driver = (Driver) row[0];
                Category category = (Category) row[1];

                result.computeIfAbsent(driver, k -> new ArrayList<>()).add(category);
            }
        }
        return result;
    }





}
