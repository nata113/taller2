package com.core.taller2.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.core.taller2.dominio.Persona;

@Repository
public interface IPersonaRepositorio extends CrudRepository<Persona, Long> {

}
