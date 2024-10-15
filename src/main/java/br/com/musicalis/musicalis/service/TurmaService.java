package br.com.musicalis.musicalis.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicalis.musicalis.dto.atualizacao.AtualizarTurmaDto;
import br.com.musicalis.musicalis.dto.listagem.ListarAlunoDto;
import br.com.musicalis.musicalis.dto.listagem.ListarTurmaDto;
import br.com.musicalis.musicalis.entity.Aluno;
import br.com.musicalis.musicalis.entity.Turma;
import br.com.musicalis.musicalis.repository.AlunoRepository;
import br.com.musicalis.musicalis.repository.TurmaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TurmaService {
    @Autowired
    private TurmaRepository turmaRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    public List<ListarTurmaDto> listarTurmas(Character grupo) {
        return this.turmaRepository.findAllByGrupo(grupo).stream().map(ListarTurmaDto::new).toList();
    }

    public void save(Turma turma) {
        this.turmaRepository.save(turma);
    }

    public void delete(Long id) {
        Turma turma = this.turmaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Turma nao encontrado"));        
        this.turmaRepository.delete(turma);
    }

    public void atualizar(AtualizarTurmaDto dto) {
        Turma turma = this.turmaRepository.findById(dto.id()).orElseThrow(() -> new EntityNotFoundException("Turma nao encontrado"));  
        turma.setNome(dto.nome());
        turma.setDtHora(dto.dtHora());
        this.turmaRepository.save(turma);
    }

    public List<ListarAlunoDto> listarAlunosDaTurma(Long idTurma) {
        Turma turma = this.turmaRepository.findById(idTurma).orElseThrow(() -> new EntityNotFoundException("Turma nao encontrado"));          
        return turma.getAlunos().stream().map(ListarAlunoDto::new).toList();
    }

    public void adicionarAluno(Long idTurma, Long idAluno) {
        Turma turma = this.turmaRepository.findById(idTurma).orElseThrow(() -> new EntityNotFoundException("Turma nao encontrado"));  
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));     
        turma.getAlunos().add(aluno);
        this.turmaRepository.save(turma);
    }

    public void removerAluno(Long idTurma, Long idAluno) {
        Turma turma = this.turmaRepository.findById(idTurma).orElseThrow(() -> new EntityNotFoundException("Turma nao encontrado"));  
        turma.getAlunos().remove(alunoRepository.findById(idAluno).orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado")));
        this.turmaRepository.save(turma);
    }

}
