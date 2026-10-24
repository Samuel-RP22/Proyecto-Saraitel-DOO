package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.MetodoPagoDominio;
import co.com.saraitel.gestionsaraitel.entidad.MetodoPagoEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class MetodoPagoEntidadAssembler implements EntidadAssembler<MetodoPagoDominio, MetodoPagoEntidad> {

	private static final EntidadAssembler<MetodoPagoDominio, MetodoPagoEntidad> instancia = new MetodoPagoEntidadAssembler();

	private MetodoPagoEntidadAssembler() {
	}

	public static EntidadAssembler<MetodoPagoDominio, MetodoPagoEntidad> getInstance() {
		return instancia;
	}

	@Override
	public MetodoPagoEntidad convertirAEntidad(MetodoPagoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				MetodoPagoDominio.obtenerValorDefecto());
		return new MetodoPagoEntidad(dominioTmp.getId(), dominioTmp.getNombre(), dominioTmp.getEsActivo());
	}

	@Override
	public MetodoPagoDominio convertirADominio(MetodoPagoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new MetodoPagoEntidad());
		return new MetodoPagoDominio(entidadTmp.getId(), entidadTmp.getNombre(), entidadTmp.getEsActivo());
	}
}
