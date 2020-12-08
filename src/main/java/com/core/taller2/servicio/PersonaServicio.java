package com.core.taller2.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.taller2.dominio.Persona;
import com.core.taller2.repositorio.IPersonaRepositorio;

@Service
public class PersonaServicio {

	@Autowired
	IPersonaRepositorio personaRepositorio;

	public Persona obtenerPorId(Long id) {
		Persona persona = new Persona();
		Optional<Persona> resul = personaRepositorio.findById(id);
		persona = resul.get();

		return persona;
	}

	public List<Persona> obtenerTodos() {
		List<Persona> personas = new ArrayList<>();
		Iterable<Persona> iterable = personaRepositorio.findAll();
	    iterable.forEach(personas::add);
		
		return personas;
	}

	public void agregar(Persona persona) {
		personaRepositorio.save(persona);
	}
	
	public boolean eliminar(Long id) {
		Optional<Persona> resul = personaRepositorio.findById(id);

		if(!resul.isEmpty()) {
			personaRepositorio.delete(resul.get());
			return true;
		} else {
			return false;
		}
		
	}
}
