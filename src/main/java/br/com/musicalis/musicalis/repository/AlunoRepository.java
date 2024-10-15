package br.com.musicalis.musicalis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musicalis.musicalis.entity.Aluno;


public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByGrupo(Character grupo);
}