package org.example;

import org.example.configuration.SessionFactoryUtil;
import org.example.dao.CompanyDao;
import org.example.entity.Company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactoryUtil.getSessionFactory().openSession();

        Company company1 = new Company("SAP", LocalDate.of(2000,01,01));
        Company company2 = new Company("Nestle", LocalDate.of(2012,11,19));

//        List<Company> companies = new ArrayList<>();
//        companies.add(company1);
//        companies.add(company2);
//        CompanyDao.saveCompanies(companies);

//        CompanyDao.createCompany(company1);

//        System.out.println(CompanyDao.getCompanyById(4));

        CompanyDao.readCompanies().stream().forEach(System.out::println);

        company1.setId(1);
        CompanyDao.updateCompany(company1);
    }
}