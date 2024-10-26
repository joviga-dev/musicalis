package br.com.musicalis.musicalis.dto.atualizacao;

import java.time.LocalDate;

public record AtualizarProfessorDto(Long id,String login, String senha, String nome, String cpf, String rg, String instrumento,
                                    Character grupo, String matricula, LocalDate dtNasc) {
}
