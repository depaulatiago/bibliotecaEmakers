package com.example.projetoEmakers.data.dto.request;

import com.example.projetoEmakers.data.entity.Livro;
import com.example.projetoEmakers.data.entity.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;


public record EmprestimoRequestDTO(

        @NotNull(message = "O id do emprestimo não pode ser nulo")
        long idEmprestimo,

        @NotNull(message = "O id do livro não pode ser nulo")
        Livro idLivro,

        @NotNull(message = "O id da pessoa não pode ser nulo")
        Pessoa idPessoa
    ) {
}
