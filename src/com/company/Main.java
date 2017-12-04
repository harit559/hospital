package com.company;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// initialize all database
        ArrayList users = new ArrayList();

        String username;
        String password;

        Doctor doctor = new Doctor("Ekacha", "Techasuknirun","ekacha", "1234");
        users.add(doctor);

        System.out.println("Login");
        username = IOUtils.getString("Username:");
        password = IOUtils.getString("Password:");

        User user = User.findByUsername(users,username);
        if(user == null){
            System.out.println("User not found");
        }

//        if(user.isDoctor()) {
//            Doctor login_user = (Doctor) user;
//        }
//        else {
//            Clerk login_user = (Clerk) user;
//        }
//
//        login
    }
}