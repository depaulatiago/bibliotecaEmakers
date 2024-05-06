package com.example.projetoEmakers.data.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PessoaRequestDTO(

        @NotNull(message = "O id da pessoa não pode ser nulo")
        int idPessoa,

        @NotBlank(message = "O nome da pessoa não pode ser nulo")
        String nome,

        @NotBlank(message = "O cep da pessoa não pode ser nulo")
        String cep
) {
}

