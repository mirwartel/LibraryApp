package com.company;

import java.util.ArrayList;

public class Borrower extends User{
    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBorrowedBooks(Book book) {
        borrowedBooks.add(0, book);
    };


    private ArrayList<Book> borrowedBooks = new ArrayList();


    public Borrower(String name, String password) {
        super(name, password, false);



    }


}


