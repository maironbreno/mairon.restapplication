package br.mairon.restapplication.service;

import br.mairon.restapplication.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AlunoService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Aluno> retornarListaAlunos() {
        List<Aluno> listaAlunos = new ArrayList<Aluno>();

        String sql = "SELECT * FROM TB_ALUNO";

        List<Map<String, Object>> rows = null;

        rows = jdbcTemplate.queryForList(sql);

        for(Map row: rows) {
            Aluno aluno = new Aluno();
            aluno.setId((Long)row.get("ID_ALUNO"));
            aluno.setEmail((String)row.get("TX_EMAIL_ALUNO"));
            aluno.setDataNascimento((String)row.get("DT_NASCIMENTO"));
            aluno.setNome((String)row.get("NM_ALUNO"));
            listaAlunos.add(aluno);
        }

        return listaAlunos;
    }
}
