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

        createDummyData(users);

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

        System.out.println("Welcome To hSystem");


    }

    private static void createDummyData(ArrayList users) {
        Doctor doctor = new Doctor("Ekacha", "Techasuknirun","ekacha", "1234");
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