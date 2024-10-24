package br.com.musicalis.musicalis.dto.atualizacao;
import java.time.LocalDateTime;

public record AtualizarFrequenciaDto(Long id, LocalDateTime data,
        boolean presenca,
        Character grupo, Long idAluno, Long idProfessor, String tipo) {

}
