package com.example.projetoEmakers.data.dto.request;

import jakarta.validation.constraints.NotBlank;


public record LivroRequestDTO(

        @NotBlank(message = "O id do livro não pode ser nulo")
        int idLivro,

        @NotBlank(message = "O nome do livro não pode ser nulo")
        String nome,

        @NotBlank(message = "O autor do livro não pode ser nulo")
        String autor,

        @NotBlank(message = "A data de lançamento do livro não pode ser nula")
        int dataLancamento

        ) {
}
