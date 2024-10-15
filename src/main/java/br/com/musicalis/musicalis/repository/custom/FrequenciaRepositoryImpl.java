package br.com.musicalis.musicalis.repository.custom;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;
import com.querydsl.jpa.impl.JPAQueryFactory;

import br.com.musicalis.musicalis.dto.listagem.ListarFrequenciasDto;
import br.com.musicalis.musicalis.entity.QAluno;
import br.com.musicalis.musicalis.entity.QFrequencia;
import br.com.musicalis.musicalis.entity.QProfessor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class FrequenciaRepositoryImpl implements FrequenciaRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ListarFrequenciasDto> listarFrequencias(int limit, int offset) {
        QFrequencia frequencia = QFrequencia.frequencia;
        QAluno aluno = QAluno.aluno;
        QProfessor professor = QProfessor.professor;
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        return queryFactory
                .select(Projections.constructor(
                        ListarFrequenciasDto.class,
                        frequencia.id.as("frequenciaId"),
                        frequencia.data,
                        frequencia.presenca,
                        frequencia.grupo,
                        aluno.id.as("alunoId"),
                        aluno.nome.as("alunoNome"),
                        professor.id.as("professorId"),
                        professor.nome.as("professorNome"),
                        frequencia.tipo
                        ))
                .from(frequencia)
                .leftJoin(frequencia.aluno, aluno) 
                .leftJoin(frequencia.professor, professor) 
                .orderBy(frequencia.data.desc())
                .limit(limit)
                .offset(offset)
                .fetch();
    }
}
