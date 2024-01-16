package org.example.file;

import org.example.dao.CompanyDao;
import org.example.dao.DriverDao;
import org.example.dto.DriverDto;
import org.example.dto.TransportDto;
import org.example.entity.Company;
import org.example.entity.Driver;
import org.example.entity.Transport;

import java.io.*;
import java.util.List;
import java.util.Set;

public class TransportDetails {

    public static void writeTransports(String outputFile, List<Transport> transportations) {

        try (FileWriter fout = new FileWriter(new File(outputFile), false)) {
            for (Transport transportation : transportations) {
                fout.append(transportation.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing transports to file: " + e.getMessage(), e);
        }
    }


    public static void writeTransportsDto(String outputFile, List<TransportDto> transportations) {

        try (FileWriter fout = new FileWriter(new File(outputFile), false)) {
            for (TransportDto transport : transportations) {
                fout.append(transport.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing transports to file: " + e.getMessage(), e);
        }
    }

    public static void writeCompanyDetails(String outputFile, Company company) {

        try (FileWriter fout = new FileWriter(new File(outputFile), false)) {
            List<DriverDto> drivers = CompanyDao.getCompanyDriversDTO(company.getId());

            for (DriverDto driver : drivers) {
                fout.append(driver + System.lineSeparator());
            }

        } catch (IOException e) {
            throw new RuntimeException("Error writing transports to file: " + e.getMessage(), e);
        }
    }



    public static String readFromFile(String inputFile) {
        StringBuilder transportationBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                transportationBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return transportationBuilder.toString();

    }



}