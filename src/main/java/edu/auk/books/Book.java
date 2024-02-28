package edu.auk.books;

import java.util.List;

public class Book {
    private String title;
    private List<Book> relatedBooks;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public List<Book> getRelatedBooks() {
        return relatedBooks;
    }

    public void setRelatedBooks(List<Book> relatedBooks) {
        this.relatedBooks = relatedBooks;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}
