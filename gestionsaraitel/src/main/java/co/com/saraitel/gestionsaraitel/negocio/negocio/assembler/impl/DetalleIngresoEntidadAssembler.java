package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.DetalleIngresoDominio;
import co.com.saraitel.gestionsaraitel.entidad.DetalleIngresoEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class DetalleIngresoEntidadAssembler implements EntidadAssembler<DetalleIngresoDominio, DetalleIngresoEntidad> {

	private static final EntidadAssembler<DetalleIngresoDominio, DetalleIngresoEntidad> instancia = new DetalleIngresoEntidadAssembler();

	private DetalleIngresoEntidadAssembler() {
	}

	public static EntidadAssembler<DetalleIngresoDominio, DetalleIngresoEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public DetalleIngresoEntidad convertirAEntidad(DetalleIngresoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				DetalleIngresoDominio.obtenerValorDefecto());

		return new DetalleIngresoEntidad(dominioTmp.getId(),
				IngresoInventarioEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getIngresoInventario()),
				ProductoSedeEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getProductoSede()),
				dominioTmp.getCantidad(), dominioTmp.getCostoUnitario(), dominioTmp.getSubtotal());
	}

	@Override
	public DetalleIngresoDominio convertirADominio(DetalleIngresoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new DetalleIngresoEntidad());

		return new DetalleIngresoDominio(entidadTmp.getId(),
				IngresoInventarioEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getIngresoInventario()),
				ProductoSedeEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getProductoSede()),
				entidadTmp.getCantidad(), entidadTmp.getCostoUnitario(), entidadTmp.getSubtotal());
	}
}