package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.EmpleadoDominio;
import co.com.saraitel.gestionsaraitel.entidad.EmpleadoEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.EmpleadoNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.EmpleadoEntidadAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado.AsegurarDireccionNuevoEmpleadoNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado.AsegurarNitNuevoEmpleadoNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado.AsegurarNombreNuevoEmpleadoNoExistaRule;
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

		AsegurarNombreNuevoEmpleadoNoExistaRule.obtenerInstancia().ejecutar(datos.getNombre(), daoFactory);
		AsegurarNitNuevoEmpleadoNoExistaRule.obtenerInstancia().ejecutar(datos.getNit(), daoFactory);
		AsegurarDireccionNuevoEmpleadoNoExistaRule.obtenerInstancia().ejecutar(datos.getDireccion(), daoFactory);

		var empleadoEntidad = EmpleadoEntidadAssembler.getInstance().convertirAEntidad(datos);

		empleadoEntidad.setId(generarIdEmpleadoUnico());

		daoFactory.obtenerEmpleadoDao().crear(empleadoEntidad);
	}

	private UUID generarIdEmpleadoUnico() {
		UUID id;
		boolean existe;

		do {
			id = UUID.randomUUID();
			var empleadoExistente = daoFactory.obtenerEmpleadoDao().consultarPorId(id);
			existe = !empleadoExistente.getId().equals(UtilUUID.obtenerUUIDDefecto());
		} while (existe);

		return id;
	}

	@Override
	public void modificarInformacionEmpleadoExistente(final UUID id, final EmpleadoDominio datos) {

		var empleadoExistente = daoFactory.obtenerEmpleadoDao().consultarPorId(id);

		if (empleadoExistente.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
			return;
		}

		var datosActualizados = new EmpleadoDominio(id, datos.getPersona(), datos.getSede(), datos.getCargo());

		ValidarDatosRegistrarInformacionNuevoEmpleadoRule.obtenerInstancia().ejecutar(datosActualizados);

		var entidadActualizada = EmpleadoEntidadAssembler.getInstance().convertirAEntidad(datosActualizados);

		daoFactory.obtenerEmpleadoDao().actualizar(id, entidadActualizada);
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