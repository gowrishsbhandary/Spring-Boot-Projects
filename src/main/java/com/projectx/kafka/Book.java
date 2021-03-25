package com.projectx.kafka;

public class Book {

    private String bookName;
    private String isbn;

    public Book(String bookName, String isbn) {
        this.bookName = bookName;
        this.isbn = isbn;
    }

    public Book() {
    }

    public String getBookName() {
        return bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

}
