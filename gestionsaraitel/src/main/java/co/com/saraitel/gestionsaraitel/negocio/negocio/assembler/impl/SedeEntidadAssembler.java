package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.SedeDominio;
import co.com.saraitel.gestionsaraitel.entidad.SedeEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class SedeEntidadAssembler implements EntidadAssembler<SedeDominio, SedeEntidad> {

	private static final EntidadAssembler<SedeDominio, SedeEntidad> instancia = new SedeEntidadAssembler();

	private SedeEntidadAssembler() {
	}

	public static EntidadAssembler<SedeDominio, SedeEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public SedeEntidad convertirAEntidad(SedeDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				SedeDominio.obtenerValorDefecto());
		return new SedeEntidad(dominioTmp.getId(),
				CiudadEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getCiudad()), dominioTmp.getNombre(),
				dominioTmp.getNit(), dominioTmp.getDireccion(), dominioTmp.getEsActiva());
	}

	@Override
	public SedeDominio convertirADominio(SedeEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new SedeEntidad());
		return new SedeDominio(entidadTmp.getId(),
				CiudadEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getCiudad()), entidadTmp.getNombre(),
				entidadTmp.getNit(), entidadTmp.getDireccion(), entidadTmp.getEsActiva());
	}
}