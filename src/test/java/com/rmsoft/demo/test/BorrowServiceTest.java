package com.rmsoft.demo.test;

import com.rmsoft.demo.domain.Borrow;
import com.rmsoft.demo.mapper.BookMapper;
import com.rmsoft.demo.mapper.BorrowMapper;
import com.rmsoft.demo.mapper.MemberMapper;
import com.rmsoft.demo.service.book.BookServiceImpl;
import com.rmsoft.demo.service.borrow.BorrowServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BorrowServiceTest {

    @Mock
    private BorrowMapper borrowMapper;

    @Mock
    private MemberMapper memberMapper;

    @Mock
    private BookMapper bookMapper;

    @InjectMocks
    private BorrowServiceImpl borrowService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void borrowHistory() {
        Long id = 1L;

        when(borrowMapper.findByBookId(id)).thenReturn(Collections.emptyList());

        List<Borrow> result = borrowService.borrowHistory(id);

        verify(borrowMapper).findByBookId(id);

        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void borrow() {
        Borrow borrow = new Borrow();
        borrow.setBookId(1L);
        borrow.setMemberIdStr("id");

        when(memberMapper.findByMemberId(borrow.getMemberIdStr())).thenReturn(1L);

        doNothing().when(bookMapper).borrowed(borrow.getBookId());

        borrowService.borrow(borrow);

        verify(borrowMapper).insert(borrow);

        verify(bookMapper).borrowed(borrow.getBookId());
    }

    @Test
    void borrow_empty() {
        Borrow borrow = new Borrow();
        borrow.setMemberIdStr("");

        assertThrows(IllegalArgumentException.class, () -> borrowService.borrow(borrow));

        verifyNoInteractions(borrowMapper, bookMapper);
    }

    @Test
    void returnBook() {
        Long bookId = 1L;

        when(borrowMapper.findIdByBookId(bookId)).thenReturn(1L);

        borrowService.returnBook(bookId);

        verify(bookMapper).returned(bookId);
    }
}