package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.EstadoCompraDominio;
import co.com.saraitel.gestionsaraitel.entidad.EstadoCompraEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class EstadoCompraEntidadAssembler implements EntidadAssembler<EstadoCompraDominio, EstadoCompraEntidad> {

	private static final EntidadAssembler<EstadoCompraDominio, EstadoCompraEntidad> instancia = new EstadoCompraEntidadAssembler();

	private EstadoCompraEntidadAssembler() {
	}

	public static EntidadAssembler<EstadoCompraDominio, EstadoCompraEntidad> getInstance() {
		return instancia;
	}

	@Override
	public EstadoCompraEntidad convertirAEntidad(EstadoCompraDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				EstadoCompraDominio.obtenerValorDefecto());
		return new EstadoCompraEntidad(dominioTmp.getId(), dominioTmp.getCodigo(), dominioTmp.getNombre());
	}

	@Override
	public EstadoCompraDominio convertirADominio(EstadoCompraEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new EstadoCompraEntidad());
		return new EstadoCompraDominio(entidadTmp.getId(), entidadTmp.getCodigo(), entidadTmp.getNombre());
	}
}