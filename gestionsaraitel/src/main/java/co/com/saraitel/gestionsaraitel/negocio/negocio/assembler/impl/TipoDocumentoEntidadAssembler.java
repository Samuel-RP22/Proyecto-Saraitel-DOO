
package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.TipoDocumentoDominio;
import co.com.saraitel.gestionsaraitel.entidad.TipoDocumentoEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class TipoDocumentoEntidadAssembler implements EntidadAssembler<TipoDocumentoDominio, TipoDocumentoEntidad> {

	private static final EntidadAssembler<TipoDocumentoDominio, TipoDocumentoEntidad> instancia = new TipoDocumentoEntidadAssembler();

	private TipoDocumentoEntidadAssembler() {
	}

	public static EntidadAssembler<TipoDocumentoDominio, TipoDocumentoEntidad> getInstance() {
		return instancia;
	}

	@Override
	public TipoDocumentoEntidad convertirAEntidad(TipoDocumentoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				TipoDocumentoDominio.obtenerValorDefecto());
		return new TipoDocumentoEntidad(dominioTmp.getId(), dominioTmp.getTipo());
	}

	@Override
	public TipoDocumentoDominio convertirADominio(TipoDocumentoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new TipoDocumentoEntidad());
		return new TipoDocumentoDominio(entidadTmp.getId(), entidadTmp.getTipo());
	}
}
