package com.company;

import java.util.ArrayList;

public class Borrower extends User{
    private ArrayList<Book> borrowedBooks = new ArrayList<Book>();
    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBorrowedBooks(Book book) {
        borrowedBooks.add(0, book);
    };





    public Borrower(String name, String password) {
        super(name, password, false);



    }


}


