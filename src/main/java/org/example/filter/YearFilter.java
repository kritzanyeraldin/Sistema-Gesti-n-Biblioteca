package org.example.filter;

import org.example.domain.Book;
import org.example.filter.BookFilter;

public class YearFilter implements BookFilter {
    private final int year;

    public YearFilter(int year) {
        this.year = year;
    }

    @Override
    public boolean apply(Book book) {
        return book.getYear() == year;
    }
}
