package com.aula.agendamento_odontologico.controller;

import com.aula.agendamento_odontologico.dto.DadosCadastroDentista;
import com.aula.agendamento_odontologico.model.Dentista;
import com.aula.agendamento_odontologico.repository.DentistaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/dentista")
@RestController
public class ControllerDentista {

    @Autowired //Deixa a reponsabilidade para o spring instanciar
    private DentistaRepository repository;

    @PostMapping
    public void cadastroDentista(@RequestBody @Valid DadosCadastroDentista dadosDentista) {

        repository.save(new Dentista(dadosDentista));
    }
}
