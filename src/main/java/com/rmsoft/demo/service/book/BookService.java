package com.rmsoft.demo.service.book;

import com.rmsoft.demo.domain.Book;
import java.util.List;

public interface BookService {
    List<Book> findAll();
    void insert(Book book);

    void update(Book book);

    Book findById(Long id);
}
