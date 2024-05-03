package com.example.projetoEmakers.service;

import com.example.projetoEmakers.data.dto.request.PessoaRequestDTO;
import com.example.projetoEmakers.data.dto.response.PessoaResponseDTO;
import com.example.projetoEmakers.data.entity.Pessoa;
import com.example.projetoEmakers.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository PessoaRepository;

    public List<PessoaResponseDTO> getAllPessoa() {
        List<Pessoa> pessoa = PessoaRepository.findAll();
        return pessoa.stream().map(PessoaResponseDTO::new).collect(Collectors.toList());
    }

    public PessoaResponseDTO getPessoaById(Long idPessoa) {
        Pessoa pessoa = getPessoaEntityById(idPessoa);
        return new PessoaResponseDTO(pessoa);
    }

    public PessoaResponseDTO createPessoa(PessoaRequestDTO pessoaRequestDTO) {
        Pessoa pessoa = new Pessoa(pessoaRequestDTO);
        PessoaRepository.save(pessoa);

        return new PessoaResponseDTO(pessoa);
    }

    public PessoaResponseDTO updatePessoa(Long idPessoa, PessoaRequestDTO pessoaRequestDTO) {
        Pessoa pessoa = getPessoaEntityById(idPessoa);
        pessoa.setPessoa((long) pessoaRequestDTO.idPessoa());
        PessoaRepository.save(pessoa);

        return new PessoaResponseDTO(pessoa);
    }

    public String deletePessoa(Long idEmprestimo) {
        Pessoa pessoa = getPessoaEntityById(idEmprestimo);
        PessoaRepository.delete(pessoa);

        return "Category id: " + idEmprestimo + " deleted successfully!";
    }

    private Pessoa getPessoaEntityById(Long idPessoa) {
        return PessoaRepository.findById(idPessoa).orElseThrow(() -> new RuntimeException("Pessoa não encontrado"));
    }
}

