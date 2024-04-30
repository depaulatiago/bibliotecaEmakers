package com.example.projetoEmakers.repository;

import com.example.projetoEmakers.data.entity.Pessoa;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
}
