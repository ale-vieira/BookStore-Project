package com.projetos.bookstore.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String category;
    private String summary;

}


