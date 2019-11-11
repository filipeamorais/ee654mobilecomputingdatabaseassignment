package com.example.databaseassignment;

public class Book {
    String bookTitle;
    String bookPublisher;
    String bookAuthor;
    String bookYear;

    public Book(String bookTitle, String bookPublisher, String bookAuthor, String bookYear){
        this.bookTitle = bookTitle;
        this.bookPublisher = bookPublisher;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
    }

    public String getbookTitle() {
        return bookTitle;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public String getbookAuthor() {
        return bookAuthor;
    }

    public String getbookYear() {
        return bookYear;
    }
}
