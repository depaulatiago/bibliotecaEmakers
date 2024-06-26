package com.example.projetoEmakers.service;

import com.example.projetoEmakers.data.dto.request.LivroRequestDTO;
import com.example.projetoEmakers.data.dto.response.LivroResponseDTO;
import com.example.projetoEmakers.data.entity.Livro;

import com.example.projetoEmakers.exceptions.general.EntityNotFoundException;
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
        Livro livro = livroRepository.findById(idLivro)
                .orElseThrow(() -> new EntityNotFoundException(idLivro));

        livro.setNome(livroRequestDTO.nome());
        livro.setAutor(livroRequestDTO.autor());
        livro.setDataLancamento(livroRequestDTO.dataLancamento());
        livroRepository.save(livro);

        return new LivroResponseDTO(livro);
    }

    public String deleteLivro(Long idLivro) {
        Livro livro = getLivroEntityById(idLivro);
        livroRepository.delete(livro);

        return "Category id: " + idLivro + " deleted successfully!";
    }

    private Livro getLivroEntityById(Long idLivro) {
        return livroRepository.findById(idLivro).orElseThrow(() -> new EntityNotFoundException(idLivro));
    }
}
