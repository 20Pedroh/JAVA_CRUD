package com.library.library_api.service;

import com.library.library_api.dto.BookRequestDTO;
import com.library.library_api.dto.BookResponseDTO;
import com.library.library_api.entity.Book;
import com.library.library_api.repository.BookRepository;
import org.springframework.stereotype.Service;
import com.library.library_api.exception.BookNotFoundException;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public BookResponseDTO criar(BookRequestDTO dto) {

        Book book = new Book();

        book.setTitulo(dto.titulo());
        book.setAutor(dto.autor());
        book.setIsbn(dto.isbn());
        book.setAnoPublicacao(dto.anoPublicacao());
        book.setDisponivel(true);

        Book bookSalvo = repository.save(book);

        return converterParaDTO(bookSalvo);
    }

    public List<BookResponseDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public BookResponseDTO buscarPorId(Long id) {

        Book book = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        return converterParaDTO(book);
    }

    public BookResponseDTO atualizar(Long id, BookRequestDTO dto) {

        Book book = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        book.setTitulo(dto.titulo());
        book.setAutor(dto.autor());
        book.setIsbn(dto.isbn());
        book.setAnoPublicacao(dto.anoPublicacao());

        Book atualizado = repository.save(book);

        return converterParaDTO(atualizado);
    }

    public void deletar(Long id) {

        Book book = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        repository.delete(book);
    }

    private BookResponseDTO converterParaDTO(Book book) {

        return new BookResponseDTO(
                book.getId(),
                book.getTitulo(),
                book.getAutor(),
                book.getIsbn(),
                book.getAnoPublicacao(),
                book.getDisponivel()
        );
    }
}