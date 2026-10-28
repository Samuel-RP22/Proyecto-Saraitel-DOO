package co.com.saraitel.gestionsaraitel.controlador.impl;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.saraitel.gestionsaraitel.controlador.AbstractRestController;
import co.com.saraitel.gestionsaraitel.controlador.respuesta.RespuestaOk;
import co.com.saraitel.gestionsaraitel.dto.ClienteRegistradoJDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.ClienteRegistradoJFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.impl.ClienteRegistradoJFachadaImpl;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;

@RestController
@RequestMapping("/api/v1/clientes-juridicos")
public class ClienteRegistradoJControlador extends AbstractRestController {

	private ClienteRegistradoJFachada fachada = new ClienteRegistradoJFachadaImpl();

	@PostMapping
	public ResponseEntity<RespuestaOk<String>> registrarInformacionNuevoClienteJuridico(
			@RequestBody ClienteRegistradoJDTO datos) {
		fachada.registrarInformacionNuevoClienteJuridico(datos);
		var mensajeRespuesta = CatalogoMensajes.ClienteRegistradoJControlador.USUARIO_EXITO_CLIENTE_JURIDICO_REGISTRADO;
		RespuestaOk<String> respuesta = RespuestaOk.crear(mensajeRespuesta);
		return ResponseEntity.ok(respuesta);
	}

	@GetMapping
	public ResponseEntity<RespuestaOk<ClienteRegistradoJDTO>> consultarTodos() {
		var clientesJuridicos = fachada.consultarTodos();
		RespuestaOk<ClienteRegistradoJDTO> respuesta = RespuestaOk.crear(clientesJuridicos);
		return ResponseEntity.ok(respuesta);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RespuestaOk<ClienteRegistradoJDTO>> consultarPorId(@PathVariable UUID id) {
		var resultado = fachada.consultarPorId(id);
		RespuestaOk<ClienteRegistradoJDTO> respuesta = RespuestaOk.crear(resultado);
		return ResponseEntity.ok(respuesta);
	}
}
