package br.com.musicalis.musicalis.dto.cadastro;

import java.time.LocalDateTime;


public record CadastrarDiarioDto(LocalDateTime data, boolean presenca, Character grupo, Long idAluno,
Long idProfessor, String obs) {

}
