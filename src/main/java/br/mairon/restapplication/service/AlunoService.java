package br.mairon.restapplication.service;

import br.mairon.restapplication.Persistence.PersistenceHelper;
import br.mairon.restapplication.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.*;

@Service
public class AlunoService extends PersistenceHelper {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Aluno> retornarListaAlunos() {
        List<Aluno> listaAlunos = new ArrayList<Aluno>();

        String sql = "SELECT * FROM TB_ALUNO";

        List<Map<String, Object>> rows = null;

        rows = jdbcTemplate.queryForList(sql);

        for(Map row: rows) {
            Aluno aluno = new Aluno();
            aluno.setId((Integer) row.get("ID_ALUNO"));
            aluno.setEmail((String)row.get("TX_EMAIL_ALUNO"));
            aluno.setDataNascimento((String)row.get("DT_NASCIMENTO"));
            aluno.setNome((String)row.get("NM_ALUNO"));
            listaAlunos.add(aluno);
        }

        return listaAlunos;
    }

    public void salvarAluno(Aluno aluno) {
        EntityManager entityManager = obterEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(aluno);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
