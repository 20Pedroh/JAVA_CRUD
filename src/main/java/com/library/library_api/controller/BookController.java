package com.library.library_api.controller;

import com.library.library_api.dto.BookRequestDTO;
import com.library.library_api.dto.BookResponseDTO;
import com.library.library_api.service.BookService;
import jakarta.validation.Valid;
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
    public BookResponseDTO criar(@RequestBody @Valid BookRequestDTO dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<BookResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public BookResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public BookResponseDTO atualizar(
            @PathVariable Long id,
            @RequestBody @Valid BookRequestDTO dto
    ) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}