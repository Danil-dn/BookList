package org.kniga;

public class Book {
    private String title;
    private String author;
    public Book(String title, String author) {
        this.title = title.toLowerCase();
        this.author = author.toLowerCase();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Название: " + title + "\nАвтор: " + author;
    }
}
