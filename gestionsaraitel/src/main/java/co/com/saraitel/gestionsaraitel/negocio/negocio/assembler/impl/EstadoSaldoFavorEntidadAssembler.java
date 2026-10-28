
package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.EstadoSaldoFavorDominio;
import co.com.saraitel.gestionsaraitel.entidad.EstadoSaldoFavorEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class EstadoSaldoFavorEntidadAssembler
		implements EntidadAssembler<EstadoSaldoFavorDominio, EstadoSaldoFavorEntidad> {

	private static final EntidadAssembler<EstadoSaldoFavorDominio, EstadoSaldoFavorEntidad> instancia = new EstadoSaldoFavorEntidadAssembler();

	private EstadoSaldoFavorEntidadAssembler() {
	}

	public static EntidadAssembler<EstadoSaldoFavorDominio, EstadoSaldoFavorEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public EstadoSaldoFavorEntidad convertirAEntidad(EstadoSaldoFavorDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				EstadoSaldoFavorDominio.obtenerValorDefecto());

		return new EstadoSaldoFavorEntidad(dominioTmp.getId(), dominioTmp.getCodigo(), dominioTmp.getNombre());
	}

	@Override
	public EstadoSaldoFavorDominio convertirADominio(EstadoSaldoFavorEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new EstadoSaldoFavorEntidad());

		return new EstadoSaldoFavorDominio(entidadTmp.getId(), entidadTmp.getCodigo(), entidadTmp.getNombre());
	}
}
