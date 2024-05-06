package com.example.projetoEmakers.data.dto.response;

import com.example.projetoEmakers.data.entity.Emprestimo;
import com.example.projetoEmakers.data.entity.Livro;


public record EmprestimoResponseDTO(
    Long idEmprestimo,
    Long idLivro,
    Long idPessoa,
    LivroResponseDTO livroResponseDTO,
    PessoaResponseDTO pessoaResponseDTO
) {
    public EmprestimoResponseDTO (Emprestimo emprestimo) {
        this(emprestimo.getIdEmprestimo(), emprestimo.getIdLivro(), emprestimo.getIdPessoa(),
                new LivroResponseDTO(emprestimo.getLivro()), new PessoaResponseDTO(emprestimo.getPessoa()));
    }

}
