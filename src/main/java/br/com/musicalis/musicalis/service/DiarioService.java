package br.com.musicalis.musicalis.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicalis.musicalis.dto.atualizacao.AtualizarDiarioDto;
import br.com.musicalis.musicalis.dto.cadastro.CadastrarDiarioDto;
import br.com.musicalis.musicalis.dto.visualizacao.VisualizarDiarioDto;
import br.com.musicalis.musicalis.entity.Aluno;
import br.com.musicalis.musicalis.entity.Diario;
import br.com.musicalis.musicalis.entity.Professor;
import br.com.musicalis.musicalis.repository.AlunoRepository;
import br.com.musicalis.musicalis.repository.DiarioRepository;
import br.com.musicalis.musicalis.repository.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DiarioService {
    @Autowired
    private DiarioRepository diarioRepository;
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ProfessorRepository professorRepository;

    public void save(CadastrarDiarioDto dto) {
        Aluno aluno = alunoRepository.findById(dto.idAluno()).orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
        Professor professor = professorRepository.findById(dto.idProfessor()).orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));

        Diario diario = new Diario(dto);
        diario.setAluno(aluno);
        diario.setProfessor(professor);
        diarioRepository.save(diario);
        
    }

    public void update(AtualizarDiarioDto dto) {
        Diario diario = diarioRepository.findById(dto.id()).orElseThrow(() -> new EntityNotFoundException("Diario nao encontrado"));
        Aluno aluno = new Aluno();
        if(dto.idAluno() != null && dto.idAluno() != diario.getAluno().getId()) {
            aluno = alunoRepository.findById(dto.idAluno()).orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));     
            diario.setAluno(aluno);   
        }
        diario.setData(dto.data());
        diario.setPresenca(dto.presenca());
        diario.setObs(dto.obs());
        diarioRepository.save(diario);
    }

    public void delete(Long id) {
        Diario diario = diarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Diario nao encontrado"));
        diarioRepository.delete(diario);
    }

    public List<Diario> listarDiarios(){
        return diarioRepository.findAll();
    }

    public VisualizarDiarioDto visualizarDiario(Long id){
        Diario diario = diarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Diario nao encontrado"));
        VisualizarDiarioDto dto = new VisualizarDiarioDto(diario);
        return dto;
    }
}
