
package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.PrefijoDominio;
import co.com.saraitel.gestionsaraitel.entidad.PrefijoEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class PrefijoEntidadAssembler implements EntidadAssembler<PrefijoDominio, PrefijoEntidad> {

	private static final EntidadAssembler<PrefijoDominio, PrefijoEntidad> instancia = new PrefijoEntidadAssembler();

	private PrefijoEntidadAssembler() {
	}

	public static EntidadAssembler<PrefijoDominio, PrefijoEntidad> getInstance() {
		return instancia;
	}

	@Override
	public PrefijoEntidad convertirAEntidad(PrefijoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				PrefijoDominio.obtenerValorDefecto());
		return new PrefijoEntidad(dominioTmp.getId(), dominioTmp.getCodigo());
	}

	@Override
	public PrefijoDominio convertirADominio(PrefijoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new PrefijoEntidad());
		return new PrefijoDominio(entidadTmp.getId(), entidadTmp.getCodigo());
	}
}
