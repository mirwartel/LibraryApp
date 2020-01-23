package com.company;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private int year;
    private String description;
    private boolean isAvailable = true;


    @Override
    public String toString() {
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
        else {return " Not available";}
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String toStringShort() {
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
    }
}
