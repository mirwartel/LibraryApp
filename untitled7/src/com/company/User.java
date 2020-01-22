package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable {
    private String name;
    private String password;
    private boolean isLibrarian = false;


    public boolean isLibrarian() {
        return isLibrarian;
    }

    public User(String name, String password, boolean isLibrarian) {
        this.name = name;
        this.password = password;
    }



    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override()
    public boolean equals(Object other) {
        // This is unavoidable, since equals() must accept an Object and not something more derived
        if (other instanceof User) {
            // Note that I use equals() here too, otherwise, again, we will check for referential equality.
            // Using equals() here allows the Model class to implement it's own version of equality, rather than
            // us always checking for referential equality.
            User otherUser = (User) other;
            return otherUser.getName().equals(this.getName());
        }

        return false;
    }

    public static boolean checkAvailability(ArrayList<User> usrLst, User user) {
        for (User p : usrLst) {
            if (p.equals(user)) {
                return true;
            }
        }

        return false;
    }



}