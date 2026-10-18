package co.com.saraitel.gestionsaraitel.controlador.impl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.saraitel.gestionsaraitel.controlador.AbstractRestController;

@RestController
@RequestMapping("/api/v1/paises")
public class PaisControlador extends AbstractRestController {
	
	@GetMapping
	public String consultarTodos() {
		return "Ahora sí mono! Metodo GET exitoso";
	}
	
	@PostMapping
	public String registrarInformacionNuevoPais() {
		return "Ahora sí mono! Metodo POST exitoso";
	}
	
	@PutMapping
	public String modificarInformacionPaisExistente() {
		return "Ahora sí mono! Metodo PUT exitoso";
	}
	
	@DeleteMapping
	public String darBajaInformacionPaisExistente() {
		return "Ahora sí mono! Metodo DELETE exitoso";
	}
}