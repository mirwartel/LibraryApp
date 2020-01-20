package com.company;

import java.util.ArrayList;

public class Borrower extends User{
    private ArrayList<Book> borrowedBooks = new ArrayList();
    private String name;
    private String password;

    public Borrower(String name, String password) {
        super();
        this.name = name;
        this. password = password;

    }


}


