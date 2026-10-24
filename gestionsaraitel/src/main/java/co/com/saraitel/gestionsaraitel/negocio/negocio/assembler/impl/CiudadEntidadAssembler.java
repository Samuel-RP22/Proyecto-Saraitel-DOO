package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.CiudadDominio;
import co.com.saraitel.gestionsaraitel.entidad.CiudadEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class CiudadEntidadAssembler implements EntidadAssembler<CiudadDominio, CiudadEntidad> {

	private static final EntidadAssembler<CiudadDominio, CiudadEntidad> instancia = new CiudadEntidadAssembler();

	private CiudadEntidadAssembler() {
	}

	public static EntidadAssembler<CiudadDominio, CiudadEntidad> getInstance() {
		return instancia;
	}

	@Override
	public CiudadEntidad convertirAEntidad(CiudadDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				CiudadDominio.obtenerValorDefecto());
		return new CiudadEntidad(dominioTmp.getId(), dominioTmp.getNombre(),
				DepartamentoEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getDepartamento()));
	}

	@Override
	public CiudadDominio convertirADominio(CiudadEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new CiudadEntidad());
		return new CiudadDominio(entidadTmp.getId(), entidadTmp.getNombre(),
				DepartamentoEntidadAssembler.getInstance().convertirADominio(entidadTmp.getDepartamento()));
	}
}