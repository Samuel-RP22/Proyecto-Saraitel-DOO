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

// ...../api/v1/clientes-juridicos
// ...../api/v1/clientes-juridicos/{id}

@RestController
@RequestMapping("/api/v1/clientes-juridicos")
public class ClienteJuridicoControlador extends AbstractRestController {

	private ClienteRegistradoJFachada fachada = new ClienteRegistradoJFachadaImpl();

	@PostMapping
	public ResponseEntity<RespuestaOk<String>> registrarInformacionNuevoClienteJuridico(@RequestBody ClienteRegistradoJDTO datos) {
		fachada.registrarInformacionNuevoClienteJuridico(datos);
		RespuestaOk<String> respuesta = RespuestaOk.crear("Se ha registrado la información del nuevo cliente jurídico de forma exitosa");
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
