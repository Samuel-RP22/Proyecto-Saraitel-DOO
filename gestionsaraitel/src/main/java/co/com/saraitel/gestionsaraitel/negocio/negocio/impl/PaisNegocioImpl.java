
package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.PaisDominio;
import co.com.saraitel.gestionsaraitel.entidad.PaisEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.PaisNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.PaisEntidadAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.pais.AsegurarNombreNuevoPaisNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.pais.ValidarDatosRegistrarInformacionNuevoPaisRule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PaisNegocioImpl implements PaisNegocio {

	private final DAOFactory daoFactory;

	public PaisNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrarInformacionNuevoPais(final PaisDominio datos) {
		ValidarDatosRegistrarInformacionNuevoPaisRule.obtenerInstancia().ejecutar(datos);

		AsegurarNombreNuevoPaisNoExistaRule.obtenerInstancia().ejecutar(datos.getNombre(), daoFactory);

		var paisEntidad = PaisEntidadAssembler.getInstance().convertirAEntidad(datos);

		paisEntidad.setId(generarIdPaisUnico());

		daoFactory.obtenerPaisDao().crear(paisEntidad);
	}

	private UUID generarIdPaisUnico() {
		UUID id;

		do {
			id = UUID.randomUUID();
		} while (!daoFactory.obtenerPaisDao().consultarPorId(id).getId()
				.equals(UtilUUID.obtenerUUIDDefecto()) == false);

		return id;
	}

	@Override
	public void modificarInformacionPaisExistente(final UUID id, final PaisDominio datos) {

		var paisExistente = daoFactory.obtenerPaisDao().consultarPorId(id);

		if (paisExistente.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
			return;
		}

		var datosActualizados = new PaisDominio(id, datos.getNombre());

		ValidarDatosRegistrarInformacionNuevoPaisRule.obtenerInstancia().ejecutar(datosActualizados);

		var entidadFiltro = new PaisEntidad();
		entidadFiltro.setNombre(datosActualizados.getNombre());

		var paisesConMismoNombre = daoFactory.obtenerPaisDao().consultarPorFiltro(entidadFiltro);

		boolean nombreDuplicado = paisesConMismoNombre.stream().anyMatch(pais -> !pais.getId().equals(id));

		if (nombreDuplicado) {
			AsegurarNombreNuevoPaisNoExistaRule.obtenerInstancia().ejecutar(datosActualizados.getNombre(), daoFactory);
		}

		var entidadActualizada = PaisEntidadAssembler.getInstance().convertirAEntidad(datosActualizados);

		daoFactory.obtenerPaisDao().actualizar(id, entidadActualizada);
	}

	@Override
	public void darBajaInformacionPaisExistente(final UUID id) {
		var paisExistente = daoFactory.obtenerPaisDao().consultarPorId(id);

		if (paisExistente.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
			return;
		}

		daoFactory.obtenerPaisDao().eliminar(id);
	}

	@Override
	public List<PaisDominio> consultarPorFiltro(final PaisDominio filtro) {
		var entidadFiltro = PaisEntidadAssembler.getInstance().convertirAEntidad(filtro);

		return daoFactory.obtenerPaisDao().consultarPorFiltro(entidadFiltro).stream()
				.map(PaisEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public List<PaisDominio> consultarTodos() {
		return daoFactory.obtenerPaisDao().consultarTodos().stream()
				.map(PaisEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public PaisDominio consultarPorid(final UUID id) {
		var entidad = daoFactory.obtenerPaisDao().consultarPorId(id);

		if (entidad.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
			return PaisDominio.obtenerValorDefecto();
		}

		return PaisEntidadAssembler.getInstance().convertirADominio(entidad);
	}
}
