package co.com.saraitel.gestionsaraitel.controlador.impl;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.saraitel.gestionsaraitel.controlador.AbstractRestController;
import co.com.saraitel.gestionsaraitel.controlador.respuesta.RespuestaOk;
import co.com.saraitel.gestionsaraitel.dto.TipoDocumentoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.TipoDocumentoFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.impl.TipoDocumentoFachadaImpl;

@RestController
@RequestMapping("/api/v1/tipos-documento")
public class TipoDocumentoControlador extends AbstractRestController {

	private TipoDocumentoFachada fachada = new TipoDocumentoFachadaImpl();

	@GetMapping
	public ResponseEntity<RespuestaOk<TipoDocumentoDTO>> consultarTodos() {
		var tiposDocumento = fachada.consultarTodos();
		RespuestaOk<TipoDocumentoDTO> respuesta = RespuestaOk.crear(tiposDocumento);
		return ResponseEntity.ok(respuesta);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RespuestaOk<TipoDocumentoDTO>> consultarPorId(@PathVariable UUID id) {
		var resultado = fachada.consultarPorId(id);
		RespuestaOk<TipoDocumentoDTO> respuesta = RespuestaOk.crear(resultado);
		return ResponseEntity.ok(respuesta);
	}
}
