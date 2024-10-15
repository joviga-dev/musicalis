package br.com.musicalis.musicalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musicalis.musicalis.entity.Frequencia;
import br.com.musicalis.musicalis.repository.custom.FrequenciaRepositoryCustom;

public interface FrequenciaRepository extends JpaRepository<Frequencia, Long>,FrequenciaRepositoryCustom {

}
