package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.EmpleadoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PersonaEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;

public class AsegurarPersonaNuevoEmpleadoNoExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarPersonaNuevoEmpleadoNoExistaRule();

	private AsegurarPersonaNuevoEmpleadoNoExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		var idPersona = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var personaFiltro = new PersonaEntidad();
		personaFiltro.setId(idPersona);

		var entidadFiltro = new EmpleadoEntidad();
		entidadFiltro.setPersona(personaFiltro);

		var resultados = daoFactory.obtenerEmpleadoDao().consultarPorFiltro(entidadFiltro);

		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.EmpleadoNegocioImpl.EMPLEADO_YA_EXISTE_CON_LA_MISMA_PERSONA_DE_EMPLEADO_A_CREAR;

			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
