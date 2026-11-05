package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoNEntidad;
import co.com.saraitel.gestionsaraitel.entidad.EmpleadoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PersonaEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;

public class AsegurarPersonaNoEsteSiendoUtilizadaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarPersonaNoEsteSiendoUtilizadaRule();

	private AsegurarPersonaNoEsteSiendoUtilizadaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 2);

		var idPersona = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var personaFiltro = new PersonaEntidad();
		personaFiltro.setId(idPersona);

		var filtroClienteNatural = new ClienteRegistradoNEntidad();
		filtroClienteNatural.setPersona(personaFiltro);

		if (!daoFactory.obtenerClienteRegistradoNDao().consultarPorFiltro(filtroClienteNatural).isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.PersonaNegocioImpl.PERSONA_ESTA_SIENDO_UTILIZADA_POR_CLIENTE_NATURAL;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}

		var filtroEmpleado = new EmpleadoEntidad();
		filtroEmpleado.setPersona(personaFiltro);

		if (!daoFactory.obtenerEmpleadoDao().consultarPorFiltro(filtroEmpleado).isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.PersonaNegocioImpl.PERSONA_ESTA_SIENDO_UTILIZADA_POR_EMPLEADO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
