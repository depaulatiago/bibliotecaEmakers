package com.example.projetoEmakers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projetoEmakers.data.entity.Livro;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
}
