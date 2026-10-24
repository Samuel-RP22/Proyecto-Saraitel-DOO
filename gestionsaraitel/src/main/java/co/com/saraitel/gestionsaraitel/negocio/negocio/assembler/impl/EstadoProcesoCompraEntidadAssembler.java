
package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.EstadoProcesoCompraDominio;
import co.com.saraitel.gestionsaraitel.entidad.EstadoProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class EstadoProcesoCompraEntidadAssembler
		implements EntidadAssembler<EstadoProcesoCompraDominio, EstadoProcesoCompraEntidad> {

	private static final EntidadAssembler<EstadoProcesoCompraDominio, EstadoProcesoCompraEntidad> 
	instancia = new EstadoProcesoCompraEntidadAssembler();

	private EstadoProcesoCompraEntidadAssembler() {
	}

	public static EntidadAssembler<EstadoProcesoCompraDominio, EstadoProcesoCompraEntidad> getInstance() {
		return instancia;
	}

	@Override
	public EstadoProcesoCompraEntidad convertirAEntidad(EstadoProcesoCompraDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				EstadoProcesoCompraDominio.obtenerValorDefecto());
		return new EstadoProcesoCompraEntidad(dominioTmp.getId(), dominioTmp.getCodigo(), dominioTmp.getNombre());
	}

	@Override
	public EstadoProcesoCompraDominio convertirADominio(EstadoProcesoCompraEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new EstadoProcesoCompraEntidad());
		return new EstadoProcesoCompraDominio(entidadTmp.getId(), entidadTmp.getCodigo(), entidadTmp.getNombre());
	}
}
