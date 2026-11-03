package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.EstadoInventarioDominio;
import co.com.saraitel.gestionsaraitel.entidad.EstadoInventarioEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class EstadoInventarioEntidadAssembler
		implements EntidadAssembler<EstadoInventarioDominio, EstadoInventarioEntidad> {

	private static final EntidadAssembler<EstadoInventarioDominio, EstadoInventarioEntidad> instancia = new EstadoInventarioEntidadAssembler();

	private EstadoInventarioEntidadAssembler() {
	}

	public static EntidadAssembler<EstadoInventarioDominio, EstadoInventarioEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public EstadoInventarioEntidad convertirAEntidad(EstadoInventarioDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				EstadoInventarioDominio.obtenerValorDefecto());
		return new EstadoInventarioEntidad(dominioTmp.getId(), dominioTmp.getCodigo(), dominioTmp.getNombre());
	}

	@Override
	public EstadoInventarioDominio convertirADominio(EstadoInventarioEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new EstadoInventarioEntidad());
		return new EstadoInventarioDominio(entidadTmp.getId(), entidadTmp.getCodigo(), entidadTmp.getNombre());
	}
}