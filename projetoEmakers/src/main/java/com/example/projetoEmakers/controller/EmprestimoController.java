package com.example.projetoEmakers.controller;

import com.example.projetoEmakers.service.EmprestimoService;
import com.example.projetoEmakers.data.dto.request.EmprestimoRequestDTO;
import com.example.projetoEmakers.data.dto.response.EmprestimoResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping(value="/all")
    public ResponseEntity<List<EmprestimoResponseDTO>> getAllEmprestimo() {
        return ResponseEntity.status(HttpStatus.OK).body(emprestimoService.getAllEmprestimos());
    }

    @GetMapping(value = "/{idEmprestimo}")
    public ResponseEntity<EmprestimoResponseDTO> getEmprestimoById(@PathVariable Long idEmprestimo) {
        return ResponseEntity.status(HttpStatus.OK).body(emprestimoService.getEmprestimoById(idEmprestimo));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<EmprestimoResponseDTO> createEmprestimo(@Valid @RequestBody EmprestimoRequestDTO emprestimoRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoService.createEmprestimo(emprestimoRequestDTO, emprestimoRequestDTO.idLivro(), emprestimoRequestDTO.idPessoa()));
    }

    @PutMapping(value = "/update/{idEmprestimo}")
    public ResponseEntity<EmprestimoResponseDTO> updateEmprestimo(@Valid @PathVariable Long idEmprestimo, @RequestBody EmprestimoRequestDTO emprestimoRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(emprestimoService.updateEmprestimo(idEmprestimo, emprestimoRequestDTO));
    }

    @DeleteMapping(value = "/delete/{idEmprestimo}")
    public ResponseEntity<String> deleteEmprestimo(@PathVariable Long idEmprestimo) {
        return ResponseEntity.status(HttpStatus.OK).body(emprestimoService.deleteEmprestimo(idEmprestimo));
    }
}
