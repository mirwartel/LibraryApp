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

    public void addLendedBook(Book book) {
        this.lendedBooks.add(book);
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

    public void loadBooks() {
        if ((ArrayList<Book>) FileUtility.loadObject("untitled7/src/com/company/files/avilableBooks.ser") != null || (ArrayList<Book>) FileUtility.loadObject("untitled7/src/com/company/files/lendedBooks.ser") != null) {

            availableBooks = (ArrayList<Book>) FileUtility.loadObject("untitled7/src/com/company/files/avilableBooks.ser");
            lendedBooks = (ArrayList<Book>) FileUtility.loadObject("untitled7/src/com/company/files/lendedBooks.ser");
        }


    }

    ;

    public void saveBooks() {
        FileUtility.saveObject("untitled7/src/com/company/files/avilableBooks.ser", availableBooks);
        FileUtility.saveObject("untitled7/src/com/company/files/lendedBooks.ser", lendedBooks);

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
