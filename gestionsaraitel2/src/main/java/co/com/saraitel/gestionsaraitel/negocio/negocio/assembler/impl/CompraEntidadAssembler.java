package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.CompraDominio;
import co.com.saraitel.gestionsaraitel.entidad.CompraEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class CompraEntidadAssembler implements EntidadAssembler<CompraDominio, CompraEntidad> {

	private static final EntidadAssembler<CompraDominio, CompraEntidad> instancia = new CompraEntidadAssembler();

	private CompraEntidadAssembler() {
	}

	public static EntidadAssembler<CompraDominio, CompraEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public CompraEntidad convertirAEntidad(CompraDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				CompraDominio.obtenerValorDefecto());
		return new CompraEntidad(dominioTmp.getId(),
				ProcesoCompraEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getProcesoCompra()),
				EstadoCompraEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getEstado()),
				dominioTmp.getFechaCompra());
	}

	@Override
	public CompraDominio convertirADominio(CompraEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new CompraEntidad());
		return new CompraDominio(entidadTmp.getId(),
				ProcesoCompraEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getProcesoCompra()),
				EstadoCompraEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getEstado()),
				entidadTmp.getFechaCompra());
	}
}
