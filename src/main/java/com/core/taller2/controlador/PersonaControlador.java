package com.core.taller2.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.core.taller2.dominio.Persona;
import com.core.taller2.servicio.PersonaServicio;


@RestController
@RequestMapping("/persona")
public class PersonaControlador {

	@Autowired
	PersonaServicio personaServicio;

	@GetMapping("/listar")
	public List<Persona> findAll() {
//		throw new NullPointerException();
		return personaServicio.obtenerTodos();
	}

	@GetMapping("/buscar/{id}")
	public Persona buscarPersona(@PathVariable Long id) {
		return personaServicio.obtenerPorId(id);
	}

	@PostMapping("/agregar/{id}/{nombre}/{apellido}/{edad}")
	public ResponseEntity<String> agregar(@PathVariable Long id, @PathVariable String nombre, @PathVariable String apellido, @PathVariable String edad) {
		Persona persona = new Persona(id, nombre, apellido, edad);
		
		personaServicio.agregar(persona);
		
		return new ResponseEntity<String>("Persona agregada con éxito", HttpStatus.OK);
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminar(@PathVariable Long id) {
		
		if(personaServicio.eliminar(id)) {
			return new ResponseEntity<String>("Persona eliminada con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No existe una persona con ese ID", HttpStatus.NOT_FOUND);
		}
	}
}
