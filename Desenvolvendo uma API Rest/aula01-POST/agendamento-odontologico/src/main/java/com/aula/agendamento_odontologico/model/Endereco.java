package com.aula.agendamento_odontologico.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Embeddable
public class Endereco {
    private String logradouro;
    private String bairro;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
    private String cep;


    public Endereco(com.aula.agendamento_odontologico.dto.Endereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.cep = endereco.cep();
    }
}
