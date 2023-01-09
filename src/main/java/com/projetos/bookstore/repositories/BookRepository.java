package com.projetos.bookstore.repositories;

import com.projetos.bookstore.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<BookModel, UUID> {

}
