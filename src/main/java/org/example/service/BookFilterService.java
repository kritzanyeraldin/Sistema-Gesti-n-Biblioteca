package org.example.service;
import org.example.domain.Book;
import org.example.filter.BookFilter;
import org.example.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BookFilterService {
    private final BookRepository bookRepository;

    public BookFilterService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> filterBooks(BookFilter filter) {
        return bookRepository.getAllBooks().stream()
                .filter(filter::apply)
                .collect(Collectors.toList());
    }
}


