package com.example.databaseassignment;

public class Book {
    int id;
    String bookTitle;
    String bookPublisher;
    String bookAuthor;
    String bookYear;

    public Book(){

    }

    public Book(String bookTitle, String bookPublisher, String bookAuthor, String bookYear){
        this.bookTitle = bookTitle;
        this.bookPublisher = bookPublisher;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
    }

    public int getId() { return id; }

    public void setId(int id){this.id = id;}

    public String getbookTitle() {
        return bookTitle;
    }

    public void setbookTitle(String title) { bookTitle = title; }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String publisher) { bookPublisher = publisher; }

    public String getbookAuthor() {
        return bookAuthor;
    }

    public void setbookAuthor(String author) { bookAuthor = author; }

    public String getbookYear() {
        return bookYear;
    }

    public void setbookYear(String year) { bookYear = year; }
}
