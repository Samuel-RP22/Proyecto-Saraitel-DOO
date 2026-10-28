package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.ProcesoCompraDominio;
import co.com.saraitel.gestionsaraitel.entidad.ProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ProcesoCompraEntidadAssembler implements EntidadAssembler<ProcesoCompraDominio, ProcesoCompraEntidad> {

	private static final EntidadAssembler<ProcesoCompraDominio, ProcesoCompraEntidad> instancia = new ProcesoCompraEntidadAssembler();

	private ProcesoCompraEntidadAssembler() {
	}

	public static EntidadAssembler<ProcesoCompraDominio, ProcesoCompraEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public ProcesoCompraEntidad convertirAEntidad(ProcesoCompraDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				ProcesoCompraDominio.obtenerValorDefecto());
		return new ProcesoCompraEntidad(dominioTmp.getId(),
				ClienteEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getCliente()),
				EmpleadoEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getEmpleado()),
				EstadoProcesoCompraEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getEstado()),
				dominioTmp.getFechaInicio(), dominioTmp.getFechaActualizacion(), dominioTmp.getTotal());
	}

	@Override
	public ProcesoCompraDominio convertirADominio(ProcesoCompraEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new ProcesoCompraEntidad());
		return new ProcesoCompraDominio(entidadTmp.getId(),
				ClienteEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getCliente()),
				EmpleadoEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getEmpleado()),
				EstadoProcesoCompraEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getEstado()),
				entidadTmp.getFechaInicio(), entidadTmp.getFechaActualizacion(), entidadTmp.getTotal());
	}
}
