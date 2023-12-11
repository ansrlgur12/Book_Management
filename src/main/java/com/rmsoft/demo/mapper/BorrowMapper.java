package com.rmsoft.demo.mapper;

import com.rmsoft.demo.domain.Book;
import com.rmsoft.demo.domain.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BorrowMapper {
    @Select("SELECT br.id, m.id AS member_number, m.member_id, b.id As book_number, b.book_name, br.borrow_date, br.return_date " +
            "FROM BORROW br " +
            "JOIN MEMBER m ON br.member_id = m.id " +
            "JOIN BOOK b ON br.book_id = b.id " +
            "WHERE br.book_id = #{bookId}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "member_number", property = "memberId"),
            @Result(column = "book_number", property = "bookId"),
            @Result(column = "member_id", property = "memberIdStr"),
            @Result(column = "book_name", property = "bookName"),
            @Result(column = "borrow_date", property = "borrowDate"),
            @Result(column = "return_date", property = "returnDate")
    })
    List<Borrow> findByBookId(@Param("bookId") Long bookId);

    @Insert("INSERT INTO BORROW(member_id, book_id, borrow_date, return_date) VALUES(#{memberId}, #{bookId}, CURRENT_TIMESTAMP(), #{returnDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert (Borrow borrow);

    @Select("SELECT id FROM BORROW WHERE book_id = #{bookId} AND return_date IS NULL")
    Long findIdByBookId(Long bookId);

    @Update("UPDATE BORROW SET return_date = CURRENT_TIMESTAMP() WHERE id = #{id}")
    void returnBook(Long id);
}