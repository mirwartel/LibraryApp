package com.company;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Program {

    private User[] loggedInAs = new User[1];
    private boolean isLoggedIn = false;
    private Users userList = new Users();
    private Library library = new Library();


    public Program() {


        library.addBook(new Book("bajs", "bejd", 1994, "bajs"));
        library.addBook(new Book("bajs2", "bejd2", 1995, "bajs2"));
        library.printAllBooks();


        showLogIn();
        showMainMenuBorrower();


    }


    public void showMainMenuBorrower() {
        if (isLoggedIn) {
            System.out.print("\nMAIN MENU \n__________\nLogged in as: " + loggedInAs[0].getName() + "\n__________\nOptions: \n 1, View all titles \n 2, View borrowed titles \n 3, log out \n");
            Scanner scanner = new Scanner(System.in);
            String mainMenusSelections = scanner.nextLine();
            switch (mainMenusSelections) {
                case "1":

                    showAllBooksInLibraryMenu();


                    break;
                case "2":

                    Borrower currentUser = (Borrower) loggedInAs[0];
                    currentUser.addBorrowedBooks(new Book("bajs", "bajs", 1995, "bajs"));
                    System.out.println(currentUser.getBorrowedBooks());
                    break;

                case "3":
                    logOut();

            }
        } else {
            showLogIn();
        }
    }

    private void showAllBooksMenuBorrower(){

        System.out.print(" \n__________\nOptions: \n 1, View all titles \n 2, View borrowed titles \n return to main menu:  \n");
        Scanner scanner = new Scanner(System.in);
                int scannerSelection = scanner.nextInt();




        switch (scannerSelection) {

            case 1:








                break;
            case 2:

                Borrower currentUser = (Borrower) loggedInAs[0];

                System.out.println("Borrowed titels for currentUser: " +currentUser.getBorrowedBooks());
                break;

            case 3:
                showMainMenuBorrower();



        }};

    private void logOut(){
        loggedInAs[0] = null;
        isLoggedIn = false;
        System.out.println("Logged out \n");
        showLogIn();

    }

    private void showAllBooksInLibraryMenu() {
        System.out.print("ALL AVAILABLE BOOKS \n ----------- \nEnter the number before a book below to show info and borrow. \nto return to main menu, enter 'm'.");
        for (int i = 0; i < library.getAllBooks().size(); i++) {
            System.out.println(i + ", " + library.getBookByIndex(i).toStringShort());




        }
        System.out.print("ALL AVAILABLE BOOKS \n ----------- \nEnter the number before a book below to show info and borrow. \nto return to main menu, enter 'm'.\n");
        borrowBook();
    }

    private void borrowBook() {

        while (true){

        try {
            Scanner scanner= new Scanner(System.in);
            int scannerSelection = scanner.nextInt();
            Book book = library.getBookByIndex(scannerSelection);
            book.setAvailable(false);
            Borrower borrowBookTo = (Borrower) Array.get(loggedInAs, 0);
            borrowBookTo.addBorrowedBooks(book);




            borrowBookTo.addBorrowedBooks(book);

            library.saveBooks();
            System.out.println("\nBook " + book + "has been added to your borrowed books list");
            ;
        } catch (IndexOutOfBoundsException e) {

            System.out.println("There is no book with that number in the current list you are showing. please try again with a different number");



        }}

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
