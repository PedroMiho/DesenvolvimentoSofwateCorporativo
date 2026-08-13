package com.aula.agendamento_odontologico.model;

import com.aula.agendamento_odontologico.enums.Especialidade;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "dentista")
@Entity(name = "Dentista")
@AllArgsConstructor
@NoArgsConstructor
@Getter
//Compara id entre objeto e tabela
@EqualsAndHashCode(of = "id")
public class Dentista {
    //Idenfica o id como primary key
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cro;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;



}
