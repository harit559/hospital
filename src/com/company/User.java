package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class User {
    protected String name;
    protected String surname;
    protected String user;
    protected String password;
    protected boolean isDoctor;

    public User(String name, String surname, String user, String password) {
        this.name = name;
        this.surname = surname;
        this.user = user;
        this.password = password;
    }

    public boolean verify_login( String password) {
        if(this.password == password) {
            return true;
        }
        return false;
    }

    public boolean isDoctor() {
        return isDoctor;
    }

    private String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public static User findByUsername(ArrayList users, String username){
        Iterator userIterator = users.iterator();

        while(userIterator.hasNext()) {
            User each = (User) userIterator.next();
            String test = each.getUser();
            if(test == username) {
                return each;
            }
            else {
                System.out.println("it's not him.");
            }
        }

        return null;
    }

}
