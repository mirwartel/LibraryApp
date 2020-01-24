package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    private User[] loggedInAs = new User[1];
    private boolean isLoggedIn = false;
    private Users userList = new Users();
    private Library library = new Library();


    public Program() {







        showLogIn();


    }


    public void showMainMenuBorrower() {
        if (isLoggedIn) {
            System.out.print("\nMAIN MENU \n__________\nLogged in as: " + loggedInAs[0].getName() + "\n__________\nOptions: \n 1, View available titles \n 2, View borrowed titles \n 3, Search Book \n 4, show all books total\n 5, log out \n");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                try {
                    String mainMenusSelections = scanner.nextLine();
                    switch (mainMenusSelections) {
                        case "1":

                            showAvailableBooksMenu();


                            break;

                        case "2":
                            showBorrowerBorrowedBooksMenu();


                            break;

                        case "3":
                            showBorrowerSearchMenu();


                            break;

                        case "4":

                            showAllBooksMenu();


                            break;


                        case "5":
                            logOut();
                            return;

                    }
                } catch (NumberFormatException e) {
                    System.out.println("invalid input");
                }
            }
        } else {
            showLogIn();
        }
    }

    public void showMainMenuLibrarian() {
        if (isLoggedIn) {
            System.out.print("\nMAIN MENU \n__________\nLogged in as: " + loggedInAs[0].getName() + "\n__________\nOptions: \n 1, View lended titles \n \n 5, log out \n");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                try {
                    String mainMenusSelections = scanner.nextLine();
                    switch (mainMenusSelections) {
                        case "1":

                            showAllLendedBooksMenu();


                            break;



                        case "5":
                            logOut();
                            return;

                    }
                } catch (NumberFormatException e) {
                    System.out.println("invalid input");
                }
            }
        } else {
            showLogIn();
        }
    }


    public void showBorrowerSearchMenu() {
        System.out.println("1, Search books by title. n\" 2, Search books by author. n\" 3, return to main menu");
        Scanner scanner = new Scanner(System.in);
        while (true) {String userInput = scanner.nextLine();
        switch (userInput) {
            case "1":
                ArrayList<Book> searchResultTitle = new ArrayList<>();
                System.out.println("Enter title: ");
                userInput = scanner.nextLine();
                searchResultTitle = library.searchBookTitle(userInput);
                if (searchResultTitle == null) {
                    System.out.println("No results found");
                } else System.out.println(searchResultTitle);
                break;
            case "2":
                ArrayList<Book> searchResultAuthor = new ArrayList<>();
                System.out.println("Enter author: ");
                userInput = scanner.nextLine();
                searchResultAuthor = library.searchBookAuthor(userInput);
                if (searchResultAuthor==null) {
                    System.out.println("No results found");
                } else System.out.println(searchResultAuthor);
                break;
            case "3":
                showMainMenuBorrower();
                return;
        }
    }}

    ;

    private void showBorrowerBorrowedBooksMenu() {

        Borrower currentUser = (Borrower) loggedInAs[0];

        System.out.println("Your borrowed books: \n");
        for (int i = 0; i < currentUser.getBorrowedBooks().size(); i++) {
            System.out.println("\n" + i + " " + currentUser.getBorrowedBooks().get(i).toString());


        }
        System.out.println("Input index number of book to return it. \n input 'm' to return to main menu");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.equals("m"))
                showMainMenuBorrower();
            else {


                try {
                    int bookIndex = Integer.parseInt(userInput);
                    Book selectedBook = currentUser.getBorrowedBooks().get(bookIndex);
                    currentUser.getBorrowedBooks().remove(bookIndex);
                    selectedBook.setIsAvailable(true);
                    selectedBook.setBorrowedBy(null);
                    library.addBook(selectedBook);
                    System.out.println(selectedBook + " has been returned.");
                    library.saveBooks();
                    currentUser.saveBorrowedBooks();
                    userList.replaceBorrower(currentUser);
                    showBorrowerBorrowedBooksMenu();
                    break;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("No book at given index");
                }
                catch (NumberFormatException e){
                    System.out.println("invalid input");
                }
            }
        }


    }

    ;

    private void logOut() {
        library.saveBooks();
        userList.saveUsers();
        loggedInAs[0] = null;
        isLoggedIn = false;
        System.out.println("Logged out \n");
        showLogIn();

    }

    private void showAvailableBooksMenu() {
        library.loadBooks();
        System.out.print("ALL AVAILABLE BOOKS \n ----------- \nEnter the number before a book below to show info and borrow. \nto return to main menu, enter 'm'.\n");
        for (int i = 0; i < library.getAvailableBooks().size(); i++) {
            System.out.println("\n" + i + " " + library.getBookByIndex(i).toString());


        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.equals("m"))
                showMainMenuBorrower();
            else {
                try {
                    int bookIndex = Integer.parseInt(userInput);
                    Book selectedBook = library.getBookByIndex(bookIndex);
                    showBookMenu(selectedBook);
                    break;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("No book at given index");
                }
            }
        }


    }

    private void showAllLendedBooksMenu() {
        library.loadBooks();
        System.out.print("List of all lended books\n ");
        for (int i = 0; i < library.getLendedBooks().size(); i++) {
            System.out.println("\n "  + library.getLendedBookByIndex(i).toString() + library.getLendedBookByIndex(i).getBorrowedBy() );


        }}


    private void showAllBooksMenu() {
        library.loadBooks();
        System.out.print("List of all books, user can not borrow from this menu \n ");
        for (int i = 0; i < library.getLendedBooks().size(); i++) {
            System.out.println("\n "  + library.getLendedBookByIndex(i).toString());


        }
        for (int i = 0; i < library.getAvailableBooks().size(); i++) {
            System.out.println("\n "  + library.getBookByIndex(i).toString());}}




    private void showBookMenu(Book book) {
        System.out.println(book.toStringLong());
        System.out.println("enter 'm' to return to Main Menu.");
        if (book.getIsAvailable()) {
            System.out.println("to borrow this book, enter 'b'");
        }

        Scanner scanner = new Scanner(System.in);

        while (true){
        String inputChoice = scanner.nextLine();
        switch (inputChoice) {
            case "m":
                showMainMenuBorrower();
                break;
            case "b":
                if(book.getIsAvailable())
                borrowBook(book);;
                return;


        }}


    }

    ;


    public User getLoggedInAs() {
        return loggedInAs[0];
    }


    private void borrowBook(Book book) {


        Borrower currentBorrower = (Borrower) getLoggedInAs();
        if ((book.getIsAvailable() && !getLoggedInAs().isLibrarian())) {


            library.borrowBook(book);
            book.setBorrowedBy(currentBorrower);
            currentBorrower.addBorrowedBooks(book);
            userList.replaceBorrower((Borrower) getLoggedInAs());
            userList.saveUsers();
            library.saveBooks();

        }


        System.out.println("Borrowed book: " + book.getTitle() + " \n Returning to All books library. \n");
        showAvailableBooksMenu();

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


    public void showLogIn() {
        while (!isLoggedIn) {

            try {

                userList.loadBorrowers();
                userList.loadLibrarians();

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
                    showMainMenuBorrower();


                } else if (loginType.equals("2") && userList.matchLogIn(userName, password, true) != null) {
                    System.out.println("logged in as Librarian: " + userName);
                    loggedInAs[0] = userList.matchLogIn(userName, password, true);
                    isLoggedIn = true;
                    showMainMenuLibrarian();


                } else {
                    System.out.println("\n wrong username or password\n");
                }
            }
        }
    }

}