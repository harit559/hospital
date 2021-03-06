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
        if(this.password.equals(password)) {
            return true;
        }
        return false;
    }

    public boolean isDoctor() {
        return isDoctor;
    }

    public String getUser() {
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
        User ret = null;
        while(userIterator.hasNext()) {
            User each = (User) userIterator.next();
            if (username.equals(each.getUser())) {
                ret = each;
            }
            else {
                System.out.println("it's not him.");
            }
        }

        return ret;
    }

}
