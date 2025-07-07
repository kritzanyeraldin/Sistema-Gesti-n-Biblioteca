package org.example.filter;

import org.example.domain.Book;

public class AuthorFilter implements BookFilter{
    private final String author;

    public AuthorFilter(String author) {
        this.author = author;
    }

    @Override
    public boolean apply(Book book) {
        return book.getAuthor().equalsIgnoreCase(author);
    }
}
