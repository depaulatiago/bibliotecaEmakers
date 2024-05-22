package com.example.projetoEmakers.data.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record LivroRequestDTO(

        @NotNull(message = "O id do livro não pode ser nulo")
        int idLivro,

        @NotBlank(message = "O nome do livro não pode ser nulo")
        String nome,

        @NotBlank(message = "O  do livro não pode ser nulo")
        String autor,

        @NotNull(message = "A data de lançamento do livro não pode ser nula")
        int dataLancamento

        ) {
}
