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
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;

@RestController
@RequestMapping("/api/v1/procesos-compra")
public class ProcesoCompraControlador extends AbstractRestController {

	private ProcesoCompraFachada fachada = new ProcesoCompraFachadaImpl();

	@PostMapping
	public ResponseEntity<RespuestaOk<String>> registrarInformacionNuevoProcesoCompra(
			@RequestBody ProcesoCompraDTO datos, @AuthenticationPrincipal OidcUser usuario) {
		EmpleadoAutenticado.obtenerUsuario(usuario).ifPresent(datos::setEmpleado);
		fachada.registrarInformacionNuevoProcesoCompra(datos);
		var mensajeRespuesta = CatalogoMensajes.ProcesoCompraControlador.USUARIO_EXITO_PROCESO_COMPRA_REGISTRADO;
		RespuestaOk<String> respuesta = RespuestaOk.crear(mensajeRespuesta);
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
