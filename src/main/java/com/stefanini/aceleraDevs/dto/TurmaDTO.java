package com.stefanini.aceleraDevs.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.stefanini.aceleraDevs.model.Turma;

public class TurmaDTO {

    private String nome;

    public TurmaDTO() {
    }

    public TurmaDTO(String nome) {
        this.nome = nome;
    }

    public TurmaDTO(Turma turma) {
        this.nome = turma.getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static List<TurmaDTO> converter(List<Turma> turmas) {
        return turmas.stream().map(TurmaDTO::new).collect(Collectors.toList());
    }
}
