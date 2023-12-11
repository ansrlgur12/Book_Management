package com.rmsoft.demo.service.book;

import com.rmsoft.demo.domain.Book;
import com.rmsoft.demo.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> findAll() {

        return bookMapper.findAll();
    }

    @Override
    @Transactional
    public void insert(Book book) {
        if (StringUtils.isEmpty(book.getBookName()) || StringUtils.isEmpty(book.getAuthor())) {
            throw new IllegalArgumentException("도서명, 작가이름을 입력하세요");
        }

        bookMapper.insert(book);
    }

    @Override
    @Transactional
    public void update(Book book) {
        bookMapper.update(book);
    }

    @Override
    public Book findById(Long id) {
        return bookMapper.findById(id);
    }
}
