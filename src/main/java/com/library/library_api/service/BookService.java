package com.library.library_api.service;

import com.library.library_api.dto.BookRequestDTO;
import com.library.library_api.dto.BookResponseDTO;
import com.library.library_api.entity.Book;
import com.library.library_api.repository.BookRepository;
import org.springframework.stereotype.Service;
import com.library.library_api.exception.BookNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public BookResponseDTO create(BookRequestDTO dto) {

        Book book = new Book();

        book.setTitle(dto.title());
        book.setAuthor(dto.author());
        book.setIsbn(dto.isbn());
        book.setPublicationYear(dto.publicationYear());
        book.setAvailable(true);

        Book bookSalvo = repository.save(book);

        return converterParaDTO(bookSalvo);
    }

    public Page<BookResponseDTO> findAll(Pageable pageable) {

        return repository.findAll(pageable)
                .map(this::converterParaDTO);
    }

    public BookResponseDTO findById(Long id) {

        Book book = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        return converterParaDTO(book);
    }

    public BookResponseDTO update(Long id, BookRequestDTO dto) {

        Book book = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        book.setTitle(dto.title());
        book.setAuthor(dto.author());
        book.setIsbn(dto.isbn());
        book.setPublicationYear(dto.publicationYear());

        Book atualizado = repository.save(book);

        return converterParaDTO(atualizado);
    }

    public void delete(Long id) {

        Book book = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        repository.delete(book);
    }

    private BookResponseDTO converterParaDTO(Book book) {

        return new BookResponseDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPublicationYear(),
                book.getAvailable()
        );
    }
}