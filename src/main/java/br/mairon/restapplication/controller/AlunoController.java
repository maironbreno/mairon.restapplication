package br.mairon.restapplication.controller;

import br.mairon.restapplication.model.Aluno;
import br.mairon.restapplication.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/aluno", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @RequestMapping(value = "/lista", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Aluno> retornarAlunos() {
        List<Aluno> listaAlunos;
        listaAlunos = alunoService.retornarListaAlunos();
        return listaAlunos;
    }

}