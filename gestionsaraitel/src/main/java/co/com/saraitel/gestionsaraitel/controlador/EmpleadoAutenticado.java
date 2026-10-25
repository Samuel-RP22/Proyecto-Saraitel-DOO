package co.com.saraitel.gestionsaraitel.controlador;

import java.util.Optional;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import co.com.saraitel.gestionsaraitel.dto.EmpleadoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.impl.EmpleadoFachadaImpl;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelControladorExcepcion;

public final class EmpleadoAutenticado {

	private EmpleadoAutenticado() {
	}

	public static Optional<EmpleadoDTO> obtener(final OidcUser usuario) {
		if (usuario == null || usuario.getEmail() == null) {
			return Optional.empty();
		}

		var empleado = buscarEmpleadoActivo(usuario.getEmail());

		if (empleado.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.EmpleadoAutenticado.USUARIO_AUTENTICADO_NO_ES_EMPLEADO_ACTIVO;
			throw GestionSaraitelControladorExcepcion.crear(mensajeUsuario);
		}

		return empleado;
	}

	public static Optional<EmpleadoDTO> buscarEmpleadoActivo(final String correo) {
		if (correo == null) {
			return Optional.empty();
		}

		var correoBuscado = correo.trim();

		return new EmpleadoFachadaImpl().consultarTodos().stream()
				.filter(e -> e.getEsActivo() && correoBuscado.equalsIgnoreCase(e.getPersona().getCorreo())).findFirst();
	}
}
