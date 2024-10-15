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

import br.com.musicalis.musicalis.dto.atualizacao.AtualizarAlunoDto;
import br.com.musicalis.musicalis.dto.cadastro.CadastrarAlunoDto;
import br.com.musicalis.musicalis.dto.listagem.ListarAlunoDto;
import br.com.musicalis.musicalis.entity.Aluno;
import br.com.musicalis.musicalis.service.AlunoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    @Transactional
    public void cadastrarAluno(@RequestBody @Valid CadastrarAlunoDto dto){
        this.alunoService.save(new Aluno(dto));
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id){
        this.alunoService.delete(id);
    }

    @PutMapping
    @Transactional
    public void atualizarAluno(@RequestBody @Valid AtualizarAlunoDto dto){
        this.alunoService.atualizar(dto);
    }

    @GetMapping("/listar/grupo/{grupo}")	
    public List<ListarAlunoDto> listarAlunos(Character grupo){
        return this.alunoService.listarAlunos(grupo);
    }
}
