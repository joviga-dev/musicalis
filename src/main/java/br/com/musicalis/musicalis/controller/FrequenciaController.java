package br.com.musicalis.musicalis.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicalis.musicalis.dto.cadastro.CadastrarFrequenciaDto;
import br.com.musicalis.musicalis.dto.listagem.ListarFrequenciasDto;
import br.com.musicalis.musicalis.entity.Frequencia;
import br.com.musicalis.musicalis.service.FrequenciaService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/frequencia")
public class FrequenciaController {
    @Autowired
    private FrequenciaService frequenciaService;

    @PostMapping
    @Transactional
    public void cadastrarFrequencia(@RequestBody CadastrarFrequenciaDto dto) {
        frequenciaService.cadastrarFrequencia(dto);
    }

    @GetMapping("/limit/{limit}/offset/{offset}")
    public List<ListarFrequenciasDto> listarFrequencias(@PathVariable int limit, @PathVariable int offset) {
        return frequenciaService.listarFrequencias(limit,offset);
    }
}