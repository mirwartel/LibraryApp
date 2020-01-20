package com.company;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> availableBooks = new ArrayList<Book>();
    private ArrayList<Book> lendedBooks = new ArrayList<Book>();

    public Library() {

    }


    public void addAvailableBook(Book book) {
        this.availableBooks.add(book);
    }

public void printAvilableBooksTotal() {
    System.out.print("Library{" + "\n" +
            "Available Books Total: " + availableBooks.size() + "\n");
}
    public void printAvilableBooks() {

        for (Book availableBook : availableBooks) {
            System.out.println(availableBook);

        }


    }

    public void setAvailableBooks(ArrayList<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public void setLendedBooks(ArrayList<Book> lendedBooks) {
        this.lendedBooks = lendedBooks;
    }

    public ArrayList<Book> getAvailableBooks() {
        return availableBooks;
    }

    public ArrayList<Book> getLendedBooks() {
        return lendedBooks;
    }

}
