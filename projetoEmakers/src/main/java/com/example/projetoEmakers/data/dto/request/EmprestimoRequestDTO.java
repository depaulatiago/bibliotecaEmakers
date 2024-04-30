package com.example.projetoEmakers.data.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public record EmprestimoRequestDTO(

        @NotBlank(message = "O id do emprestimo não pode ser nulo")
        long idEmprestimo,

    @NotBlank(message = "O id do livro deve conter apenas números")
    Long idLivro,

    @NotBlank(message = "O id da pessoa deve conter apenas números")
    Long idPessoa
    ) {
}
