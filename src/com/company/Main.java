package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// initialize all database
        ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        ArrayList<Clerk> clerks = new ArrayList<Clerk>();

        String user;
        String password;

        Doctor doctor = new Doctor("Ekacha", "Techasuknirun","ekacha", "1234");
        doctors.add(doctor);
        System.out.println("Login");
        user = IOUtils.getString("Username:");
        password = IOUtils.getString("Password:");


    }
}