package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    private Library library = new Library();
    private User[] loggedInAs = new User[0];
    private boolean isLoggedIn = false;
    private Users userList = new Users();


    public Program() {

        library.addAvailableBook(new Book("bajs", "bejd",1994,"bajs"));
        library.addAvailableBook(new Book("bajs2", "bejd2",1995,"bajs2"));
        library.printAvilableBooks();


        showLoggIn();


    }




    public void showMainMenu(){}

    public void showAddUser(){

        System.out.println("Enter new user name: ");
        Scanner scanner = new Scanner(System.in);
        String newUserName = scanner.nextLine();
        System.out.println("Enter new password: ");
        String newUserPassword = scanner.nextLine();
        userList.addNewBorrower(newUserName, newUserPassword);
        System.out.println("New User added, please logg in." + "\n");
    };

    public void showLoggIn(){
        while (!isLoggedIn){




            if(userList.getLibrarians().size() <=0 && userList.getBorrowers().size() <=0){
                System.out.println("no users");
                showAddUser();
            }
            else{
                System.out.println("Enter user name: ");
                Scanner scanner = new Scanner(System.in);
                String userName = scanner.nextLine();
                System.out.println("Enter Password");
                String password = scanner.nextLine();
                if(userList.matchLoggin(userName, password, false) != null){
                    System.out.println("logged in");
                    isLoggedIn = true;

                }
                else {
                    System.out.println("wrong username or password");
                }
            }
        }
    }
}
