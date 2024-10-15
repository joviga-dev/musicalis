package br.com.musicalis.musicalis.dto.cadastro;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastrarAlunoDto(
                @NotBlank @NotNull String matricula,
                Character grupo,
                Character cargo,
                String instrumento,
                @NotBlank @NotNull String nome,
                String rg,
                String cpf,
                LocalDate dtNasc,
                @NotNull
                boolean status) {
}
