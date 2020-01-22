package com.company;

import java.util.Scanner;

public class Program {

    private User[] loggedInAs = new User[1];
    private boolean isLoggedIn = false;
    private Users userList = new Users();


    public Program() {

        Library library = new Library();
        library.addAvailableBook(new Book("bajs", "bejd", 1994, "bajs"));
        library.addAvailableBook(new Book("bajs2", "bejd2", 1995, "bajs2"));
        library.printAvilableBooks();


        showLogIn();
        showMainMenuBorrower();


    }


    public void showMainMenuBorrower() {
        if (isLoggedIn) {
            System.out.print("\nMAIN MENU \n__________\nLogged in as: " + loggedInAs[0].getName() + "\n__________\nOptions: \n 1, Search title \n 2, View borrowed titles \n 3, log out \n");
            Scanner scanner = new Scanner(System.in);
            String menuSelection = scanner.nextLine();
            switch (menuSelection) {
                case "1":

                    break;
                case "2":

                    Borrower currentUser = (Borrower) loggedInAs[0];
                    currentUser.addBorrowedBooks(new Book("bajs", "bajs", 1995, "bajs"));
                    System.out.println(currentUser.getBorrowedBooks());
                    break;

                case "3":
                    loggedInAs[0] = null;
                    isLoggedIn = false;
                    System.out.println("Logged out \n");
                    showLogIn();
            }
        } else {
            showLogIn();
        }
    }

    public void showAddUser() {

        System.out.println("1, New account borrower." + "\n" + "2, New account Librarian" + "\n" + "Account type: ");
        Scanner scanner = new Scanner(System.in);
        String accountType = scanner.nextLine();
        System.out.println("Enter new user name: ");
        String newUserName = scanner.nextLine();
        System.out.println("Enter new password: ");
        String newUserPassword = scanner.nextLine();

        if (accountType.equals("1")) {
            userList.addNewBorrower(newUserName, newUserPassword);
            userList.saveUsers();
            System.out.println("New User added, please login." + "\n");
        }
        if (accountType.equals("2")) {
            userList.addNewLibrarian(newUserName, newUserPassword);
            userList.saveUsers();
            System.out.println("New User added, please login." + "\n");
        }

    }

    ;

    public void showLogIn() {
        while (!isLoggedIn) {

                try {

                    userList.loadUsers();

                } catch (NullPointerException e) {
                    e.printStackTrace();
                }




            if (userList.getLibrarians().size() == 0 && userList.getBorrowers().size() == 0) {
                System.out.println("no users");

                showAddUser();
            } else {
                System.out.println("1, Login Borrower." + "\n" + "2, Login Librarian" + "\n" + "Login type: ");
                Scanner scanner = new Scanner(System.in);
                String loginType = scanner.nextLine();
                System.out.println("Enter user name: ");

                String userName = scanner.nextLine();
                System.out.println("Enter Password");
                String password = scanner.nextLine();
                if (loginType.equals("1") && userList.matchLogIn(userName, password, false) != null) {
                    System.out.println("logged in as borrower: " + userName);
                    loggedInAs[0] = userList.matchLogIn(userName, password, false);
                    isLoggedIn = true;


                } else if (loginType.equals("2") && userList.matchLogIn(userName, password, true) != null) {
                    System.out.println("logged in as Librarian: " + userName);
                    loggedInAs[0] = userList.matchLogIn(userName, password, true);
                    isLoggedIn = true;


                } else {
                    System.out.println("\n wrong username or password\n");
                }
            }
        }
    }
}
