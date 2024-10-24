package br.com.musicalis.musicalis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicalis.musicalis.dto.atualizacao.AtualizarAlunoDto;
import br.com.musicalis.musicalis.dto.listagem.ListarAlunoDto;
import br.com.musicalis.musicalis.entity.Aluno;
import br.com.musicalis.musicalis.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public void save(Aluno aluno) {
        this.alunoRepository.save(aluno);
    }

    public void delete(Long id) {
        Aluno aluno = this.alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
        aluno.setStatus(false);
        this.alunoRepository.save(aluno);

    }

    public void atualizar(AtualizarAlunoDto dto) {
        Aluno aluno = this.alunoRepository.findById(dto.id())
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));

        aluno.setCpf(dto.cpf());
        aluno.setDtNasc(dto.dtNasc());
        aluno.setGrupo(dto.grupo());
        aluno.setInstrumento(dto.instrumento());
        aluno.setMatricula(dto.matricula());
        aluno.setNome(dto.nome());
        aluno.setRg(dto.rg());
        this.alunoRepository.save(aluno);

    }

    public List<ListarAlunoDto> listarAlunos(Character grupo) {
        return this.alunoRepository.findAll().stream().map(ListarAlunoDto::new).toList();
    }
}
