package com.stefanini.aceleraDevs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.stefanini.aceleraDevs.dto.TurmaDTO;
import com.stefanini.aceleraDevs.exception.CursoNotFoundException;
import com.stefanini.aceleraDevs.exception.TurmaNotFoundException;
import com.stefanini.aceleraDevs.mapper.TurmaDTOService;
import com.stefanini.aceleraDevs.model.Turma;
import com.stefanini.aceleraDevs.repository.TurmaRepository;
import com.stefanini.aceleraDevs.service.TurmaService;

@RestController
public class TurmaController {

    private final TurmaService turmaService;
    private final TurmaDTOService turmaDTOService;

    @Autowired
    public TurmaController(TurmaService turmaService, TurmaDTOService turmaDTOService) {
        this.turmaService = turmaService;
        this.turmaDTOService = turmaDTOService;
    }

    @Autowired
    private TurmaRepository turmaRepository;

    @RequestMapping(path = "/turma")
    public ModelAndView loadHtml() {

        ModelAndView mv = new ModelAndView("turma");
        TurmaDTO turmaDTO = new TurmaDTO();

        mv.addObject("turmaDTO", turmaDTO);

        return mv;
    }

    @PostMapping(value = "/turma")
    public String saveTurma(TurmaDTO turma) throws TurmaNotFoundException, CursoNotFoundException {

        Turma newTurma = turmaDTOService.mapTurma(turma);

        turmaService.save(newTurma);

        return "redirect:/turma";
    }

    @GetMapping("/turmas")
    public List<TurmaDTO> listar() {
        List<Turma> turmas = turmaRepository.findAll();
        return TurmaDTO.converter(turmas);

    }

}
