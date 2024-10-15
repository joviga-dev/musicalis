package br.com.musicalis.musicalis.dto.listagem;

import java.time.LocalDateTime;

import br.com.musicalis.musicalis.entity.Turma;

public record ListarTurmaDto(Long id, LocalDateTime dtHora,
        String nome) {

    public ListarTurmaDto(Turma turma) {
        this(turma.getId(), turma.getDtHora(), turma.getNome());
    }
}
