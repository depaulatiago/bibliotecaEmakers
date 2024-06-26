package com.example.projetoEmakers.controller;

import com.example.projetoEmakers.data.dto.request.LivroRequestDTO;
import com.example.projetoEmakers.data.dto.response.LivroResponseDTO;
import com.example.projetoEmakers.data.entity.Livro;
import com.example.projetoEmakers.service.LivroService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Tag(name = "Livro", description = "Endpoints relacionados a livro")
@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping(value="/all")
    public ResponseEntity<List<LivroResponseDTO>> getAllLivro() {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.getAllLivro());
    }

    @GetMapping(value = "/{idLivro}")
    public ResponseEntity<LivroResponseDTO> getLivroById(@PathVariable Long idLivro) {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.getLivroById(idLivro));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<LivroResponseDTO> createLivro(@Valid @RequestBody LivroRequestDTO livroRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.createLivro(livroRequestDTO));
    }

    @PutMapping(value = "/update/{idLivro}")
    public ResponseEntity<LivroResponseDTO> updateLivro(@Valid @PathVariable Long idLivro, @RequestBody LivroRequestDTO livroRequestDTO) {
        LivroResponseDTO updatedLivro = livroService.updateLivro(idLivro, livroRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedLivro);
    }

    @DeleteMapping(value = "/delete/{idLivro}")
    public ResponseEntity<String> deleteLivro(@PathVariable Long idLivro) {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.deleteLivro(idLivro));
    }
}
