package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.PagoDominio;
import co.com.saraitel.gestionsaraitel.entidad.PagoEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class PagoEntidadAssembler implements EntidadAssembler<PagoDominio, PagoEntidad> {

	private static final EntidadAssembler<PagoDominio, PagoEntidad> instancia = new PagoEntidadAssembler();

	private PagoEntidadAssembler() {
	}

	public static EntidadAssembler<PagoDominio, PagoEntidad> getInstance() {
		return instancia;
	}

	@Override
	public PagoEntidad convertirAEntidad(PagoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				PagoDominio.obtenerValorDefecto());
		return new PagoEntidad(dominioTmp.getId(),
				CompraEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getCompra()),
				dominioTmp.getMontoPagado(), dominioTmp.getFechaPago());
	}

	@Override
	public PagoDominio convertirADominio(PagoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new PagoEntidad());
		return new PagoDominio(entidadTmp.getId(),
				CompraEntidadAssembler.getInstance().convertirADominio(entidadTmp.getCompra()),
				entidadTmp.getMontoPagado(), entidadTmp.getFechaPago());
	}
}
