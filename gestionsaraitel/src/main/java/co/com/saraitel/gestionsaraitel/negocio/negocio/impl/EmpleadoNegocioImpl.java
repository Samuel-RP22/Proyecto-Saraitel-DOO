package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.EmpleadoDominio;
import co.com.saraitel.gestionsaraitel.entidad.EmpleadoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PersonaEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.EmpleadoNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.EmpleadoEntidadAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado.AsegurarPersonaEmpleadoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado.AsegurarPersonaNuevoEmpleadoNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado.AsegurarSedeEmpleadoEsteActivaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado.AsegurarSedeEmpleadoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado.ValidarDatosRegistrarInformacionNuevoEmpleadoRule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class EmpleadoNegocioImpl implements EmpleadoNegocio {

	private final DAOFactory daoFactory;

	public EmpleadoNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrarInformacionNuevoEmpleado(final EmpleadoDominio datos) {
		ValidarDatosRegistrarInformacionNuevoEmpleadoRule.obtenerInstancia().ejecutar(datos);

		AsegurarSedeEmpleadoExistaRule.obtenerInstancia().ejecutar(datos.getSede().getId(), daoFactory);
		AsegurarSedeEmpleadoEsteActivaRule.obtenerInstancia().ejecutar(datos.getSede().getId(), daoFactory);
		AsegurarPersonaEmpleadoExistaRule.obtenerInstancia().ejecutar(datos.getPersona().getId(), daoFactory);

		AsegurarPersonaNuevoEmpleadoNoExistaRule.obtenerInstancia().ejecutar(datos.getPersona().getId(), daoFactory);

		var empleadoEntidad = EmpleadoEntidadAssembler.getInstance().convertirAEntidad(datos);

		UUID id;
		boolean idExiste;

		do {
			id = UUID.randomUUID();
			var empleadoConMismoId = daoFactory.obtenerEmpleadoDao().consultarPorId(id);
			idExiste = !empleadoConMismoId.getId().equals(UtilUUID.obtenerUUIDDefecto());
		} while (idExiste);

		empleadoEntidad.setId(id);
		empleadoEntidad.setEsActivo(true);

		daoFactory.obtenerEmpleadoDao().crear(empleadoEntidad);
	}

	@Override
	public void modificarInformacionEmpleadoExistente(final UUID id, final EmpleadoDominio datos) {

		var empleadoExistente = daoFactory.obtenerEmpleadoDao().consultarPorId(id);

		if (empleadoExistente.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
			return;
		}

		var datosActualizados = new EmpleadoDominio(id, datos.getSede(), datos.getPersona(), datos.getEsActiva());

		ValidarDatosRegistrarInformacionNuevoEmpleadoRule.obtenerInstancia().ejecutar(datosActualizados);

		AsegurarSedeEmpleadoExistaRule.obtenerInstancia().ejecutar(datosActualizados.getSede().getId(), daoFactory);
		AsegurarSedeEmpleadoEsteActivaRule.obtenerInstancia().ejecutar(datosActualizados.getSede().getId(), daoFactory);
		AsegurarPersonaEmpleadoExistaRule.obtenerInstancia().ejecutar(datosActualizados.getPersona().getId(),
				daoFactory);

		var personaFiltro = new PersonaEntidad();
		personaFiltro.setId(datosActualizados.getPersona().getId());

		var entidadFiltro = new EmpleadoEntidad();
		entidadFiltro.setPersona(personaFiltro);

		var empleadosConMismaPersona = daoFactory.obtenerEmpleadoDao().consultarPorFiltro(entidadFiltro);

		boolean personaDuplicada = empleadosConMismaPersona.stream().anyMatch(empleado -> !empleado.getId().equals(id));

		if (personaDuplicada) {
			AsegurarPersonaNuevoEmpleadoNoExistaRule.obtenerInstancia().ejecutar(datosActualizados.getPersona().getId(),
					daoFactory);
		}

		var entidadActualizada = EmpleadoEntidadAssembler.getInstance().convertirAEntidad(datosActualizados);

		daoFactory.obtenerEmpleadoDao().actualizar(id, entidadActualizada);
	}

	@Override
	public void darBajaInformacionEmpleadoExistente(final UUID id) {
		var empleadoExistente = daoFactory.obtenerEmpleadoDao().consultarPorId(id);

		if (empleadoExistente.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
			return;
		}

		empleadoExistente.setEsActivo(false);

		daoFactory.obtenerEmpleadoDao().actualizar(id, empleadoExistente);
	}

	@Override
	public List<EmpleadoDominio> consultarPorFiltro(final EmpleadoDominio filtro) {
		var entidadFiltro = EmpleadoEntidadAssembler.getInstance().convertirAEntidad(filtro);

		return daoFactory.obtenerEmpleadoDao().consultarPorFiltro(entidadFiltro).stream()
				.map(EmpleadoEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public List<EmpleadoDominio> consultarTodos() {
		return daoFactory.obtenerEmpleadoDao().consultarTodos().stream()
				.map(EmpleadoEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public EmpleadoDominio consultarPorid(final UUID id) {
		var entidad = daoFactory.obtenerEmpleadoDao().consultarPorId(id);

		if (entidad.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
			return EmpleadoDominio.obtenerValorDefecto();
		}

		return EmpleadoEntidadAssembler.getInstance().convertirADominio(entidad);
	}
}