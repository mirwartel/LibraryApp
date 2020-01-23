package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable {
    private ArrayList<Book> allBooks = new ArrayList<Book>();


    public Library() {

    }


    public void addBook(Book book) {
        this.allBooks.add(book);
    }



    public void printAvilableBooksTotal() {
    System.out.print("Library{" + "\n" +
            "Available Books Total: " + allBooks.size() + "\n");
}
    public void printAllBooks() {

        for (Book availableBook : allBooks) {
            System.out.println(availableBook.toStringShort());


        }


    }
    public Book getBookByIndex(int index){
        return allBooks.get(index);
    };

    public void loadBooks() {
        if ((ArrayList<Book>) FileUtility.loadObject("untitled7/src/com/company/files/allBooks.ser") != null) {

            allBooks = (ArrayList<Book>) FileUtility.loadObject("untitled7/src/com/company/files/allBooks.ser");

        }


    }

    public void removeBookByIndex(int index){
        allBooks.remove(index);
    }

    public void saveBooks() {
        FileUtility.saveObject("untitled7/src/com/company/files/allBooks.ser", allBooks);


    }

    public void setAllBooks(ArrayList<Book> allBooks) {
        this.allBooks = allBooks;
    }



    public ArrayList<Book> getAllBooks() {
        return allBooks;
    }



}
