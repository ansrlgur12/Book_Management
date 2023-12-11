package com.rmsoft.demo.domain;

import lombok.Data;

@Data
public class Book {
    private Long id;
    private String bookName;
    private String author;
    private String status;
}
