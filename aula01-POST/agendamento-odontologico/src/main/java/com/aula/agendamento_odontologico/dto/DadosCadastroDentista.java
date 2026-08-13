package com.aula.agendamento_odontologico.dto;

import com.aula.agendamento_odontologico.enums.Especialidade;

public record DadosCadastroDentista(
        String nome,
        String email,
        String cro,
        Especialidade especialidade,
        Endereco endereco
) {
}
