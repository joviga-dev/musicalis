package br.com.musicalis.musicalis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicalis.musicalis.dto.atualizacao.AtualizarDiarioDto;
import br.com.musicalis.musicalis.dto.cadastro.CadastrarDiarioDto;
import br.com.musicalis.musicalis.dto.listagem.ListarDiarioDto;
import br.com.musicalis.musicalis.dto.visualizacao.VisualizarDiarioDto;
import br.com.musicalis.musicalis.service.DiarioService;

@RestController
@RequestMapping("/diario")
public class DiarioController {
    @Autowired
    private DiarioService diarioService;
    
    @PostMapping
    public void create(@RequestBody CadastrarDiarioDto dto) {
        this.diarioService.save(dto);
    }

    @PutMapping
    public void update(@RequestBody AtualizarDiarioDto dto) {
        this.diarioService.update(dto);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Long id) {
        this.diarioService.delete(id);
    }

    @GetMapping
    public List<ListarDiarioDto> listarDiarios() {
        return this.diarioService.listarDiarios().stream().map(ListarDiarioDto::new).toList();
    }

    @GetMapping("/id/{id}")
    public VisualizarDiarioDto visualizarDiario(@PathVariable Long id) {
        return this.diarioService.visualizarDiario(id);
    }
}
