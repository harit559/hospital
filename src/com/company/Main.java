package com.company;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// initialize all database
        ArrayList users = new ArrayList();

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

}