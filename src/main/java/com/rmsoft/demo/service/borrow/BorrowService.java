package com.rmsoft.demo.service.borrow;

import com.rmsoft.demo.domain.Borrow;

import java.util.List;

public interface BorrowService {
    List<Borrow> borrowHistory(Long bookId);
    void borrow(Borrow borrow);
    void returnBook(Long id);
}
