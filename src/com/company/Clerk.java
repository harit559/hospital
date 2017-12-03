package com.company;

public class Clerk extends User{

    public Clerk(String name, String surname, String user, String password){
        super(name, surname, user, password);
        isDoctor = false;
    }
}