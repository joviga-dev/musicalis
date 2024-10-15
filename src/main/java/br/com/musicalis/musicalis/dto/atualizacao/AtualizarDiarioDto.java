package br.com.musicalis.musicalis.dto.atualizacao;

import java.time.LocalDateTime;


public record AtualizarDiarioDto(Long id,LocalDateTime data, boolean presenca,Long idAluno,
String obs) {

}
