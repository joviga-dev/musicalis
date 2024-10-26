package br.com.musicalis.musicalis.dto.listagem;


import br.com.musicalis.musicalis.entity.Professor;

public record ListarProfessorDto(String nome, String instrumento) {

    public ListarProfessorDto(Professor professor){
        this(professor.getNome(), professor.getInstrumento());
    }
}
