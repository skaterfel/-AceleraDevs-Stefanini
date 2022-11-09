package com.stefanini.aceleraDevs.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.stefanini.aceleraDevs.model.Curso;

public class CursoDTO {
    private String name;

    private Integer totalGrade;

    public CursoDTO() {
    }

    public CursoDTO(String name, Integer totalGrade) {
        this.name = name;
        this.totalGrade = totalGrade;
    }

    public CursoDTO(Curso curso) {
        this.name = curso.getName();
        this.totalGrade = curso.getTotalGrade();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(Integer totalGrade) {
        this.totalGrade = totalGrade;
    }

    public static List<CursoDTO> converter(List<Curso> cursos) {
        return cursos.stream().map(CursoDTO::new).collect(Collectors.toList());
    }
}
