package com.aula.agendamento_odontologico.dto;

public record Endereco(
        String logradouro,
        String bairro,
        String cep,
        String cidade,
        String uf,
        String numero,
        String complemento
        ) {
}
