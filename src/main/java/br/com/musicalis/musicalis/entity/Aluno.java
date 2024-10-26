package br.com.musicalis.musicalis.entity;

import java.time.LocalDate;
import java.util.List;
import br.com.musicalis.musicalis.dto.cadastro.CadastrarAlunoDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "alunos")
@Entity(name = "Aluno")
@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
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

    @ManyToMany(mappedBy = "alunos")
    private List<Turma> turmas;

    @OneToMany(mappedBy = "aluno")
    private List<Avaliacao> avaliacoes;

    @OneToMany(mappedBy = "aluno")
    private List<Frequencia> frequencias;

    @OneToMany
    private List<Patrimonio> patrimonios;

    public Aluno(CadastrarAlunoDto dto) {
        this.cpf = dto.cpf();
        this.dtNasc = dto.dtNasc();
        this.grupo = dto.grupo();
        this.instrumento = dto.instrumento();
        this.matricula = dto.matricula();
        this.nome = dto.nome();
        this.rg = dto.rg();
        this.status = dto.status();
    }
}
