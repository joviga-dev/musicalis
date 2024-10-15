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
        Optional<Aluno> aluno = this.alunoRepository.findById(id);
        if(aluno.isPresent()) {
            aluno.get().setStatus(false);
            this.alunoRepository.save(aluno.get());
        } else {
            throw new EntityNotFoundException("Aluno não encontrado");
        }
    }

    public void atualizar(AtualizarAlunoDto dto) {
        Optional<Aluno> aluno = this.alunoRepository.findById(dto.id());
        if(aluno.isPresent()) {
            Aluno alunoEncontrado = aluno.get();
            alunoEncontrado.setCpf(dto.cpf());
            alunoEncontrado.setDtNasc(dto.dtNasc());
            alunoEncontrado.setGrupo(dto.grupo());
            alunoEncontrado.setInstrumento(dto.instrumento());
            alunoEncontrado.setMatricula(dto.matricula());
            alunoEncontrado.setNome(dto.nome());
            alunoEncontrado.setRg(dto.rg());
            this.alunoRepository.save(alunoEncontrado);
        } else {
            throw new EntityNotFoundException("Aluno não encontrado");
        }
    }

    public List<ListarAlunoDto> listarAlunos(Character grupo) {
        return this.alunoRepository.findAll().stream().map(ListarAlunoDto::new).toList();
    }
}
