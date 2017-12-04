package com.company;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// initialize all database
        ArrayList users = new ArrayList();
        ArrayList<Patient> patients = new ArrayList<Patient>();
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
        patients.add(patient);
    }

}