package br.mairon.restapplication.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "TB_ALUNO")
public class Aluno {

    @Id
    @GeneratedValue
    @Column(name = "ID_ALUNO")
    private Long id;

    @Column(name = "TX_EMAIL_ALUNO")
    private String email;

    @Column(name = "DT_NASCIMENTO")
    private String dataNascimento;

    @Column(name = "NM_ALUNO")
    private String nome;
}
