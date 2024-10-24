package br.com.musicalis.musicalis.entity;

import java.time.LocalDateTime;

import br.com.musicalis.musicalis.dto.cadastro.CadastrarFrequenciaDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "Frequencia")
@Table(name = "frequencias")
public class Frequencia {
    @Column(name = "data")
    private LocalDateTime data;
    @Column(name = "presenca")
    private boolean presenca;
    @Column(name = "grupo")
    private Character grupo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_frequencia")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_aluno")
    private Aluno aluno;
    @ManyToOne
    @JoinColumn(name = "fk_professor")
    private Professor professor;
    @Column(name = "tipo")
    private String tipo;

    public Frequencia(CadastrarFrequenciaDto dto) {
        this.data = dto.data();
        this.presenca = dto.presenca();
        this.grupo = dto.grupo();
        this.tipo = dto.tipo();
    }
}
