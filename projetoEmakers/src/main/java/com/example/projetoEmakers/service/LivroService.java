package com.example.projetoEmakers.service;

import com.example.projetoEmakers.data.dto.request.EmprestimoRequestDTO;
import com.example.projetoEmakers.data.dto.request.LivroRequestDTO;
import com.example.projetoEmakers.data.dto.response.EmprestimoResponseDTO;
import com.example.projetoEmakers.data.dto.response.LivroResponseDTO;
import com.example.projetoEmakers.data.entity.Emprestimo;
import com.example.projetoEmakers.data.entity.Livro;
import com.example.projetoEmakers.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<LivroResponseDTO> getAllLivro() {
        List<Livro> livro = livroRepository.findAll();
        return livro.stream().map(LivroResponseDTO::new).collect(Collectors.toList());
    }

    public LivroResponseDTO getLivroById(Long idLivro) {
        Livro livro = getLivroEntityById(idLivro);
        return new LivroResponseDTO(livro);
    }

    public LivroResponseDTO createLivro(LivroRequestDTO livroRequestDTO) {
        Livro livro = new Livro(livroRequestDTO);
        livroRepository.save(livro);

        return new LivroResponseDTO(livro);
    }

    public LivroResponseDTO updateLivro(Long idLivro, LivroRequestDTO livroRequestDTO) {
        Livro livro = getLivroEntityById(idLivro);
        livro.setLivro(livroRequestDTO.idLivro());
        livroRepository.save(livro);

        return new LivroResponseDTO(livro);
    }

    public String deleteLivro(Long idEmprestimo) {
        Livro livro = getLivroEntityById(idEmprestimo);
        livroRepository.delete(livro);

        return "Category id: " + idEmprestimo + " deleted successfully!";
    }

    private Livro getLivroEntityById(Long idLivro) {
        return livroRepository.findById(idLivro).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }
}
