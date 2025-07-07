package org.example.repository;

import org.example.domain.Book;

import java.util.List;

public interface BookRepository {
    void addBook(Book book);
    void removeBook(String isbn);
    Book findBookByIsbn(String isbn);
    List<Book> getAllBooks();
}
