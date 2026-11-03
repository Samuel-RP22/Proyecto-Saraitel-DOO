package co.com.saraitel.gestionsaraitel.controlador.impl;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.saraitel.gestionsaraitel.controlador.AbstractRestController;
import co.com.saraitel.gestionsaraitel.controlador.respuesta.RespuestaOk;
import co.com.saraitel.gestionsaraitel.dto.PersonaDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.PersonaFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.impl.PersonaFachadaImpl;

@RestController
@RequestMapping("/api/v1/personas")
public class PersonaControlador extends AbstractRestController {

	private PersonaFachada fachada = new PersonaFachadaImpl();

	@GetMapping
	public ResponseEntity<RespuestaOk<PersonaDTO>> consultarTodos() {
		var personas = fachada.consultarTodos();
		RespuestaOk<PersonaDTO> respuesta = RespuestaOk.crear(personas);
		return ResponseEntity.ok(respuesta);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RespuestaOk<PersonaDTO>> consultarPorId(@PathVariable UUID id) {
		var resultado = fachada.consultarPorId(id);
		RespuestaOk<PersonaDTO> respuesta = RespuestaOk.crear(resultado);
		return ResponseEntity.ok(respuesta);
	}
}
