package br.com.musicalis.musicalis.dto.visualizacao;

import br.com.musicalis.musicalis.entity.Patrimonio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public record VisualizarPatrimonioDto(
        Long codigo,
        String descricao,
        String instrumento,
        String nomeAlunoResponsavel,
        @JsonIgnore Character grupo
) {
    @JsonProperty("grupoAlunoResponsavel")
    public String grupoAlunoResponsavel() {
        return (grupo != null && grupo.equals('B')) ? "Banda" : "Orquestra";
    }

    public VisualizarPatrimonioDto(Patrimonio patrimonio) {
        this(
                patrimonio.getCodigo(),
                patrimonio.getDescricao(),
                patrimonio.getInstrumento(),
                patrimonio.getAlunoResponsavel().getNome(),
                patrimonio.getAlunoResponsavel().getGrupo()
        );
    }
}
