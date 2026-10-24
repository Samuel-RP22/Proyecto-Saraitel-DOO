
package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.MarcaDominio;
import co.com.saraitel.gestionsaraitel.entidad.MarcaEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class MarcaEntidadAssembler implements EntidadAssembler<MarcaDominio, MarcaEntidad> {

	private static final EntidadAssembler<MarcaDominio, MarcaEntidad> instancia = new MarcaEntidadAssembler();

	private MarcaEntidadAssembler() {
	}

	public static EntidadAssembler<MarcaDominio, MarcaEntidad> getInstance() {
		return instancia;
	}

	@Override
	public MarcaEntidad convertirAEntidad(MarcaDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				MarcaDominio.obtenerValorDefecto());
		return new MarcaEntidad(dominioTmp.getId(), dominioTmp.getNombre(), dominioTmp.getEsActivo());
	}

	@Override
	public MarcaDominio convertirADominio(MarcaEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new MarcaEntidad());
		return new MarcaDominio(entidadTmp.getId(), entidadTmp.getNombre(), entidadTmp.getEsActivo());
	}
}
