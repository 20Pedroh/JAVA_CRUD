package com.library.library_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookRequestDTO(

        @NotBlank(message = "Título é obrigatório")
        String titulo,

        @NotBlank(message = "Autor é obrigatório")
        String autor,

        @NotBlank(message = "ISBN é obrigatório")
        String isbn,

        @NotNull(message = "Ano é obrigatório")
        Integer anoPublicacao
) {
}