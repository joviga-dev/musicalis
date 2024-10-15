package br.com.musicalis.musicalis.dto.atualizacao;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizarAlunoDto(@NotNull Long id,@NotBlank @NotNull String matricula,
                Character grupo,
                Character cargo,
                String instrumento,
                @NotBlank @NotNull String nome,
                String rg,
                String cpf,
                LocalDate dtNasc) {

}
