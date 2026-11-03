package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.AplicacionSaldoDominio;
import co.com.saraitel.gestionsaraitel.entidad.AplicacionSaldoEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class AplicacionSaldoEntidadAssembler
		implements EntidadAssembler<AplicacionSaldoDominio, AplicacionSaldoEntidad> {

	private static final EntidadAssembler<AplicacionSaldoDominio, AplicacionSaldoEntidad> instancia = new AplicacionSaldoEntidadAssembler();

	private AplicacionSaldoEntidadAssembler() {
	}

	public static EntidadAssembler<AplicacionSaldoDominio, AplicacionSaldoEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public AplicacionSaldoEntidad convertirAEntidad(AplicacionSaldoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				AplicacionSaldoDominio.obtenerValorDefecto());
		return new AplicacionSaldoEntidad(dominioTmp.getId(),
				SaldoFavorEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getSaldoFavor()),
				PagoEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getPago()),
				dominioTmp.getValorAplicado());
	}

	@Override
	public AplicacionSaldoDominio convertirADominio(AplicacionSaldoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new AplicacionSaldoEntidad());
		return new AplicacionSaldoDominio(entidadTmp.getId(),
				SaldoFavorEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getSaldoFavor()),
				PagoEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getPago()),
				entidadTmp.getValorAplicado());
	}
}
