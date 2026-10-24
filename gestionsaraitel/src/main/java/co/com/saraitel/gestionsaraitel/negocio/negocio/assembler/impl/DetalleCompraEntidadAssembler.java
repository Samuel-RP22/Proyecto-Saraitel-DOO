package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.DetalleCompraDominio;
import co.com.saraitel.gestionsaraitel.entidad.DetalleCompraEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class DetalleCompraEntidadAssembler implements EntidadAssembler<DetalleCompraDominio, DetalleCompraEntidad> {

	private static final EntidadAssembler<DetalleCompraDominio, DetalleCompraEntidad> instancia = new DetalleCompraEntidadAssembler();

	private DetalleCompraEntidadAssembler() {
	}

	public static EntidadAssembler<DetalleCompraDominio, DetalleCompraEntidad> getInstance() {
		return instancia;
	}

	@Override
	public DetalleCompraEntidad convertirAEntidad(DetalleCompraDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				DetalleCompraDominio.obtenerValorDefecto());

		return new DetalleCompraEntidad(dominioTmp.getId(),
				ProcesoCompraEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getProcesoCompra()),
				ProductoSedeEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getProductoSede()),
				dominioTmp.getCantidad(), dominioTmp.getPrecioUnitario(), dominioTmp.getSubtotal());
	}

	@Override
	public DetalleCompraDominio convertirADominio(DetalleCompraEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new DetalleCompraEntidad());

		return new DetalleCompraDominio(entidadTmp.getId(),
				ProcesoCompraEntidadAssembler.getInstance().convertirADominio(entidadTmp.getProcesoCompra()),
				ProductoSedeEntidadAssembler.getInstance().convertirADominio(entidadTmp.getProductoSede()),
				entidadTmp.getCantidad(), entidadTmp.getPrecioUnitario(), entidadTmp.getSubtotal());
	}
}