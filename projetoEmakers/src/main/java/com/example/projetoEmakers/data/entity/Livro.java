package com.example.projetoEmakers.data.entity;

import com.example.projetoEmakers.data.dto.request.LivroRequestDTO;
import jakarta.persistence.Table;
import jakarta.persistence.metamodel.SingularAttribute;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "livro")
public class Livro {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idLivro;

    @Getter
    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Getter
    @Column(name = "autor", nullable = false, length = 45)
    private String autor;

    @Column(name = "dataLancamento", nullable = false)
    private int dataLancamento;

    @Getter
    @Column(name = "disponivel", nullable = false)
    private boolean disponivel;

    @Getter
    @Setter
    @Column(name = "contadorEmprestimo", nullable = true)
    private Integer contadorEmprestimo;

    @Builder
    public Livro(LivroRequestDTO livroRequestDTO) {
        this.nome = livroRequestDTO.nome();
        this.autor = livroRequestDTO.autor();
        this.dataLancamento = livroRequestDTO.dataLancamento();
        this.disponivel = true;
        this.contadorEmprestimo = 0;
    }

    public int getContadorEmprestimo() {
        return contadorEmprestimo != null ? contadorEmprestimo : 0;
    }

    public Long setIdLivro(Long idLivro) {
        return this.idLivro = idLivro;
    }

    public String setNome(String nome) {
        return this.nome = nome;
    }

    public String setAutor(String autor) {
        return this.autor = autor;
    }

    public Long setLivro(long idLivro) {
        return this.idLivro = idLivro;
    }

    public boolean setDisponivel(boolean disponivel) {
        return this.disponivel = disponivel;
    }

    public Long getLivro(long idLivro) {
        return this.idLivro = idLivro;
    }

}