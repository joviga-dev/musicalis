package br.com.musicalis.musicalis.dto.listagem;

import java.time.LocalDateTime;

import br.com.musicalis.musicalis.entity.Diario;

public record ListarDiarioDto(LocalDateTime data, String nomeAluno) {
    public ListarDiarioDto(Diario diario) {
        this(diario.getData(), diario.getAluno().getNome());
    }
}
