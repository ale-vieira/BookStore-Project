package com.projetos.bookstore.services;

import com.projetos.bookstore.models.BookModel;
import com.projetos.bookstore.repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public BookModel save(BookModel bookModel) {
        return bookRepository.save(bookModel);
    }

    public List<BookModel> findAll() {
        return bookRepository.findAll();
    }

    public Optional<BookModel> findById(UUID bookId) {
        return bookRepository.findById(bookId);
    }

    @Transactional
    public void delete(UUID bookID) {
        bookRepository.deleteById(bookID);
    }


}
