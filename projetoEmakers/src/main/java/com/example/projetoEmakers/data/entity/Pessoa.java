package com.example.projetoEmakers.data.entity;

import com.example.projetoEmakers.data.dto.request.PessoaRequestDTO;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "pessoa")
public class Pessoa {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idPessoa;

    @Column(name = "nome", nullable = false, length = 80)
    private String nome;

    @Column(name = "cep", nullable = false, length = 9)
    private String cep;

    public Pessoa(PessoaRequestDTO pessoaRequestDTO) {
        this.nome = pessoaRequestDTO.nome();
        this.cep = pessoaRequestDTO.cep();
    }

    public void setPessoa(@NotBlank(message = "O id da pessoa não pode ser nulo") Long idPessoa) {
        this.idPessoa = idPessoa;
    }


}
