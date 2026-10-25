package co.com.saraitel.gestionsaraitel.controlador.impl;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.saraitel.gestionsaraitel.controlador.AbstractRestController;
import co.com.saraitel.gestionsaraitel.controlador.EmpleadoAutenticado;
import co.com.saraitel.gestionsaraitel.controlador.respuesta.RespuestaOk;
import co.com.saraitel.gestionsaraitel.dto.ProcesoCompraDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.ProcesoCompraFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.impl.ProcesoCompraFachadaImpl;

// ...../api/v1/procesos-compra?id=valor
// ...../api/v1/procesos-compra?cliente.id=valor&empleado.id=valor&estado.id=valor
// ...../api/v1/procesos-compra

@RestController
@RequestMapping("/api/v1/procesos-compra")
public class ProcesoCompraControlador extends AbstractRestController {

	private ProcesoCompraFachada fachada = new ProcesoCompraFachadaImpl();

	@GetMapping("/login")
	public String hacerLogin(@AuthenticationPrincipal OidcUser datosUsuario) {
		return "Hola Usuario %s. Te has autenticado con el correo %s. Su token es %s".formatted(datosUsuario.getFullName(),
				datosUsuario.getEmail(), datosUsuario.getIdToken().getTokenValue());
	}

	@GetMapping("/dummy")
	public ProcesoCompraDTO obtenerDummy() {
		return new ProcesoCompraDTO();
	}

	/**
	 * Solo se reciben el cliente y, si no hay sesión, el empleado. El total, las fechas y el estado inicial
	 * los asigna el negocio. Si hay un usuario autenticado, el empleado es siempre el de la sesión.
	 */
	@PostMapping
	public ResponseEntity<RespuestaOk<String>> registrarInformacionNuevoProcesoCompra(
			@RequestBody ProcesoCompraDTO procesoCompra, @AuthenticationPrincipal OidcUser usuario) {
		EmpleadoAutenticado.obtener(usuario).ifPresent(procesoCompra::setEmpleado);

		fachada.registrarInformacionNuevoProcesoCompra(procesoCompra);
		RespuestaOk<String> respuesta = RespuestaOk
				.crear("Se ha registrado la información del nuevo proceso de compra de forma exitosa");
		return ResponseEntity.ok(respuesta);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RespuestaOk<ProcesoCompraDTO>> consultarPorId(@PathVariable UUID id) {
		var procesoCompra = fachada.consultarPorId(id);
		RespuestaOk<ProcesoCompraDTO> respuesta = RespuestaOk.crear(procesoCompra);
		return ResponseEntity.ok(respuesta);
	}

	@GetMapping
	public ResponseEntity<RespuestaOk<ProcesoCompraDTO>> consultarPorFiltro(ProcesoCompraDTO filtro) {
		var procesosCompra = fachada.consultarPorFiltro(filtro);
		RespuestaOk<ProcesoCompraDTO> respuesta = RespuestaOk.crear(procesosCompra);
		return ResponseEntity.ok(respuesta);
	}
}
