package br.com.musicalis.musicalis.entity;

import br.com.musicalis.musicalis.dto.cadastro.CadastrarPatrimonioDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Patrimonio")
@Table(name = "patrimonios")
@Data
@NoArgsConstructor
public class Patrimonio {
    @Id
    private Long codigo;
    private String instrumento;
    private String descricao;
    @ManyToOne
    @JoinColumn(name="fk_aluno")
    private Aluno alunoResponsavel;

    public Patrimonio(CadastrarPatrimonioDto dto){
        this.codigo = dto.codigo();
        this.instrumento = dto.instrumento();
        this.descricao = dto.descricao();
    }
}
