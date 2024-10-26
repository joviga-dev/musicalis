package br.com.musicalis.musicalis.dto.cadastro;

import java.time.LocalDate;

public record CadastrarProfessorDto(String login, String senha, String nome, String cpf, String rg, String instrumento,
                                    Character grupo, String matricula, LocalDate dtNasc) {
}
