package org.example;

import org.example.configuration.SessionFactoryUtil;
import org.example.dao.CompanyDao;
import org.example.dao.EmployeeDao;
import org.example.entity.Company;
import org.example.entity.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactoryUtil.getSessionFactory().openSession();

        Company company1 = new Company("SAP", LocalDate.of(2000,01,01));
        Company company2 = new Company("Nestle", LocalDate.of(2012,11,19));

//        SAVE COMPANIES
//        List<Company> companies = new ArrayList<>();
//        companies.add(company1);
//        companies.add(company2);
//        CompanyDao.saveCompanies(companies);

//        //CREATE COMPANY
//        CompanyDao.createCompany(company1);

//        //GET COMPANY BY ID
//        System.out.println(CompanyDao.getCompanyById(4));

//        //SOUT COMPANIES
//        CompanyDao.readCompanies().stream().forEach(System.out::println);

//        //UPDATE COMPANY
//        company2.setId(3);
//        CompanyDao.updateCompany(company2);

//        //DELETE COMPANY
//        Company company3 = CompanyDao.getCompanyById(3);
//        CompanyDao.deleteCompany(company3);

        CompanyDao.companiesFindByInitialCapitalBetween(BigDecimal.valueOf(1000), BigDecimal.valueOf(3000));

        System.out.println("---------------------------------------------");
        CompanyDao.findByWithNameStartingWithInitialCapitalGreaterThan("Le",BigDecimal.valueOf(1000))
                .stream().forEach(System.out::println);


        System.out.println("---------------------------------------------");
        System.out.println(CompanyDao.sumInitialCapital());

        CompanyDao.readCompanies().forEach(System.out::println);
        System.out.println("---------------------------------------------");
        CompanyDao.readCompanies1().forEach(System.out::println);
    }
}