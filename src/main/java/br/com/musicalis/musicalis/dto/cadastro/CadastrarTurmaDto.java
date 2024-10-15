package br.com.musicalis.musicalis.dto.cadastro;

import java.time.LocalDateTime;


public record CadastrarTurmaDto(
        String nome,
        LocalDateTime dtHora,
        Character grupo) {
}
