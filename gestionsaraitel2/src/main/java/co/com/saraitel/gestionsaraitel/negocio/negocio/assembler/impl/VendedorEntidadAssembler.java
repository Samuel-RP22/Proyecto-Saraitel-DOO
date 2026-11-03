package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.VendedorDominio;
import co.com.saraitel.gestionsaraitel.entidad.VendedorEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class VendedorEntidadAssembler implements EntidadAssembler<VendedorDominio, VendedorEntidad> {

	private static final EntidadAssembler<VendedorDominio, VendedorEntidad> instancia = new VendedorEntidadAssembler();

	private VendedorEntidadAssembler() {
	}

	public static EntidadAssembler<VendedorDominio, VendedorEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public VendedorEntidad convertirAEntidad(VendedorDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				VendedorDominio.obtenerValorDefecto());
		return new VendedorEntidad(dominioTmp.getId(),
				EmpleadoEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getEmpleado()));
	}

	@Override
	public VendedorDominio convertirADominio(VendedorEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new VendedorEntidad());
		return new VendedorDominio(entidadTmp.getId(),
				EmpleadoEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getEmpleado()));
	}
}