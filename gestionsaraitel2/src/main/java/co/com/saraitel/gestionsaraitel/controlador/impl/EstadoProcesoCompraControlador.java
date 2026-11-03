package co.com.saraitel.gestionsaraitel.controlador.impl;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.saraitel.gestionsaraitel.controlador.AbstractRestController;
import co.com.saraitel.gestionsaraitel.controlador.respuesta.RespuestaOk;
import co.com.saraitel.gestionsaraitel.dto.EstadoProcesoCompraDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.EstadoProcesoCompraFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.impl.EstadoProcesoCompraFachadaImpl;

@RestController
@RequestMapping("/api/v1/estados-proceso-compra")
public class EstadoProcesoCompraControlador extends AbstractRestController {

	private EstadoProcesoCompraFachada fachada = new EstadoProcesoCompraFachadaImpl();

	@GetMapping
	public ResponseEntity<RespuestaOk<EstadoProcesoCompraDTO>> consultarTodos() {
		var estadosProcesoCompra = fachada.consultarTodos();
		RespuestaOk<EstadoProcesoCompraDTO> respuesta = RespuestaOk.crear(estadosProcesoCompra);
		return ResponseEntity.ok(respuesta);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RespuestaOk<EstadoProcesoCompraDTO>> consultarPorId(@PathVariable UUID id) {
		var resultado = fachada.consultarPorId(id);
		RespuestaOk<EstadoProcesoCompraDTO> respuesta = RespuestaOk.crear(resultado);
		return ResponseEntity.ok(respuesta);
	}
}
