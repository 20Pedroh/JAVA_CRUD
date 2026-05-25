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

    public Book buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    public Book atualizar(Long id, Book bookAtualizado) {

        Book book = buscarPorId(id);

        book.setTitulo(bookAtualizado.getTitulo());
        book.setAutor(bookAtualizado.getAutor());
        book.setIsbn(bookAtualizado.getIsbn());
        book.setAnoPublicacao(bookAtualizado.getAnoPublicacao());
        book.setDisponivel(bookAtualizado.getDisponivel());

        return repository.save(book);
    }

    public void deletar(Long id) {

        Book book = buscarPorId(id);

        repository.delete(book);
    }
}