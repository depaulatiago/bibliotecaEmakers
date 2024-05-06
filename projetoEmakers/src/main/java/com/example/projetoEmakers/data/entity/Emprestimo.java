package com.example.projetoEmakers.data.entity;

import com.example.projetoEmakers.data.dto.request.EmprestimoRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;

    @ManyToOne
    @JoinColumn(name = "idLivro")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;

    @Builder
    public Emprestimo(EmprestimoRequestDTO emprestimoRequestDTO, @NotNull(message = "O id do livro não pode ser nulo") Livro livro, @NotNull(message = "O id da pessoa não pode ser nulo") Pessoa pessoa) {
        this.livro = livro;
        this.pessoa = pessoa;
    }

    public Long getIdLivro() {
        return livro.getIdLivro();
    }

    public Long getIdPessoa() {
        return pessoa.getIdPessoa();
    }

    public void setLivro(Long idLivro) {
        this.livro.setIdLivro(idLivro);
    }

    public void setPessoa(Long idPessoa) {
        this.pessoa.setIdPessoa((long) idPessoa);
    }
}
