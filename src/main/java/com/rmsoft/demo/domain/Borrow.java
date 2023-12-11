package com.rmsoft.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Borrow {
    private Long id;
    private Long memberId;
    private Long bookId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date borrowDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;

    // 조인으로 얻어온 memberId와 bookName 을 담기 위함
    private String memberIdStr;
    private String bookName;
}
