package br.com.musicalis.musicalis.service;

import br.com.musicalis.musicalis.dto.atualizacao.AtualizarPatrimonioDto;
import br.com.musicalis.musicalis.dto.listagem.ListarAlunoDto;
import br.com.musicalis.musicalis.dto.listagem.ListarPatrimonioDto;
import br.com.musicalis.musicalis.dto.visualizacao.VisualizarPatrimonioDto;
import br.com.musicalis.musicalis.entity.Aluno;
import br.com.musicalis.musicalis.entity.Patrimonio;
import br.com.musicalis.musicalis.repository.AlunoRepository;
import br.com.musicalis.musicalis.repository.PatrimonioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatrimonioService {

    @Autowired
    private PatrimonioRepository patrimonioRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    public void salvar(Patrimonio patrimonio) {
        this.patrimonioRepository.save(patrimonio);
    }

    public void deletar(Long id) {
        Patrimonio patrimonio = this.patrimonioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patrimônio não encontrado"));
        this.patrimonioRepository.delete(patrimonio);
    }


    public void atualizar(AtualizarPatrimonioDto dto) {
        Patrimonio patrimonio = this.patrimonioRepository.findById(dto.codigo()).orElseThrow(() -> new EntityNotFoundException("Patrimônio não encontrado"));
        if (dto.idAlunoResponsavel() != patrimonio.getAlunoResponsavel().getId()) {
            Aluno aluno = this.alunoRepository.findById(dto.idAlunoResponsavel()).orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
            patrimonio.setAlunoResponsavel(aluno);
        }
        patrimonio.setDescricao(dto.descricao());
        patrimonio.setInstrumento(dto.instrumento());
    }

    public List<ListarPatrimonioDto> listar() {
        return this.patrimonioRepository.findAll().stream().map(ListarPatrimonioDto::new).toList();
    }

    public VisualizarPatrimonioDto visualizar(Long id) {
        return new VisualizarPatrimonioDto(this.patrimonioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patrimônio não encontrado")));
    }
}
