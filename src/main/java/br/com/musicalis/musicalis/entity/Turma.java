package br.com.musicalis.musicalis.entity;

import java.time.LocalDateTime;
import java.util.List;

import br.com.musicalis.musicalis.dto.cadastro.CadastrarTurmaDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "Turma")
@Table(name = "turmas")
@NoArgsConstructor
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma")
    private Long id;

    @ManyToMany
    @JoinTable(
        name = "turma_aluno", // Nome da tabela de junção
        joinColumns = @JoinColumn(name = "id_turma"), // Nome da coluna que refere a Turma
        inverseJoinColumns = @JoinColumn(name = "id_aluno") // Nome da coluna que refere a Aluno
    )
    private List<Aluno> alunos;

    @ManyToOne
    @JoinColumn(name = "fk_professor")
    private Professor professor;

    @Column(name = "nome")
    private String nome;
    @Column(name = "dt_hora")
    private LocalDateTime dtHora;
    @Column(name = "grupo")
    private Character grupo;

    public Turma(CadastrarTurmaDto dto) {
        this.dtHora = dto.dtHora();
        this.grupo = dto.grupo();
        this.nome = dto.nome();
    }
}
