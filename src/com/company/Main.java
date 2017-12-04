package com.company;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
	// initialize all database
        ArrayList users = new ArrayList();
        ArrayList patients = readPatientFromCSV();

        User user;
        Doctor logged_in_doc = null;
        Clerk logged_in_clerk = null;
        Patient found_patient = null;

        createDummyData(users, patients);

        while (true) {
            String username;
            String password;
            System.out.println("Login");
            username = IOUtils.getString("Username:");
            password = IOUtils.getString("Password:");

            user = User.findByUsername(users, username);
            if (user == null) {
                System.out.println("User not found");
            }
            else if (!user.verify_login(password)) {
                System.out.println("wrong password");
            }else {
                break;
            }
        }
        //User interface
        System.out.println("Welcome To Hospital System");
        if(user.isDoctor()) {
            logged_in_doc = (Doctor) user;
            Patient foundPatient = null;
            while (true) {
                String hn;
                hn = IOUtils.getString("Enter patient's hospital number:");
                found_patient = Patient.findPatient(patients, hn);
                if(found_patient != null) {
                    System.out.println("Patient:"+ found_patient.getName() + " " + found_patient.getSurname());
                    System.out.println("1 - Display Basic Info");
                    System.out.println("2 - Show all records");
                    int option = IOUtils.getInteger("Enter your choice");
                    switch (option) {
                        case 1:
                            System.out.println("HN: " + found_patient.getHn());
                            System.out.println("Name: " + found_patient.getName());
                            System.out.println("Surname: " + found_patient.getSurname());
                            System.out.println("DOB: " + found_patient.getDay() + "/" + found_patient.getMonth() + "/" + found_patient.getYear());
                            System.out.println("Bloodtype: " + found_patient.getBloodType());
                            System.out.println("Height: " + found_patient.getHeight());
                            System.out.println("Weight: " + found_patient.getWeight());
                            String edit = IOUtils.getString("Do you want to edit(y/n): ");
                            if(edit.equals("y")) {

                            }
                            break;
                    }
                }
                else {
                    System.out.println("Patient not found");
                }
            }
        }
        else {
            logged_in_clerk = (Clerk) user;
        }

    }

    private static void createDummyData(ArrayList users, ArrayList<Patient> patients) {
        Doctor doctor = new Doctor("Ekacha", "Techasuknirun","ekacha", "1234");
        Patient patient = new Patient("Harit", "Chokthananuchit", 16, 8, 1996, 173, 57,"O");
        users.add(doctor);


    }

    private static ArrayList readPatientFromCSV() {
        ArrayList patients = new ArrayList();
        Path pathToFile = Paths.get("data/patients.csv");

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                Patient patient = new Patient(attributes[0], attributes[1],
                        Integer.parseInt(attributes[2]),Integer.parseInt(attributes[3]),Integer.parseInt(attributes[4]),
                        Double.parseDouble(attributes[5]),Double.parseDouble(attributes[6]),
                        attributes[7]
                );

                // adding book into ArrayList
                patients.add(patient);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return patients;
    }

}