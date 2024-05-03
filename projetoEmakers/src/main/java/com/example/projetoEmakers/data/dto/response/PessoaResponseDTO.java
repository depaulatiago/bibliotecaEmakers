package com.example.projetoEmakers.data.dto.response;

import com.example.projetoEmakers.data.entity.Pessoa;

public record PessoaResponseDTO(
    Long idPessoa,
    String nome,
    String cep
) {
    public PessoaResponseDTO(Pessoa pessoa) {
        this(pessoa.getIdPessoa(), pessoa.getNome(), pessoa.getCep());
    }
}
