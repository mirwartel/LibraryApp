package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable {
    private   ArrayList<Book> availableBooks = new ArrayList<Book>();
    private   ArrayList<Book> lendedBooks = new ArrayList<Book>();


    public ArrayList<Book> getLendedBooks() {
        return lendedBooks;
    }



    public Library() {
        loadBooks();

    }


    public void addBook(Book book) {
        availableBooks.add(book);
    }




    public Book getBookByIndex(int index){
        return availableBooks.get(index);
    };

    public Book getLendedBookByIndex(int index){
        return lendedBooks.get(index);
    };

    public void loadBooks() {
        if ((ArrayList<Book>) FileUtility.loadObject("untitled7/src/com/company/files/availableBooks.ser") != null) {

            availableBooks = (ArrayList<Book>) FileUtility.loadObject("untitled7/src/com/company/files/availableBooks.ser");

        }
        if ((ArrayList<Book>) FileUtility.loadObject("untitled7/src/com/company/files/lendedBooks.ser") != null) {

            lendedBooks = (ArrayList<Book>) FileUtility.loadObject("untitled7/src/com/company/files/lendedBooks.ser");

        }


    }

    public void borrowBook(Book book){

        for (int i = 0; i< availableBooks.size(); i++) {
            Book bookInAllBooks = availableBooks.get(i);
            if (bookInAllBooks.equals(book)){

                book.setIsAvailable(false);

                lendedBooks.add(book);

               availableBooks.remove(i);



            }}

    }

    public void removeBookByIndex(int index){
        availableBooks.remove(index);
    }

    public void saveBooks() {
        FileUtility.saveObject("untitled7/src/com/company/files/availableBooks.ser", availableBooks);
        FileUtility.saveObject("untitled7/src/com/company/files/lendedBooks.ser", lendedBooks);


    }

    public ArrayList<Book> searchBookTitle(String title){
        ArrayList<Book> bookSearchResult = new ArrayList<>();
        for (Book books : availableBooks) {
            if (books.getTitle().equals(title)) {

                bookSearchResult.add(books);




            }
        }
        return bookSearchResult;

    }
    public ArrayList<Book> searchBookAuthor(String author){
        ArrayList<Book> bookSearchResult = new ArrayList<Book>();
        for (Book books : availableBooks) {
            if (books.getAuthor().equals(author)) {

                bookSearchResult.add(books);




            }
        }
        return bookSearchResult;

    }





    public ArrayList<Book> getAvailableBooks() {
        return availableBooks;
    }



}
