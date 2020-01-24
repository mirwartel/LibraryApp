package com.company;

import java.io.Serializable;

public class Book  implements Serializable {
    private String title;
    private String author;
    private int year;
    private String description;
    private boolean isAvailable;
    private Borrower borrowedBy;
    private static final long serialVersionUID = 8626376676615859420L;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBorrowedBy(Borrower borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public User getBorrowedBy() {
        return borrowedBy;
    }




    public String toStringLong() {
        return
                "Title: " + title +
                ", Author: " + author +
                        " Year: " + year +
                ", Description: " + description
                + ", Status: " + isAvailableToString();
    }

    public String isAvailableToString() {
        if (isAvailable = true)
        {        return " Available";}
        else if (isAvailable = false){ return " Not available";}
        else {return null;}
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;

    }

    public boolean getIsAvailable() {
        return isAvailable;
    }
    @Override
    public String toString() {
        return

                "Title: " + title +
                        ", Author: " + author +
                        ", Status: " + isAvailableToString()

                ;
    }

    public Book(String title, String author, int year, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.year = year;
        isAvailable = true;
    }
}
