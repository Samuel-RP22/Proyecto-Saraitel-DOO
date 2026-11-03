package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.DevolucionDominio;
import co.com.saraitel.gestionsaraitel.entidad.DevolucionEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class DevolucionEntidadAssembler implements EntidadAssembler<DevolucionDominio, DevolucionEntidad> {

	private static final EntidadAssembler<DevolucionDominio, DevolucionEntidad> instancia = new DevolucionEntidadAssembler();

	private DevolucionEntidadAssembler() {
	}

	public static EntidadAssembler<DevolucionDominio, DevolucionEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public DevolucionEntidad convertirAEntidad(DevolucionDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				DevolucionDominio.obtenerValorDefecto());
		return new DevolucionEntidad(dominioTmp.getId(),
				DetalleCompraEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getDetalleCompra()),
				MotivoEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getMotivo()),
				dominioTmp.getFechaDevolucion(), dominioTmp.getCantidad(), dominioTmp.getMontoDevolucion(),
				dominioTmp.getEstado());
	}

	@Override
	public DevolucionDominio convertirADominio(DevolucionEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new DevolucionEntidad());
		return new DevolucionDominio(entidadTmp.getId(),
				DetalleCompraEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getDetalleCompra()),
				MotivoEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getMotivo()),
				entidadTmp.getFechaDevolucion(), entidadTmp.getCantidad(), entidadTmp.getMontoDevolucion(),
				entidadTmp.getEstado());
	}
}
