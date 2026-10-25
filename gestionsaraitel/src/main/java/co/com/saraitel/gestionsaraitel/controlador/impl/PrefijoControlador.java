package co.com.saraitel.gestionsaraitel.controlador.impl;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.saraitel.gestionsaraitel.controlador.AbstractRestController;
import co.com.saraitel.gestionsaraitel.controlador.respuesta.RespuestaOk;
import co.com.saraitel.gestionsaraitel.dto.PrefijoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.PrefijoFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.impl.PrefijoFachadaImpl;

// ...../api/v1/prefijos
// ...../api/v1/prefijos/{id}

@RestController
@RequestMapping("/api/v1/prefijos")
public class PrefijoControlador extends AbstractRestController {

	private PrefijoFachada fachada = new PrefijoFachadaImpl();

	@GetMapping
	public ResponseEntity<RespuestaOk<PrefijoDTO>> consultarTodos() {
		var prefijos = fachada.consultarTodos();
		RespuestaOk<PrefijoDTO> respuesta = RespuestaOk.crear(prefijos);
		return ResponseEntity.ok(respuesta);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RespuestaOk<PrefijoDTO>> consultarPorId(@PathVariable UUID id) {
		var resultado = fachada.consultarPorId(id);
		RespuestaOk<PrefijoDTO> respuesta = RespuestaOk.crear(resultado);
		return ResponseEntity.ok(respuesta);
	}
}
