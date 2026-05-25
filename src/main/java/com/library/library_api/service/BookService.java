package com.library.library_api.service;

import com.library.library_api.entity.Book;
import com.library.library_api.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book criar(Book book) {
        return repository.save(book);
    }

    public List<Book> listarTodos() {
        return repository.findAll();
    }
}