package br.com.musicalis.musicalis.controller;

import br.com.musicalis.musicalis.dto.atualizacao.AtualizarPatrimonioDto;
import br.com.musicalis.musicalis.dto.cadastro.CadastrarPatrimonioDto;
import br.com.musicalis.musicalis.dto.listagem.ListarPatrimonioDto;
import br.com.musicalis.musicalis.dto.visualizacao.VisualizarPatrimonioDto;
import br.com.musicalis.musicalis.entity.Patrimonio;
import br.com.musicalis.musicalis.service.PatrimonioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patrimonio")
public class PatrimonioController {
@Autowired
    private PatrimonioService patrimonioService;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid CadastrarPatrimonioDto dto){
        this.patrimonioService.salvar(new Patrimonio(dto));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        this.patrimonioService.deletar(id);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarPatrimonioDto dto){
        this.patrimonioService.atualizar(dto);
    }

    @GetMapping("/listar")
    public List<ListarPatrimonioDto> listar(){
        return this.patrimonioService.listar();
    }

    @GetMapping("/visualizar/id/{id}")
    public VisualizarPatrimonioDto visualizar(@PathVariable Long id){
        return this.patrimonioService.visualizar(id);
    }

}
