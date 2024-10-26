package br.com.musicalis.musicalis.controller;

import br.com.musicalis.musicalis.dto.atualizacao.AtualizarProfessorDto;
import br.com.musicalis.musicalis.dto.cadastro.CadastrarProfessorDto;
import br.com.musicalis.musicalis.dto.listagem.ListarProfessorDto;
import br.com.musicalis.musicalis.dto.visualizacao.VisualizarProfessorDro;
import br.com.musicalis.musicalis.entity.Professor;
import br.com.musicalis.musicalis.service.ProfessorService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    
    @Autowired
    private ProfessorService professorService;

    @PostMapping
    @Transactional
    public void cadastrarProfessor(@RequestBody @Valid CadastrarProfessorDto dto){
        this.professorService.salvar(new Professor(dto));
    }

    @DeleteMapping("/id/{id}")
    public void inativarProfessor(@PathVariable Long id){
        this.professorService.inativar(id);
    }

    @PutMapping
    @Transactional
    public void atualizarProfessor(@RequestBody @Valid AtualizarProfessorDto dto){
        this.professorService.atualizar(dto);
    }

    @GetMapping("/listar/grupo/{grupo}")
    public List<ListarProfessorDto> listar(@PathVariable Character grupo){
        return this.professorService.listar(grupo);
    }

    @GetMapping("/visualizar/id/{id}")
    public VisualizarProfessorDro visualizar(@PathVariable Long id){
        return this.professorService.visualizar(id);
    }
}
