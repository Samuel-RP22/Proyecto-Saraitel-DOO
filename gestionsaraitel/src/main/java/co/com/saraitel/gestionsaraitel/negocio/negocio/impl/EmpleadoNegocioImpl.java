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

		validarPoliticasSedeYPersona(datos);

		AsegurarPersonaNuevoEmpleadoNoExistaRule.obtenerInstancia().ejecutar(datos.getPersona().getId(), daoFactory);

		var empleadoEntidad = EmpleadoEntidadAssembler.obtenerInstancia().convertirAEntidad(datos);

		empleadoEntidad.setId(UtilUUID.generarIdUnico(id -> daoFactory.obtenerEmpleadoDao().consultarPorId(id).getId()));
		empleadoEntidad.setEsActivo(true);

		daoFactory.obtenerEmpleadoDao().crear(empleadoEntidad);
	}

	@Override
	public void modificarInformacionEmpleadoExistente(final UUID id, final EmpleadoDominio datos) {

		var empleadoExistente = daoFactory.obtenerEmpleadoDao().consultarPorId(id);

		if (UtilUUID.esValorDefecto(empleadoExistente.getId())) {
			return;
		}

		var datosActualizados = new EmpleadoDominio(id, datos.getSede(), datos.getPersona(), datos.getEsActivo());

		ValidarDatosRegistrarInformacionNuevoEmpleadoRule.obtenerInstancia().ejecutar(datosActualizados);

		validarPoliticasSedeYPersona(datosActualizados);

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

		var entidadActualizada = EmpleadoEntidadAssembler.obtenerInstancia().convertirAEntidad(datosActualizados);

		daoFactory.obtenerEmpleadoDao().actualizar(id, entidadActualizada);
	}

	@Override
	public void darBajaInformacionEmpleadoExistente(final UUID id) {
		var empleadoExistente = daoFactory.obtenerEmpleadoDao().consultarPorId(id);

		if (UtilUUID.esValorDefecto(empleadoExistente.getId())) {
			return;
		}

		empleadoExistente.setEsActivo(false);

		daoFactory.obtenerEmpleadoDao().actualizar(id, empleadoExistente);
	}

	@Override
	public List<EmpleadoDominio> consultarPorFiltro(final EmpleadoDominio filtro) {
		var entidadFiltro = EmpleadoEntidadAssembler.obtenerInstancia().convertirAEntidad(filtro);

		return daoFactory.obtenerEmpleadoDao().consultarPorFiltro(entidadFiltro).stream()
				.map(EmpleadoEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public List<EmpleadoDominio> consultarTodos() {
		return daoFactory.obtenerEmpleadoDao().consultarTodos().stream()
				.map(EmpleadoEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public EmpleadoDominio consultarPorId(final UUID id) {
		var entidad = daoFactory.obtenerEmpleadoDao().consultarPorId(id);

		if (UtilUUID.esValorDefecto(entidad.getId())) {
			return EmpleadoDominio.obtenerValorDefecto();
		}

		return EmpleadoEntidadAssembler.obtenerInstancia().convertirADominio(entidad);
	}

	private void validarPoliticasSedeYPersona(final EmpleadoDominio datos) {
		var idSede = datos.getSede().getId();
		var idPersona = datos.getPersona().getId();

		AsegurarSedeEmpleadoExistaRule.obtenerInstancia().ejecutar(idSede, daoFactory);
		AsegurarSedeEmpleadoEsteActivaRule.obtenerInstancia().ejecutar(idSede, daoFactory);
		AsegurarPersonaEmpleadoExistaRule.obtenerInstancia().ejecutar(idPersona, daoFactory);
	}
}