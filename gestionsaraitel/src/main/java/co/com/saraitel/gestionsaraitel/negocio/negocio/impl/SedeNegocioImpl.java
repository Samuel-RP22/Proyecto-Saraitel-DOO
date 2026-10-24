package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.SedeDominio;
import co.com.saraitel.gestionsaraitel.entidad.SedeEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.SedeNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.SedeEntidadAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.sede.AsegurarDireccionNuevaSedeNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.sede.AsegurarNitNuevaSedeNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.sede.AsegurarNombreNuevaSedeNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.sede.ValidarDatosRegistrarInformacionNuevaSedeRule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class SedeNegocioImpl implements SedeNegocio {

	private final DAOFactory daoFactory;

	public SedeNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrarInformacionNuevaSede(final SedeDominio datos) {
		ValidarDatosRegistrarInformacionNuevaSedeRule.obtenerInstancia().ejecutar(datos);

		AsegurarNombreNuevaSedeNoExistaRule.obtenerInstancia().ejecutar(datos.getNombre(), daoFactory);
		AsegurarNitNuevaSedeNoExistaRule.obtenerInstancia().ejecutar(datos.getNit(), daoFactory);
		AsegurarDireccionNuevaSedeNoExistaRule.obtenerInstancia().ejecutar(datos.getDireccion(), daoFactory);

		var sedeEntidad = SedeEntidadAssembler.getInstance().convertirAEntidad(datos);

		sedeEntidad.setId(generarIdSedeUnico());

		daoFactory.obtenerSedeDao().crear(sedeEntidad);
	}

	private UUID generarIdSedeUnico() {
		UUID id;
		boolean existe;

		do {
			id = UUID.randomUUID();
			var sedeExistente = daoFactory.obtenerSedeDao().consultarPorId(id);
			existe = !sedeExistente.getId().equals(UtilUUID.obtenerUUIDDefecto());
		} while (existe);

		return id;
	}

	@Override
	public void modificarInformacionSedeExistente(final UUID id, final SedeDominio datos) {

		var sedeExistente = daoFactory.obtenerSedeDao().consultarPorId(id);

		if (sedeExistente.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
			return;
		}

		var datosActualizados = new SedeDominio(id, datos.getCiudad(), datos.getNombre(), datos.getNit(),
				datos.getDireccion(), datos.getEsActiva());

		ValidarDatosRegistrarInformacionNuevaSedeRule.obtenerInstancia().ejecutar(datosActualizados);

		var entidadFiltroNombre = new SedeEntidad();
		entidadFiltroNombre.setNombre(datosActualizados.getNombre());

		var sedesConMismoNombre = daoFactory.obtenerSedeDao().consultarPorFiltro(entidadFiltroNombre);

		boolean nombreDuplicado = sedesConMismoNombre.stream().anyMatch(sede -> !sede.getId().equals(id));

		if (nombreDuplicado) {
			AsegurarNombreNuevaSedeNoExistaRule.obtenerInstancia().ejecutar(datosActualizados.getNombre(), daoFactory);
		}

		var entidadFiltroNit = new SedeEntidad();
		entidadFiltroNit.setNit(datosActualizados.getNit());

		var sedesConMismoNit = daoFactory.obtenerSedeDao().consultarPorFiltro(entidadFiltroNit);

		boolean nitDuplicado = sedesConMismoNit.stream().anyMatch(sede -> !sede.getId().equals(id));

		if (nitDuplicado) {
			AsegurarNitNuevaSedeNoExistaRule.obtenerInstancia().ejecutar(datosActualizados.getNit(), daoFactory);
		}

		var entidadFiltroDireccion = new SedeEntidad();
		entidadFiltroDireccion.setDireccion(datosActualizados.getDireccion());

		var sedesConMismaDireccion = daoFactory.obtenerSedeDao().consultarPorFiltro(entidadFiltroDireccion);

		boolean direccionDuplicada = sedesConMismaDireccion.stream().anyMatch(sede -> !sede.getId().equals(id));

		if (direccionDuplicada) {
			AsegurarDireccionNuevaSedeNoExistaRule.obtenerInstancia().ejecutar(datosActualizados.getDireccion(),
					daoFactory);
		}

		var entidadActualizada = SedeEntidadAssembler.getInstance().convertirAEntidad(datosActualizados);

		daoFactory.obtenerSedeDao().actualizar(id, entidadActualizada);
	}

	@Override
	public List<SedeDominio> consultarPorFiltro(final SedeDominio filtro) {
		var entidadFiltro = SedeEntidadAssembler.getInstance().convertirAEntidad(filtro);

		return daoFactory.obtenerSedeDao().consultarPorFiltro(entidadFiltro).stream()
				.map(SedeEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public List<SedeDominio> consultarTodos() {
		return daoFactory.obtenerSedeDao().consultarTodos().stream()
				.map(SedeEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public SedeDominio consultarPorid(final UUID id) {
		var entidad = daoFactory.obtenerSedeDao().consultarPorId(id);

		if (entidad.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
			return SedeDominio.obtenerValorDefecto();
		}

		return SedeEntidadAssembler.getInstance().convertirADominio(entidad);
	}
}