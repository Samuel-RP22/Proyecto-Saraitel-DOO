package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.SaldoFavorDominio;
import co.com.saraitel.gestionsaraitel.entidad.SaldoFavorEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class SaldoFavorEntidadAssembler implements EntidadAssembler<SaldoFavorDominio, SaldoFavorEntidad> {

	private static final EntidadAssembler<SaldoFavorDominio, SaldoFavorEntidad> instancia = new SaldoFavorEntidadAssembler();

	private SaldoFavorEntidadAssembler() {
	}

	public static EntidadAssembler<SaldoFavorDominio, SaldoFavorEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public SaldoFavorEntidad convertirAEntidad(SaldoFavorDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				SaldoFavorDominio.obtenerValorDefecto());
		return new SaldoFavorEntidad(dominioTmp.getId(),
				DevolucionEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getDevolucion()),
				EstadoSaldoFavorEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getEstado()),
				dominioTmp.getMontoUsado());
	}

	@Override
	public SaldoFavorDominio convertirADominio(SaldoFavorEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new SaldoFavorEntidad());
		return new SaldoFavorDominio(entidadTmp.getId(),
				DevolucionEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getDevolucion()),
				EstadoSaldoFavorEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getEstado()),
				entidadTmp.getMontoUsado());
	}
}
