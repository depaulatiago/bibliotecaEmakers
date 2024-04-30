package com.example.projetoEmakers.data.dto.response;

import com.example.projetoEmakers.data.entity.Livro;

public record LivroResponseDTO(
    Long idLivro,
    String nome,
    String autor,
    int dataLancamento) {

    public LivroResponseDTO(Livro livro) {
        this(livro.getIdLivro(), livro.getNome(), livro.getAutor(), livro.getDataLancamento());
    }
}
