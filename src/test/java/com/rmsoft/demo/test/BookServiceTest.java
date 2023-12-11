package com.rmsoft.demo.test;

import com.rmsoft.demo.domain.Book;
import com.rmsoft.demo.mapper.BookMapper;
import com.rmsoft.demo.service.book.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BookServiceTest {

    @Mock
    private BookMapper bookMapper;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void insert() {
        Book book = new Book();
        book.setBookName("test book");
        book.setAuthor("test Author");

        bookService.insert(book);

        verify(bookMapper).insert(book);
    }

    @Test
    void insert_empty() {
        Book emptyBook = new Book();
        emptyBook.setBookName("");
        emptyBook.setAuthor("");

        assertThrows(IllegalArgumentException.class, () -> bookService.insert(emptyBook));
    }

    @Test
    void update() {
        Book book = new Book();
        doNothing().when(bookMapper).update(book);

        bookService.update(book);

        verify(bookMapper).update(book);
    }

    @Test
    void findById() {
        Long id = 1L;
        Book book = new Book();

        when(bookMapper.findById(id)).thenReturn(book);

        Book book2 = bookService.findById(id);

        verify(bookMapper).findById(id);

        assertEquals(book, book2);
    }
}
