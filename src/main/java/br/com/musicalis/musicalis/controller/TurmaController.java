package br.com.musicalis.musicalis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicalis.musicalis.dto.atualizacao.AtualizarTurmaDto;
import br.com.musicalis.musicalis.dto.cadastro.CadastrarTurmaDto;
import br.com.musicalis.musicalis.dto.listagem.ListarAlunoDto;
import br.com.musicalis.musicalis.dto.listagem.ListarTurmaDto;
import br.com.musicalis.musicalis.entity.Turma;
import br.com.musicalis.musicalis.service.TurmaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping("/cadastrar")
    @Transactional
    public void cadastrarTurma(@RequestBody @Valid CadastrarTurmaDto dto) {
        this.turmaService.save(new Turma(dto));
    }

    @DeleteMapping("/delete/id/{id}")
    public void deletarTurma(@PathVariable Long id) {
        this.turmaService.delete(id);
    }

    @PutMapping("/atualizar")
    @Transactional
    public void atualizarTurma(@RequestBody @Valid AtualizarTurmaDto dto) {
        this.turmaService.atualizar(dto);
    }

    @GetMapping("/listar/grupo/{grupo}")
    public List<ListarTurmaDto> listarTurmas(@PathVariable Character grupo) {
        return this.turmaService.listarTurmas(grupo);
    }

    @GetMapping("/listar/alunos/idTurma/{idTurma}")
    public List<ListarAlunoDto> listarAlunosDaTurma(@PathVariable Long idTurma) {
        return this.turmaService.listarAlunosDaTurma(idTurma);
    }

    @PostMapping("/adicionar/aluno/idTurma/{idTurma}/idAluno/{idAluno}")
    public void adicionarAluno(@PathVariable Long idTurma, @PathVariable Long idAluno) {
        this.turmaService.adicionarAluno(idTurma, idAluno);
    }
    
    @DeleteMapping("/remover/aluno/idTurma/{idTurma}/idAluno/{idAluno}")
    public void removerAluno(@PathVariable Long idTurma, @PathVariable Long idAluno) {
        this.turmaService.removerAluno(idTurma, idAluno);
    }

}
