package com.core.taller2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.core.taller2.dominio.Persona;
import com.core.taller2.repositorio.IPersonaRepositorio;
import com.core.taller2.servicio.PersonaServicio;


@SpringBootTest
public class PersonaTest {

	@Autowired
	PersonaServicio personaServicio;
	
	@Mock
	IPersonaRepositorio personaRepositorioMock;
	
	@Autowired
	IPersonaRepositorio personaRepositorio;

	@Test
	void testServicio() {
		Long id = 1L;
		Persona persona = new Persona(100L, "pruebaNombre", "pruebaApellido", "20");
		
		when(personaRepositorioMock.findById(id)).thenReturn(Optional.of(persona));
		
		Persona result = personaServicio.obtenerPorId(id);
		
		assertThat(result).isNotNull();
	}
	
	@Test
	void testRepositorio() {
		Long id = 1L;
		
		Optional <Persona> result = personaRepositorio.findById(id);
		
		Persona persona = result.get();
		
		assertThat(persona).isNotNull();
		assertThat(persona.getNombre()).isEqualTo("Sebastian");
	}
}
