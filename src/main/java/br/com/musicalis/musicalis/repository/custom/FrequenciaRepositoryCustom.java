package br.com.musicalis.musicalis.repository.custom;

import java.util.List;

import br.com.musicalis.musicalis.dto.listagem.ListarFrequenciasDto;

public interface FrequenciaRepositoryCustom {
    List<ListarFrequenciasDto> listarFrequencias(int limit, int offset);
}
