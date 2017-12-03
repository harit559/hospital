package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// initialize all database
        ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        ArrayList<Clerk> clerks = new ArrayList<Clerk>();

        String user;
        String password;
        boolean isDoctor = false;
        boolean isClerk = false;

        Doctor doctor = new Doctor("Ekacha", "Techasuknirun","ekacha", "1234");
        doctors.add(doctor);

        System.out.println("Login");
        user = IOUtils.getString("Username:");
        password = IOUtils.getString("Password:");

        Iterator doctorIterator = doctors.iterator();

        while(doctorIterator.hasNext()) {
            Doctor each = (Doctor) doctorIterator.next();
            if(each.verify_login(user, password) == true) {
                isDoctor = true;
            }
        }

        Iterator clerkIterator = clerks.iterator();

        while(clerkIterator.hasNext()) {
            Clerk each = (Clerk) clerkIterator.next();
            if(each.verify_login(user, password) == true) {
                isClerk = true;
            }
        }

        if(isDoctor = true) {

        }
        else {
            
        }

    }
}