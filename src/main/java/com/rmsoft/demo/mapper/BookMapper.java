package com.rmsoft.demo.mapper;

import com.rmsoft.demo.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("SELECT * FROM BOOK")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "book_name", property = "bookName"),
            @Result(column = "author", property = "author")
    })
    List<Book> findAll();

    @Insert("INSERT INTO BOOK(book_name, author) VALUES(#{bookName}, #{author})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert (Book book);

    @Update("UPDATE BOOK SET book_name = #{bookName}, author = #{author} WHERE id = #{id}")
    void update(Book book);

    @Update("UPDATE BOOK SET status = 'Borrowed' WHERE id = #{id}")
    void borrowed(Long id);

    @Update("UPDATE BOOK SET status = 'Borrowable' WHERE id = #{id}")
    void returned(Long id);

    @Select("SELECT * FROM BOOK WHERE id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "book_name", property = "bookName"),
            @Result(column = "author", property = "author")
    })
    Book findById(@Param("id") Long id);
}
