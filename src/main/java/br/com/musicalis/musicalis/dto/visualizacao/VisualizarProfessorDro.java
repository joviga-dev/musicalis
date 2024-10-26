package br.com.musicalis.musicalis.dto.visualizacao;

import br.com.musicalis.musicalis.entity.Professor;

import java.time.LocalDate;

public record VisualizarProfessorDro(String nome, String cpf, String rg, String instrumento,
                                     Character grupo, String matricula, LocalDate dtNasc) {
    public VisualizarProfessorDro(Professor professor) {
        this(professor.getNome(), professor.getCpf(), professor.getRg(), professor.getInstrumento(), professor.getGrupo(), professor.getMatricula(), professor.getDtNasc()
        );
    }
}
