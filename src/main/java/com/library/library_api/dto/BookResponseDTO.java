package com.library.library_api.dto;

public record BookResponseDTO(
        Long id,
        String title,
        String author,
        String isbn,
        Integer publicationYear,
        Boolean available
) {
}