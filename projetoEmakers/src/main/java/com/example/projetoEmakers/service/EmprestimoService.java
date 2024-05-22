package com.example.projetoEmakers.service;

import com.example.projetoEmakers.data.dto.request.EmprestimoRequestDTO;
import com.example.projetoEmakers.data.dto.response.EmprestimoResponseDTO;
import com.example.projetoEmakers.data.entity.Emprestimo;
import com.example.projetoEmakers.data.entity.Livro;
import com.example.projetoEmakers.data.entity.Pessoa;
import com.example.projetoEmakers.exceptions.general.EntityNotFoundException;
import com.example.projetoEmakers.repository.EmprestimoRepository;
import com.example.projetoEmakers.repository.LivroRepository;
import com.example.projetoEmakers.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmprestimoService {
    @Autowired
    private EmprestimoRepository emprestimoRepository;
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    public List<EmprestimoResponseDTO> getAllEmprestimos(){
        List<Emprestimo> emprestimo = emprestimoRepository.findAll();
        return emprestimo.stream().map(EmprestimoResponseDTO::new).collect(Collectors.toList());
    }

    public EmprestimoResponseDTO getEmprestimoById(Long idEmprestimo){
        Emprestimo emprestimo = getEmprestimoEntityById(idEmprestimo);
        return new EmprestimoResponseDTO(emprestimo);
    }

    public EmprestimoResponseDTO createEmprestimo(EmprestimoRequestDTO emprestimoRequestDTO, Livro idLivro, Pessoa idPessoa){
        Livro livro = livroRepository.findById(emprestimoRequestDTO.idLivro().getIdLivro())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        if (!livro.isDisponivel()) {
            throw new RuntimeException("O livro não está disponível para empréstimo");
        }

        Pessoa pessoa = pessoaRepository.findById(emprestimoRequestDTO.idPessoa().getIdPessoa())
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        Emprestimo emprestimo = new Emprestimo(emprestimoRequestDTO, livro, pessoa);
        emprestimoRepository.save(emprestimo);
        livro.setDisponivel(false);
        livro.setContadorEmprestimo(livro.getContadorEmprestimo() + 1);
        livroRepository.save(livro);

        return  new EmprestimoResponseDTO(emprestimo);
    }

    public EmprestimoResponseDTO updateEmprestimo(Long idEmprestimo, EmprestimoRequestDTO emprestimoRequestDTO){
        Emprestimo emprestimo = getEmprestimoEntityById(idEmprestimo);
        emprestimo.setLivro(emprestimoRequestDTO.idLivro().getIdLivro());
        emprestimo.setPessoa(emprestimoRequestDTO.idPessoa().getIdPessoa());
        emprestimoRepository.save(emprestimo);

        return  new EmprestimoResponseDTO(emprestimo);
    }

    public String deleteEmprestimo(Long idEmprestimo){
        Emprestimo emprestimo = getEmprestimoEntityById(idEmprestimo);
        emprestimoRepository.delete(emprestimo);

        return "Category id: " + idEmprestimo + " deleted successfully!";
    }

    public void devolverLivro(Long idEmprestimo) {
        Emprestimo emprestimo = emprestimoRepository.findById(idEmprestimo)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));
        Livro livro = emprestimo.getLivro();
        livro.setDisponivel(true);
        livroRepository.save(livro);
    }

    private Emprestimo getEmprestimoEntityById(Long idEmprestimo) {
        return emprestimoRepository.findById(idEmprestimo).orElseThrow(()-> new EntityNotFoundException(idEmprestimo));
    }
}
