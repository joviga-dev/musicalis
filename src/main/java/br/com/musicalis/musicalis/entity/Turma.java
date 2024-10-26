package br.com.musicalis.musicalis.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import br.com.musicalis.musicalis.dto.cadastro.CadastrarTurmaDto;
import jakarta.persistence.*;
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

    @ManyToMany(mappedBy = "turmas")
    private Collection<Aluno> aluno;

    public Collection<Aluno> getAluno() {
        return aluno;
    }

    public void setAluno(Collection<Aluno> aluno) {
        this.aluno = aluno;
    }
}
