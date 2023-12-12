package com.rmsoft.demo.controller;

import com.rmsoft.demo.domain.Book;
import com.rmsoft.demo.domain.Borrow;
import com.rmsoft.demo.mapper.BorrowMapper;
import com.rmsoft.demo.service.borrow.BorrowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/borrow")
//@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private BorrowMapper borrowMapper;

    @PostMapping("/insert")
    public ResponseEntity<String> borrowBook(@RequestBody Borrow borrow) {
        try {
            borrowService.borrow(borrow);
            return new ResponseEntity<>("대출 성공", HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("회원을 찾을 수 없습니다", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("대출 실패: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/return/{id}")
    public ResponseEntity<String> returnBook(@PathVariable(name = "id") Long id) {
        try {
            borrowService.returnBook(id);
            return new ResponseEntity<>("반납 성공", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("대출 기록을 찾을 수 없습니다", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("반납 실패: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/borrowHistory/{bookId}")
    public ResponseEntity<List<Borrow>> borrowHistory(@PathVariable(name = "bookId") Long bookId) {
        try {
            List<Borrow> history = borrowService.borrowHistory(bookId);
            return new ResponseEntity<>(history, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
