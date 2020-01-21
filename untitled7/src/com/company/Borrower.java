package com.company;

import java.util.ArrayList;

public class Borrower extends User{
    private ArrayList<Book> borrowedBooks = new ArrayList();


    public Borrower(String name, String password) {
        super(name, password);



    }


}


