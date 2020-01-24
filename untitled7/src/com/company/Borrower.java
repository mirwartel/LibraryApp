package com.company;

import java.util.ArrayList;

public class Borrower extends User {


    private ArrayList<Book> borrowedBooks = new ArrayList<Book>();
    private static final long serialVersionUID = 2233973318075404881L;


    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }


    public void saveBorrowedBooks(){

    }

    public void addBorrowedBooks(Book book) {
        borrowedBooks.add(book);
    };





    public Borrower(String name, String password) {
        super(name, password, false);



    }


}


