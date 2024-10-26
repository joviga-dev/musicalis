package br.com.musicalis.musicalis.dto.listagem;

import br.com.musicalis.musicalis.entity.Patrimonio;

public record ListarPatrimonioDto(Long codigo, String descricao, String instrumento, String nomeAlunoResponsavel) {
    public ListarPatrimonioDto(Patrimonio patrimonio) {
        this(patrimonio.getCodigo(), patrimonio.getDescricao(), patrimonio.getInstrumento(), patrimonio.getAlunoResponsavel().getNome());
    }
}
