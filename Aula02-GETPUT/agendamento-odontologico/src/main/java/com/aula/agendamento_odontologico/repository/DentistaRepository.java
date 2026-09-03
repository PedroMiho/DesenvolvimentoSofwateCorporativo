package com.aula.agendamento_odontologico.repository;

import com.aula.agendamento_odontologico.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistaRepository extends JpaRepository<Dentista, Long> {
}
