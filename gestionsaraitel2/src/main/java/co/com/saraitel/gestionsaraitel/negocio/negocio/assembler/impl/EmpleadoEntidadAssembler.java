package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.EmpleadoDominio;
import co.com.saraitel.gestionsaraitel.entidad.EmpleadoEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class EmpleadoEntidadAssembler implements EntidadAssembler<EmpleadoDominio, EmpleadoEntidad> {

	private static final EntidadAssembler<EmpleadoDominio, EmpleadoEntidad> instancia = new EmpleadoEntidadAssembler();

	private EmpleadoEntidadAssembler() {
	}

	public static EntidadAssembler<EmpleadoDominio, EmpleadoEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public EmpleadoEntidad convertirAEntidad(EmpleadoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				EmpleadoDominio.obtenerValorDefecto());
		return new EmpleadoEntidad(dominioTmp.getId(),
				SedeEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getSede()),
				PersonaEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getPersona()),
				dominioTmp.getEsActivo());
	}

	@Override
	public EmpleadoDominio convertirADominio(EmpleadoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new EmpleadoEntidad());
		return new EmpleadoDominio(entidadTmp.getId(),
				SedeEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getSede()),
				PersonaEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getPersona()),
				entidadTmp.getEsActivo());
	}
}