package br.com.musicalis.musicalis.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicalis.musicalis.dto.atualizacao.AtualizarFrequenciaDto;
import br.com.musicalis.musicalis.dto.cadastro.CadastrarFrequenciaDto;
import br.com.musicalis.musicalis.dto.listagem.ListarFrequenciasDto;
import br.com.musicalis.musicalis.entity.Aluno;
import br.com.musicalis.musicalis.entity.Frequencia;
import br.com.musicalis.musicalis.entity.Professor;
import br.com.musicalis.musicalis.repository.AlunoRepository;
import br.com.musicalis.musicalis.repository.FrequenciaRepository;
import br.com.musicalis.musicalis.repository.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FrequenciaService {
    @Autowired
    private FrequenciaRepository frequenciaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public void cadastrarFrequencia(CadastrarFrequenciaDto dto) {
        Frequencia frequencia = new Frequencia(dto);
        Aluno aluno = alunoRepository.findById(dto.idAluno()).orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
        Professor professor = professorRepository.findById(dto.idProfessor()).orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));

        frequencia.setAluno(aluno);
        frequencia.setProfessor(professor);
        frequenciaRepository.save(frequencia);
    }

    public List<ListarFrequenciasDto> listarFrequencias(int limit, int offset) {
        return frequenciaRepository.listarFrequencias(limit,offset);
    }

    public void atualizar(AtualizarFrequenciaDto dto) {
        
        Frequencia frequencia = frequenciaRepository.findById(dto.id()).orElseThrow(() -> new EntityNotFoundException("Frequencia não encontrada"));

        if(dto.idAluno() != null && dto.idAluno() != frequencia.getAluno().getId()) {
            Aluno aluno = alunoRepository.findById(dto.idAluno()).orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
            frequencia.setAluno(aluno);
        }

        if(dto.idProfessor() != null && dto.idProfessor() != frequencia.getProfessor().getId()) {
            Professor professor = professorRepository.findById(dto.idProfessor()).orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));
            frequencia.setProfessor(professor);
        }

        frequencia.setData(dto.data());
        frequencia.setPresenca(dto.presenca());
        frequencia.setGrupo(dto.grupo());
        frequencia.setTipo(dto.tipo());

        frequenciaRepository.save(frequencia);
    }

    public void deletar(Long id) {
        Frequencia frequencia = frequenciaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Frequencia não encontrada"));
        frequenciaRepository.delete(frequencia);
    }
}
