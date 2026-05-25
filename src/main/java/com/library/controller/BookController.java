package com.library.controller;

import com.library.entity.Book;
import com.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public Book criar(@RequestBody Book book) {
        return service.criar(book);
    }

    @GetMapping
    public List<Book> listarTodos() {
        return service.listarTodos();
    }
}