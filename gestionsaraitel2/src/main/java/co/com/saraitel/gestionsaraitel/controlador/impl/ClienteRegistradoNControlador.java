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
import co.com.saraitel.gestionsaraitel.dto.ClienteRegistradoNDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.ClienteRegistradoNFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.impl.ClienteRegistradoNFachadaImpl;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;

@RestController
@RequestMapping("/api/v1/clientes-naturales")
public class ClienteRegistradoNControlador extends AbstractRestController {

	private ClienteRegistradoNFachada fachada = new ClienteRegistradoNFachadaImpl();

	@PostMapping
	public ResponseEntity<RespuestaOk<String>> registrarInformacionNuevoClienteNatural(
			@RequestBody ClienteRegistradoNDTO datos) {
		fachada.registrarInformacionNuevoClienteNatural(datos);
		var mensajeRespuesta = CatalogoMensajes.ClienteRegistradoNControlador.USUARIO_EXITO_CLIENTE_NATURAL_REGISTRADO;
		RespuestaOk<String> respuesta = RespuestaOk.crear(mensajeRespuesta);
		return ResponseEntity.ok(respuesta);
	}

	@GetMapping
	public ResponseEntity<RespuestaOk<ClienteRegistradoNDTO>> consultarTodos() {
		var clientesNaturales = fachada.consultarTodos();
		RespuestaOk<ClienteRegistradoNDTO> respuesta = RespuestaOk.crear(clientesNaturales);
		return ResponseEntity.ok(respuesta);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RespuestaOk<ClienteRegistradoNDTO>> consultarPorId(@PathVariable UUID id) {
		var resultado = fachada.consultarPorId(id);
		RespuestaOk<ClienteRegistradoNDTO> respuesta = RespuestaOk.crear(resultado);
		return ResponseEntity.ok(respuesta);
	}
}
