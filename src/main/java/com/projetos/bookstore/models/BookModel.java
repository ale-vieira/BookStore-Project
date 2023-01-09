package com.projetos.bookstore.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_BOOK")
public class BookModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID bookId;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String category;
    @Column(columnDefinition = "TEXT")
    private String summary;

}
