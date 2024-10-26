package br.com.musicalis.musicalis.service;

import br.com.musicalis.musicalis.dto.atualizacao.AtualizarProfessorDto;
import br.com.musicalis.musicalis.dto.listagem.ListarProfessorDto;
import br.com.musicalis.musicalis.dto.visualizacao.VisualizarProfessorDro;
import br.com.musicalis.musicalis.entity.Professor;
import br.com.musicalis.musicalis.repository.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public void salvar(Professor professor) {
        professorRepository.save(professor);
    }

    public void inativar(Long id) {
        Professor professor = professorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));

        professor.setStatus(false);

        professorRepository.save(professor);
    }

    public void atualizar(AtualizarProfessorDto dto) {
        Professor professor = professorRepository.findById(dto.id()).orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));

        professor.setCpf(dto.cpf());
        professor.setDtNasc(dto.dtNasc());
        professor.setGrupo(dto.grupo());
        professor.setInstrumento(dto.instrumento());
        professor.setMatricula(dto.matricula());
        professor.setNome(dto.nome());
        professor.setRg(dto.rg());
        professor.setLogin(dto.login());
        professor.setNome(dto.nome());
        professor.setSenha(dto.senha());

        professorRepository.save(professor);
    }

    public List<ListarProfessorDto> listar(Character grupo) {
        return this.professorRepository.findAllByGrupo(grupo).stream().map(ListarProfessorDto::new).toList();
    }

    public VisualizarProfessorDro visualizar(Long id) {
        Professor professor = this.professorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));
        return new VisualizarProfessorDro(professor);

    }
}
