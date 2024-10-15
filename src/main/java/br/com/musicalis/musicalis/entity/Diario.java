package br.com.musicalis.musicalis.entity;

import java.time.LocalDateTime;

import br.com.musicalis.musicalis.dto.cadastro.CadastrarDiarioDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Diario")
@Table(name = "diarios")
@Data
@NoArgsConstructor
public class Diario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diario")
    private Long id;
    private LocalDateTime data;
    private boolean presenca;
    private Character grupo;
    @OneToOne
    @JoinColumn(name = "fk_aluno")
    private Aluno aluno;
    @OneToOne
    @JoinColumn(name = "fk_professor")
    private Professor professor;
    private String obs;

    public Diario(CadastrarDiarioDto dto) { 
        this.data = dto.data();
        this.presenca = dto.presenca();
        this.grupo = dto.grupo();
        this.obs = dto.obs();
    }

}
