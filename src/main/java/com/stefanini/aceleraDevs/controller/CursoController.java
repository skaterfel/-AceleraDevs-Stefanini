package com.stefanini.aceleraDevs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.stefanini.aceleraDevs.dto.CursoDTO;
import com.stefanini.aceleraDevs.exception.TurmaNotFoundException;
import com.stefanini.aceleraDevs.mapper.CursoDTOService;
import com.stefanini.aceleraDevs.model.Curso;
import com.stefanini.aceleraDevs.model.Turma;
import com.stefanini.aceleraDevs.repository.CursoRepository;
import com.stefanini.aceleraDevs.service.CursoService;

@RestController
public class CursoController {

    private final CursoService cursoService;
    private final CursoDTOService cursoDTOService;

    @Autowired
    public CursoController(CursoService cursoService, CursoDTOService cursoDTOService) {
        this.cursoService = cursoService;
        this.cursoDTOService = cursoDTOService;
    }

    @Autowired
    private CursoRepository cursoRepository;

    @RequestMapping(path = "/curso")
    public ModelAndView loadHtml() {

        ModelAndView mv = new ModelAndView("curso");
        CursoDTO cursoDTO = new CursoDTO();

        mv.addObject("cursoDTO", cursoDTO);

        return mv;
    }

    @PostMapping(value = "/curso")
    public String saveCurso(CursoDTO curso) throws TurmaNotFoundException {

        Curso newCurso = cursoDTOService.mapCurso(curso);

        cursoService.save(newCurso);

        return "redirect:/curso";
    }

    @GetMapping("/cursos")
    public List<CursoDTO> listar() {
        List<Curso> cursos = cursoRepository.findAll();
        return CursoDTO.converter(cursos);

    }
    @DeleteMapping("/cursos/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id) {
        Optional<Curso> optional = cursoRepository.findById(id);
        if (optional.isPresent()) {
            cursoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
