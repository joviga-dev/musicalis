package br.com.musicalis.musicalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musicalis.musicalis.entity.Diario;

public interface DiarioRepository extends JpaRepository<Diario, Long> {

}
