package com.rmsoft.demo.service.borrow;

import com.rmsoft.demo.domain.Borrow;
import com.rmsoft.demo.mapper.BookMapper;
import com.rmsoft.demo.mapper.BorrowMapper;
import com.rmsoft.demo.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService{

    @Autowired
    private BorrowMapper borrowMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Borrow> borrowHistory(Long bookId) {
        return borrowMapper.findByBookId(bookId);
    }

    @Override
    public void borrow(Borrow borrow) {
        Long memberId = memberMapper.findByMemberId(borrow.getMemberIdStr());

        if (memberId == null || StringUtils.isEmpty(borrow.getMemberIdStr())) {
            throw new IllegalArgumentException("입력된 id가 없습니다");
        }

        borrow.setMemberId(memberId);
        borrowMapper.insert(borrow);
        bookMapper.borrowed(borrow.getBookId());
    }


    @Override
    public void returnBook(Long id) {

        Long borrowId = borrowMapper.findIdByBookId(id);

        borrowMapper.returnBook(borrowId);
        bookMapper.returned(id);
    }

}
