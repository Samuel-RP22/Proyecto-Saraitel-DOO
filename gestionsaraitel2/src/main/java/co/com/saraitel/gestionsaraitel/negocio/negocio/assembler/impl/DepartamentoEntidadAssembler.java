package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.DepartamentoDominio;
import co.com.saraitel.gestionsaraitel.entidad.DepartamentoEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class DepartamentoEntidadAssembler implements EntidadAssembler<DepartamentoDominio, DepartamentoEntidad> {

	private static final EntidadAssembler<DepartamentoDominio, DepartamentoEntidad> instancia = new DepartamentoEntidadAssembler();

	private DepartamentoEntidadAssembler() {
	}

	public static EntidadAssembler<DepartamentoDominio, DepartamentoEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public DepartamentoEntidad convertirAEntidad(DepartamentoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				DepartamentoDominio.obtenerValorDefecto());
		return new DepartamentoEntidad(dominioTmp.getId(), dominioTmp.getNombre(),
				PaisEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getPais()));
	}

	@Override
	public DepartamentoDominio convertirADominio(DepartamentoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new DepartamentoEntidad());
		return new DepartamentoDominio(entidadTmp.getId(), entidadTmp.getNombre(),
				PaisEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getPais()));
	}
}