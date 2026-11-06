package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.EmpleadoDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.EmpleadoNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.EmpleadoEntidadAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado.AsegurarEmpleadoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado.AsegurarPersonaEmpleadoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado.AsegurarPersonaNuevoEmpleadoNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado.AsegurarSedeEmpleadoEsteActivaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado.AsegurarSedeEmpleadoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado.ValidarDatosConsultarEmpleadosPorFiltroRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado.ValidarDatosModificarInformacionEmpleadoExistenteRule;
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
		var empleadoEntidad = EmpleadoEntidadAssembler.obtenerInstancia().convertirAEntidad(datos);
		empleadoEntidad.setId(
				UtilUUID.generarIdUnico(id -> daoFactory.obtenerEmpleadoDao().consultarPorId(id).getId()));
		empleadoEntidad.setEsActivo(true);
		daoFactory.obtenerEmpleadoDao().crear(empleadoEntidad);
	}

	@Override
	public void modificarInformacionEmpleadoExistente(final UUID id, final EmpleadoDominio datos) {
		AsegurarEmpleadoExistaRule.obtenerInstancia().ejecutar(id, daoFactory);
		ValidarDatosModificarInformacionEmpleadoExistenteRule.obtenerInstancia().ejecutar(datos);
		AsegurarSedeEmpleadoExistaRule.obtenerInstancia().ejecutar(datos.getSede().getId(), daoFactory);
		AsegurarSedeEmpleadoEsteActivaRule.obtenerInstancia().ejecutar(datos.getSede().getId(), daoFactory);
		var empleadoEntidad = EmpleadoEntidadAssembler.obtenerInstancia().convertirAEntidad(datos);
		daoFactory.obtenerEmpleadoDao().actualizar(id, empleadoEntidad);
	}

	@Override
	public List<EmpleadoDominio> consultarPorFiltro(final EmpleadoDominio filtro) {
		ValidarDatosConsultarEmpleadosPorFiltroRule.obtenerInstancia().ejecutar(filtro);
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
		AsegurarEmpleadoExistaRule.obtenerInstancia().ejecutar(id, daoFactory);
		var entidad = daoFactory.obtenerEmpleadoDao().consultarPorId(id);
		return EmpleadoEntidadAssembler.obtenerInstancia().convertirADominio(entidad);
	}
}
