package org.example.domain;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean available;

    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }

    public void setAvailable(boolean available) {

        this.available = available;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setIsbn(String isbn) {

        this.isbn = isbn;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) throw new LibraryException("Titulo no puede estar vacio.");
        this.title = title;
    }

    public void setAuthor(String author) {
        if (author == null || author.isEmpty()) throw new LibraryException("Autor no puede estar vacio.");
        this.author = author;
    }

    public void setYear(int year) {
        if (year < 0) throw new LibraryException("El año no puede ser negativo.");
        this.year = year;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn +
                " | Titulo: " + title +
                " | Autor: " + author +
                " | Año: " + year +
                " | Estado: " + (available ? "Disponible" : "Prestado");
    }

}
