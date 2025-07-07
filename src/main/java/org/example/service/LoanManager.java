package org.example.service;

import org.example.domain.Book;
import org.example.domain.LibraryException;
import org.example.repository.BookRepository;

public class LoanManager {
    private final BookRepository bookRepository;

    public LoanManager(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void lendBook(String isbn) {
        Book book = bookRepository.findBookByIsbn(isbn);
        if (!book.isAvailable()) {
            throw new LibraryException("El libro ya esta prestado: " + isbn);
        }
        book.setAvailable(false);
    }

    public void returnBook(String isbn) {
        Book book = bookRepository.findBookByIsbn(isbn);
        if (book.isAvailable()) {
            throw new LibraryException("El libro ya esta disponible, no puede devolverse: " + isbn);
        }
        book.setAvailable(true);
    }

 }
