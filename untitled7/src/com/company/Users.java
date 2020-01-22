package com.company;

import java.util.ArrayList;

public class Users {

    private static ArrayList<Librarian> librarians = new ArrayList<Librarian>();
    private static ArrayList<Borrower> borrowers = new ArrayList<Borrower>();

    public void setLibrarians(ArrayList<Librarian> librarians) {
        Users.librarians = librarians;
    }

    public void addNewBorrower(String name, String password) {
        Borrower newBorrower = new Borrower(name, password);
        Users.borrowers.add(newBorrower);
    }

    public void addNewLibrarian(String name, String password) {
        Librarian newLibrarian = new Librarian(name, password);
        Users.librarians.add(newLibrarian);
    }

    public ArrayList<Librarian> getLibrarians() {
        return librarians;
    }

    public ArrayList<Borrower> getBorrowers() {
        return borrowers;
    }

    public User matchLogIn(String username, String password, Boolean isLibrarian) {
        if (isLibrarian) {
            for (Librarian librarian : librarians) {
                if (librarian.getName().equals(username) && librarian.getPassword().equals(password)) {
                    return librarian;
                }
            }
        } else {
            for (Borrower borrower : borrowers) {
                if (borrower.getName().equals(username) && borrower.getPassword().equals(password)) {
                    return borrower;
                }
            }
        }

        return null;
    }

    public void loadUsers() {
        if ((ArrayList<Librarian>) FileUtility.loadObject("untitled7/src/com/company/files/librarians.ser") != null || (ArrayList<Borrower>) FileUtility.loadObject("untitled7/src/com/company/files/librarians.ser") != null) {

            librarians = (ArrayList<Librarian>) FileUtility.loadObject("untitled7/src/com/company/files/librarians.ser");
            borrowers = (ArrayList<Borrower>) FileUtility.loadObject("untitled7/src/com/company/files/borrowers.ser");
        }


    }

    ;

    public void saveUsers() {
        FileUtility.saveObject("untitled7/src/com/company/files/librarians.ser", librarians);
        FileUtility.saveObject("untitled7/src/com/company/files/borrowers.ser", borrowers);

    }


    public Users() {
    }
}
