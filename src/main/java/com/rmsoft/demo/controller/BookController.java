package com.rmsoft.demo.controller;

import com.rmsoft.demo.domain.Book;
import com.rmsoft.demo.domain.Member;
import com.rmsoft.demo.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/book")
//@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Book>> getAllBooks() {
        try {
            List<Book> books = bookService.findAll();
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<Book> findById(@PathVariable(name = "id") Long id) {
        try {
            Book book = bookService.findById(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<String> registerMember(@RequestBody Book book) {

        try {
            bookService.insert(book);
            return new ResponseEntity<>("새로운 책 등록 성공", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("책이름과 작가이름을 입력하세요", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>("새로운 책 등록 실패: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateBook(@RequestBody Book book) {

        try {
            bookService.update(book);
            return new ResponseEntity<>("책 수정 성공", HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("책을 찾을 수 없습니다", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("책 수정 실패: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
