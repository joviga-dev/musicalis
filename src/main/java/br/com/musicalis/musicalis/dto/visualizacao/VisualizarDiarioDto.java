package br.com.musicalis.musicalis.dto.visualizacao;

import java.time.LocalDateTime;

import br.com.musicalis.musicalis.entity.Diario;

public record VisualizarDiarioDto(LocalDateTime data, boolean presenca, Character grupo, String nomeAluno, String instrumentoAluno,
String nomeProfessor, String obs) {
    public VisualizarDiarioDto(Diario diario) {
        this(diario.getData(), diario.isPresenca(), diario.getGrupo(), diario.getAluno().getNome(),
                diario.getAluno().getInstrumento(), diario.getProfessor().getNome(), diario.getObs());
    }
}
