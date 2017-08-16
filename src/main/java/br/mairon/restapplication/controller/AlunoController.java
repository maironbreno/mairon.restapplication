package br.mairon.restapplication.controller;

import br.mairon.restapplication.model.Aluno;
import br.mairon.restapplication.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @RequestMapping(value = "/salvar-aluno", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody HttpStatus salvarAluno(@RequestParam("email") String email, @RequestParam("dataNascimento") String dataNascimento,
                                                @RequestParam("nome") String nome) {

        try {
            Aluno aluno = new Aluno();
            aluno.setNome(nome);
            aluno.setDataNascimento(dataNascimento);
            aluno.setEmail(email);

            alunoService.salvarAluno(aluno);
        } catch (Exception exception) {
            System.out.println("Erro ao inserir informações do aluno na base de dados: " + exception.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return HttpStatus.OK;
    }
}