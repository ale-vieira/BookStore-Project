package com.projetos.bookstore.controllers;

import com.projetos.bookstore.dtos.BookDto;
import com.projetos.bookstore.models.BookModel;
import com.projetos.bookstore.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/book-register")
    public ResponseEntity<BookModel> bookRegister(@RequestBody @Valid BookDto bookDto) {
        BookModel bookModel = new BookModel();
        BeanUtils.copyProperties(bookDto, bookModel);
        bookService.save(bookModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(bookModel));
    }

    @GetMapping(value = "/books")
    public ResponseEntity<List<BookModel>> findAll() {
        List<BookModel> list = bookService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{bookId}")
    public ResponseEntity<BookModel> findById(@PathVariable(value = "bookId") UUID bookId) {
        Optional<BookModel> bookModelOptional = bookService.findById(bookId);
        return ResponseEntity.status(HttpStatus.OK).body(bookModelOptional.get());
    }

    @DeleteMapping(value = "book-delete/{bookId}")
    public ResponseEntity<Void> delete(@PathVariable UUID bookId) {
        bookService.delete(bookId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "book-update/{bookId}")
    public ResponseEntity<BookModel> update(@PathVariable(value = "bookId") UUID bookId, @RequestBody @Valid BookDto bookDto) {
        Optional<BookModel> bookModelOptional = bookService.findById(bookId);
        BookModel bookModel = new BookModel();
        BeanUtils.copyProperties(bookDto, bookModel);
        bookModel.setBookId(bookModelOptional.get().getBookId());
        return ResponseEntity.status(HttpStatus.OK).body(bookService.save(bookModel));
    }


}
