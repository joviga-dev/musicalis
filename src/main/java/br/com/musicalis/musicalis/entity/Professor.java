package br.com.musicalis.musicalis.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "Professor")
@Table(name = "professores")
@Data
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    private Long id;
    @Column(name = "dt_nasc")
    private LocalDate dtNasc;
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "grupo")
    private Character grupo;
    @Column(name = "instrumento")
    private String instrumento;
    @Column(name = "nome")
    private String nome;
    @Column(name = "rg")
    private String rg;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "status")
    private boolean status;

    @OneToMany(mappedBy = "professor")
    private List<Turma> turmas;
    
    @OneToMany(mappedBy = "professor")
    private List<Diario> diarios;


    
    // @ManyToMany(mappedBy = "aluno")
    // private List<Avaliacao> avaliacoes;

    // @ManyToMany(mappedBy = "aluno")
    // private List<Frequencia> frequencias;
}
