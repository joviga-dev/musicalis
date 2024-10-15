package br.com.musicalis.musicalis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musicalis.musicalis.entity.Turma;
import br.com.musicalis.musicalis.repository.custom.TurmaRepositoryCustom;

public interface TurmaRepository extends JpaRepository<Turma, Long>,TurmaRepositoryCustom {
    List<Turma> findAllByGrupo(Character grupo);
}
