package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.SedeDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.SedeNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.SedeEntidadAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.sede.AsegurarDireccionNuevaSedeNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.sede.AsegurarDireccionSedeNoExistaEnOtraSedeRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.sede.AsegurarNitNuevaSedeNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.sede.AsegurarNitSedeNoExistaEnOtraSedeRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.sede.AsegurarNombreNuevaSedeNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.sede.AsegurarNombreSedeNoExistaEnOtraSedeRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.sede.AsegurarSedeExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.sede.ValidarDatosConsultarSedesPorFiltroRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.sede.ValidarDatosModificarInformacionSedeExistenteRule;
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
		var sedeEntidad = SedeEntidadAssembler.obtenerInstancia().convertirAEntidad(datos);
		sedeEntidad.setId(UtilUUID.generarIdUnico(id -> daoFactory.obtenerSedeDao().consultarPorId(id).getId()));
		daoFactory.obtenerSedeDao().crear(sedeEntidad);
	}

	@Override
	public void modificarInformacionSedeExistente(final UUID id, final SedeDominio datos) {
		AsegurarSedeExistaRule.obtenerInstancia().ejecutar(id, daoFactory);
		ValidarDatosModificarInformacionSedeExistenteRule.obtenerInstancia().ejecutar(datos);
		AsegurarNombreSedeNoExistaEnOtraSedeRule.obtenerInstancia().ejecutar(id, datos.getNombre(), daoFactory);
		AsegurarNitSedeNoExistaEnOtraSedeRule.obtenerInstancia().ejecutar(id, datos.getNit(), daoFactory);
		AsegurarDireccionSedeNoExistaEnOtraSedeRule.obtenerInstancia().ejecutar(id, datos.getDireccion(), daoFactory);
		var sedeEntidad = SedeEntidadAssembler.obtenerInstancia().convertirAEntidad(datos);
		daoFactory.obtenerSedeDao().actualizar(id, sedeEntidad);
	}

	@Override
	public List<SedeDominio> consultarPorFiltro(final SedeDominio filtro) {
		ValidarDatosConsultarSedesPorFiltroRule.obtenerInstancia().ejecutar(filtro);
		var entidadFiltro = SedeEntidadAssembler.obtenerInstancia().convertirAEntidad(filtro);
		return daoFactory.obtenerSedeDao().consultarPorFiltro(entidadFiltro).stream()
				.map(SedeEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public List<SedeDominio> consultarTodos() {
		return daoFactory.obtenerSedeDao().consultarTodos().stream()
				.map(SedeEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public SedeDominio consultarPorId(final UUID id) {
		AsegurarSedeExistaRule.obtenerInstancia().ejecutar(id, daoFactory);
		var entidad = daoFactory.obtenerSedeDao().consultarPorId(id);
		return SedeEntidadAssembler.obtenerInstancia().convertirADominio(entidad);
	}
}
