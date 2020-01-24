package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Users implements Serializable {

    private  ArrayList<Librarian> librarians = new ArrayList<Librarian>();
    private  ArrayList<Borrower> borrowers = new ArrayList<Borrower>();

    public void setLibrarians(ArrayList<Librarian> librarians) {
        librarians = librarians;
    }

    public void addNewBorrower(String name, String password) {
        Borrower newBorrower = new Borrower(name, password);
        borrowers.add(newBorrower);
    }

    public void addNewLibrarian(String name, String password) {
        Librarian newLibrarian = new Librarian(name, password);
        librarians.add(newLibrarian);
    }

    public ArrayList<Librarian> getLibrarians() {
        return librarians;
    }

    public ArrayList<Borrower> getBorrowers() {
        return borrowers;
    }

    public void replaceBorrower(Borrower user) {

        for (int i = 0; i < borrowers.size(); i++) {
            User userInUsers = borrowers.get(i);
            if (userInUsers.getName().equals(user.getName())) {

                borrowers.set(i, user);
                saveUsers();
            }
        };



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

    public void loadBorrowers() {


        if (FileUtility.loadObject("untitled7/src/com/company/files/borrowers.ser") != null) {

            borrowers = (ArrayList<Borrower>) FileUtility.loadObject("untitled7/src/com/company/files/borrowers.ser");
        }


    }

    public void loadLibrarians() {


        if (FileUtility.loadObject("untitled7/src/com/company/files/librarians.ser") != null) {

            librarians = (ArrayList<Librarian>) FileUtility.loadObject("untitled7/src/com/company/files/librarians.ser");
        }}


;

      public void saveUsers(){
        FileUtility.saveObject("untitled7/src/com/company/files/librarians.ser",librarians);
        FileUtility.saveObject("untitled7/src/com/company/files/borrowers.ser",borrowers);

        }


public Users(){
          loadLibrarians();
          loadBorrowers();

        }}

