package br.com.musicalis.musicalis.dto.atualizacao;

import java.time.LocalDateTime;

public record AtualizarTurmaDto(Long id,String nome,
LocalDateTime dtHora) {

}
