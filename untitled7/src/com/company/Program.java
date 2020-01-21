package com.company;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Program {

    private Library library = new Library();
    private User[] loggedInAs = new User[1];
    private boolean isLoggedIn = false;
    private Users userList = new Users();


    public Program() {

        library.addAvailableBook(new Book("bajs", "bejd",1994,"bajs"));
        library.addAvailableBook(new Book("bajs2", "bejd2",1995,"bajs2"));
        library.printAvilableBooks();


        showLogIn();
        showMainMenu();


    }




    public void showMainMenu(){
        if (isLoggedIn) {
            System.out.print("\nMAIN MENU \n__________\nLogged in as: " + loggedInAs[0].getName() + "\n__________\nOptions: \n 1, option 1 \n 2, option 2 \n 3, option 3" );
        }
        else {
            showLogIn();
        }
    }

    public void showAddUser(){

        System.out.println("1, New account borrower." + "\n" + "2, New account Librarian" + "\n" + "Account type: ");
        Scanner scanner = new Scanner(System.in);
        String accountType = scanner.nextLine();
        System.out.println("Enter new user name: ");
        String newUserName = scanner.nextLine();
        System.out.println("Enter new password: ");
        String newUserPassword = scanner.nextLine();

        if(accountType.equals("1")) {
            userList.addNewBorrower(newUserName, newUserPassword);
            System.out.println("New User added, please login." + "\n");
        }
        if(accountType.equals("2")) {
            userList.addNewLibrarian(newUserName, newUserPassword);
            System.out.println("New User added, please login." + "\n");
        }

    };

    public void showLogIn(){
        while(!isLoggedIn){





            if(userList.getLibrarians().size() <=0 && userList.getBorrowers().size() <=0){
                System.out.println("no users");
                showAddUser();
            }
            else{
                System.out.println("1, Login Borrower." + "\n" + "2, Login Librarian" + "\n" + "Login type: ");
                Scanner scanner = new Scanner(System.in);
                String loginType = scanner.nextLine();
                System.out.println("Enter user name: ");

                String userName = scanner.nextLine();
                System.out.println("Enter Password");
                String password = scanner.nextLine();
                if (loginType.equals("1") && userList.matchLoggin(userName, password, false) != null){
                    System.out.println("logged in as borrower: " + userName);
                    loggedInAs[0] = userList.matchLoggin(userName, password, false);
                    isLoggedIn = true;


                }
                else if (loginType.equals("2") && userList.matchLoggin(userName, password, true) != null){
                    System.out.println("logged in as Librarian: " + userName);
                    loggedInAs[0] = userList.matchLoggin(userName, password, true);
                    isLoggedIn = true;


                }
                else{
                    System.out.println("\n wrong username or password\n");
                }
            }
        }
    }
}
