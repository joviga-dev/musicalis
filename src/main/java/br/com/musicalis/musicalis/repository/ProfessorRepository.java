package br.com.musicalis.musicalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.musicalis.musicalis.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
