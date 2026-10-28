package co.com.saraitel.gestionsaraitel.controlador;

import java.util.Optional;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import co.com.saraitel.gestionsaraitel.dto.EmpleadoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.impl.EmpleadoFachadaImpl;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelControladorExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public final class EmpleadoAutenticado {

	private EmpleadoAutenticado() {
	}

	public static boolean esEmpleadoActivo(final OidcUser usuario) {
		return !UtilObjeto.esNulo(usuario) && buscarEmpleadoActivo(usuario.getEmail()).isPresent();
	}

	public static Optional<EmpleadoDTO> obtenerUsuario(final OidcUser usuario) {
		if (UtilObjeto.esNulo(usuario) || UtilTexto.esVacia(usuario.getEmail())) {
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
		if (UtilTexto.esVacia(correo)) {
			return Optional.empty();
		}
		var filtro = new EmpleadoDTO();
		filtro.getPersona().setCorreo(correo);
		return new EmpleadoFachadaImpl().consultarPorFiltro(filtro).stream().filter(EmpleadoDTO::getEsActivo)
				.findFirst();
	}
}
