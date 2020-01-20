package com.company;

public class Book {
    private String title;
    private String author;
    private String description;
    private int year;

    @Override
    public String toString() {
        return
                "title: " + title +
                ", author: " + author +
                ", description: " + description +
                ", year: " + year
                ;
    }

    public Book(String title, String author, int year, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.year = year;
    }
}
