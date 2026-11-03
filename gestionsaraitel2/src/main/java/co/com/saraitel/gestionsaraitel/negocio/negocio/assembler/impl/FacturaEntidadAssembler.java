package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.FacturaDominio;
import co.com.saraitel.gestionsaraitel.entidad.FacturaEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class FacturaEntidadAssembler implements EntidadAssembler<FacturaDominio, FacturaEntidad> {

	private static final EntidadAssembler<FacturaDominio, FacturaEntidad> instancia = new FacturaEntidadAssembler();

	private FacturaEntidadAssembler() {
	}

	public static EntidadAssembler<FacturaDominio, FacturaEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public FacturaEntidad convertirAEntidad(FacturaDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				FacturaDominio.obtenerValorDefecto());
		return new FacturaEntidad(dominioTmp.getId(),
				CompraEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getCompra()),
				dominioTmp.getFechaEmision());
	}

	@Override
	public FacturaDominio convertirADominio(FacturaEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new FacturaEntidad());
		return new FacturaDominio(entidadTmp.getId(),
				CompraEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getCompra()),
				entidadTmp.getFechaEmision());
	}
}
