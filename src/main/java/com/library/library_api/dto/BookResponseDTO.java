package com.library.library_api.dto;

public record BookResponseDTO(
        Long id,
        String titulo,
        String autor,
        String isbn,
        Integer anoPublicacao,
        Boolean disponivel
) {
}