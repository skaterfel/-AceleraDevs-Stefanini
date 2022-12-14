package com.stefanini.aceleraDevs.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.stefanini.aceleraDevs.model.Disciplina;

public class DisciplinaDTO {

    private String nome;

    private String codigo;

    private String conteudoProgramatico;

    private Integer numeroCreditos = 0;

    private Integer totalHoras;

    private Long turma;

    private Long curso;

    public DisciplinaDTO() {
    }

    public DisciplinaDTO(String nome, String codigo, String conteudoProgramatico, Integer numeroCreditos,
            Integer totalHoras, Long turma, Long curso) {
        this.nome = nome;
        this.codigo = codigo;
        this.conteudoProgramatico = conteudoProgramatico;
        this.numeroCreditos = numeroCreditos;
        this.totalHoras = totalHoras;
        this.turma = turma;
        this.curso = curso;
    }

    public DisciplinaDTO(Disciplina disciplina) {
        this.nome = disciplina.getNome();
        this.codigo = disciplina.getCodigo();
        this.conteudoProgramatico = disciplina.getConteudoProgramatico();
        this.numeroCreditos = disciplina.getNumeroCreditos();
        this.totalHoras = disciplina.getTotalHoras();
        this.turma = disciplina.getTurma().getId();
        this.curso = disciplina.getCurso().getId();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getConteudoProgramatico() {
        return conteudoProgramatico;
    }

    public void setConteudoProgramatico(String conteudoProgramatico) {
        this.conteudoProgramatico = conteudoProgramatico;
    }

    public Integer getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(Integer numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public Integer getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(Integer totalHoras) {
        this.totalHoras = totalHoras;
    }

    public Long getTurma() {
        return turma;
    }

    public void setTurma(Long turma) {
        this.turma = turma;
    }

    public Long getCurso() {
        return curso;
    }

    public void setCurso(Long curso) {
        this.curso = curso;
    }

    public static List<DisciplinaDTO> converter(List<Disciplina> disciplinas) {
        return disciplinas.stream().map(DisciplinaDTO::new).collect(Collectors.toList());
    }
}
