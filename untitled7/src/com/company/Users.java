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

    public ArrayList<Librarian> getLibrarians() {
        return librarians;
    }

    public ArrayList<Borrower> getBorrowers() {
        return borrowers;
    }

    public User matchLoggin (String username, String password, Boolean isLibrarian){
        if(isLibrarian) {
            for(Librarian librarian : librarians) {
                if(librarian.getName().equals(username) && librarian.getPassword().equals(password)) {
                    return librarian;
                }
            }
        }
        else {
            for(Borrower borrower : borrowers) {
                if(borrower.getName().equals(username) && borrower.getPassword().equals(password)) {
                    return borrower;
                }
            }
        }
        return null;
    }




    public Users() {
    }
}
