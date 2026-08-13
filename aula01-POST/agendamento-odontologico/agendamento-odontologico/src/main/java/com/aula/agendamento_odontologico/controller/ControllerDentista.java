package com.aula.agendamento_odontologico.controller;

import com.aula.agendamento_odontologico.dto.DadosCadastroDentista;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/dentista")
@RestController
public class ControllerDentista {

    @PostMapping
    public void cadastroDentista(@RequestBody DadosCadastroDentista dadosDentista) {
        System.out.println(dadosDentista);
    }
}
