package com.company;

public class User {
    protected String name;
    protected String surname;
    protected String user;
    protected String password;

    public User(String name, String surname, String user, String password) {
        this.name = name;
        this.surname = surname;
        this.user = user;
        this.password = password;
    }

    public boolean verify_login(String name, String surname) {
        if((this.user == user) && (this.password == password)) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    
}
