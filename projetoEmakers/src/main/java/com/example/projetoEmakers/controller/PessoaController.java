package com.example.projetoEmakers.controller;


import com.example.projetoEmakers.data.dto.request.PessoaRequestDTO;
import com.example.projetoEmakers.data.dto.response.PessoaResponseDTO;
import com.example.projetoEmakers.service.PessoaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pessoa", description = "Endpoints relacionados a pessoa")
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping(value="/all")
    public ResponseEntity<List<PessoaResponseDTO>> getAllPessoa() {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.getAllPessoa());
    }

    @GetMapping(value = "/{idPessoa}")
    public ResponseEntity<PessoaResponseDTO> getPessoaById(@PathVariable Long idPessoa) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.getPessoaById(idPessoa));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<PessoaResponseDTO> createPessoa(@Valid @RequestBody PessoaRequestDTO pessoaRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.createPessoa(pessoaRequestDTO));
    }

    @PutMapping(value = "/update/{idPessoa}")
    public ResponseEntity<PessoaResponseDTO> updatePessoa(@Valid @PathVariable Long idPessoa, @RequestBody PessoaRequestDTO pessoaRequestDTO) {
        PessoaResponseDTO updatedPessoa = pessoaService.updatePessoa(idPessoa, pessoaRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedPessoa);
    }

    @DeleteMapping(value = "/delete/{idPessoa}")
    public ResponseEntity<String> deletePessoa(@PathVariable Long idPessoa) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.deletePessoa(idPessoa));
    }
}
