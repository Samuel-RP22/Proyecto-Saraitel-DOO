package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.ProcesoCompraDominio;
import co.com.saraitel.gestionsaraitel.entidad.ProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ProcesoCompraEntidadAssembler implements EntidadAssembler<ProcesoCompraDominio, ProcesoCompraEntidad> {

	private static final EntidadAssembler<ProcesoCompraDominio, ProcesoCompraEntidad> instancia = new ProcesoCompraEntidadAssembler();

	private ProcesoCompraEntidadAssembler() {
	}

	public static EntidadAssembler<ProcesoCompraDominio, ProcesoCompraEntidad> getInstance() {
		return instancia;
	}

	@Override
	public ProcesoCompraEntidad convertirAEntidad(ProcesoCompraDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				ProcesoCompraDominio.obtenerValorDefecto());
		return new ProcesoCompraEntidad(dominioTmp.getId(),
				ClienteEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getCliente()),
				EmpleadoEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getEmpleado()),
				EstadoProcesoCompraEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getEstado()),
				dominioTmp.getFechaInicio(), dominioTmp.getFechaActualizacion(), dominioTmp.getTotal());
	}

	@Override
	public ProcesoCompraDominio convertirADominio(ProcesoCompraEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new ProcesoCompraEntidad());
		return new ProcesoCompraDominio(entidadTmp.getId(),
				ClienteEntidadAssembler.getInstance().convertirADominio(entidadTmp.getCliente()),
				EmpleadoEntidadAssembler.getInstance().convertirADominio(entidadTmp.getEmpleado()),
				EstadoProcesoCompraEntidadAssembler.getInstance().convertirADominio(entidadTmp.getEstado()),
				entidadTmp.getFechaInicio(), entidadTmp.getFechaActualizacion(), entidadTmp.getTotal());
	}
}
