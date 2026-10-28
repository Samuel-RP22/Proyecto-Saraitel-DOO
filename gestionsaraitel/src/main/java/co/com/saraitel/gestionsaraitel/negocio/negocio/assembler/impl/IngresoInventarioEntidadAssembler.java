package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.IngresoInventarioDominio;
import co.com.saraitel.gestionsaraitel.entidad.IngresoInventarioEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class IngresoInventarioEntidadAssembler
		implements EntidadAssembler<IngresoInventarioDominio, IngresoInventarioEntidad> {

	private static final EntidadAssembler<IngresoInventarioDominio, IngresoInventarioEntidad> instancia = new IngresoInventarioEntidadAssembler();

	private IngresoInventarioEntidadAssembler() {
	}

	public static EntidadAssembler<IngresoInventarioDominio, IngresoInventarioEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public IngresoInventarioEntidad convertirAEntidad(IngresoInventarioDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				IngresoInventarioDominio.obtenerValorDefecto());

		return new IngresoInventarioEntidad(dominioTmp.getId(),
				SedeEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getSede()),
				EstadoInventarioEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getEstado()),
				dominioTmp.getFechaLlegada(), dominioTmp.getTotal());
	}

	@Override
	public IngresoInventarioDominio convertirADominio(IngresoInventarioEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new IngresoInventarioEntidad());

		return new IngresoInventarioDominio(entidadTmp.getId(),
				SedeEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getSede()),
				EstadoInventarioEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getEstado()),
				entidadTmp.getFechaLlegada(), entidadTmp.getTotal());
	}
}