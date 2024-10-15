package br.com.musicalis.musicalis.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "Avaliacao")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_aluno")
    private Aluno aluno;
    // private List<Professor> professores;
    private LocalDateTime dtAvaliacao;
    private BigDecimal media;
    private BigDecimal notaMaterial;
    private BigDecimal notaPresenca;
    private BigDecimal notaEstudos;
    private Character grupo;
}
