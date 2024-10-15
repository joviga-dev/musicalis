package br.com.musicalis.musicalis.dto.listagem;

import br.com.musicalis.musicalis.entity.Aluno;

public record ListarAlunoDto(Long id, String matricula, String nome, String instrumento) {
    public ListarAlunoDto(Aluno aluno) {
        this(aluno.getId(), aluno.getMatricula(), aluno.getNome(), aluno.getInstrumento());
    }
}
