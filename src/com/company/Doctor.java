package com.company;

public class Doctor extends User{

    public Doctor(String name, String surname, String user, String password) {
        super(name, surname, user, password);
        isDoctor = true;
    }
}
