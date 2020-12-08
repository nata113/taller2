package com.core.taller2.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * Clase que administra todas las excepciones 
 * en tiempo de ejecución que se puedan presentar 
 * en el controlador
 *
 */

@ControllerAdvice
public class PersonaExcepcionControlador {

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<String> exception(RuntimeException exception) {
		return new ResponseEntity<>("Ha ocurrido un error en el servicio", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
