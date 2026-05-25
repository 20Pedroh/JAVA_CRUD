package com.library.library_api.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long id) {
        super("Livro com ID " + id + " não encontrado");
    }
}