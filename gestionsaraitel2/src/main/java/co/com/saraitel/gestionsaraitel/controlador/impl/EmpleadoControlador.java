package co.com.saraitel.gestionsaraitel.controlador.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.saraitel.gestionsaraitel.controlador.AbstractRestController;
import co.com.saraitel.gestionsaraitel.controlador.EmpleadoAutenticado;
import co.com.saraitel.gestionsaraitel.controlador.respuesta.RespuestaOk;
import co.com.saraitel.gestionsaraitel.dto.EmpleadoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.EmpleadoFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.impl.EmpleadoFachadaImpl;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoControlador extends AbstractRestController {

	private EmpleadoFachada fachada = new EmpleadoFachadaImpl();

	@GetMapping
	public ResponseEntity<RespuestaOk<EmpleadoDTO>> consultarTodos() {
		var empleados = fachada.consultarTodos();
		RespuestaOk<EmpleadoDTO> respuesta = RespuestaOk.crear(empleados);
		return ResponseEntity.ok(respuesta);
	}

	@GetMapping("/actual")
	public ResponseEntity<RespuestaOk<EmpleadoDTO>> consultarEmpleadoActual(@AuthenticationPrincipal OidcUser usuario) {
		var empleados = EmpleadoAutenticado.obtenerUsuario(usuario).map(List::of).orElse(List.of());
		RespuestaOk<EmpleadoDTO> respuesta = RespuestaOk.crear(empleados);
		return ResponseEntity.ok(respuesta);
	}
}
