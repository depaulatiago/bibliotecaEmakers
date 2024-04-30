package com.example.projetoEmakers.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projetoEmakers.data.entity.Emprestimo;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{
}
