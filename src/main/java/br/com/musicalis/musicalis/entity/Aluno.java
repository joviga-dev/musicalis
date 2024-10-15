package br.com.musicalis.musicalis.entity;

import java.time.LocalDate;
import java.util.List;
import br.com.musicalis.musicalis.dto.cadastro.CadastrarAlunoDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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

    @ManyToMany(mappedBy = "aluno")
    private List<Avaliacao> avaliacoes;

    @ManyToMany(mappedBy = "aluno")
    private List<Frequencia> frequencias;

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
