package br.com.musicalis.musicalis.dto.listagem;

import java.time.LocalDateTime;
import br.com.musicalis.musicalis.entity.Aluno;
import br.com.musicalis.musicalis.entity.Frequencia;
import br.com.musicalis.musicalis.entity.Professor;

public record ListarFrequenciasDto(Long id,LocalDateTime data,
        boolean presenca,
        Character grupo, Long idAluno, String nomeAluno, Long idProfessor, String nomeProfessor, String tipo) {

            public ListarFrequenciasDto(Frequencia frequencia, Aluno aluno, Professor professor) {
                this(frequencia.getId(), frequencia.getData(), frequencia.isPresenca(),frequencia.getGrupo(),aluno.getId(),aluno.getNome(),professor.getId(),professor.getNome(), frequencia.getTipo());
            }
}
