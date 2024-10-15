package br.com.musicalis.musicalis.repository.custom;


import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class TurmaRepositoryImpl implements TurmaRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

}