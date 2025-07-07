package org.example.filter;

import org.example.domain.Book;

public interface BookFilter {
    boolean apply(Book book);
}

