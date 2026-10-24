package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.AdministradorDominio;
import co.com.saraitel.gestionsaraitel.entidad.AdministradorEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class AdministradorEntidadAssembler implements EntidadAssembler<AdministradorDominio, AdministradorEntidad> {

	private static final EntidadAssembler<AdministradorDominio, AdministradorEntidad> instancia = new AdministradorEntidadAssembler();

	private AdministradorEntidadAssembler() {
	}

	public static EntidadAssembler<AdministradorDominio, AdministradorEntidad> getInstance() {
		return instancia;
	}

	@Override
	public AdministradorEntidad convertirAEntidad(AdministradorDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				AdministradorDominio.obtenerValorDefecto());
		return new AdministradorEntidad(dominioTmp.getId(),
				EmpleadoEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getEmpleado()));
	}

	@Override
	public AdministradorDominio convertirADominio(AdministradorEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new AdministradorEntidad());
		return new AdministradorDominio(entidadTmp.getId(),
				EmpleadoEntidadAssembler.getInstance().convertirADominio(entidadTmp.getEmpleado()));
	}
}