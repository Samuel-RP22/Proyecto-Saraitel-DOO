package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.PaisDominio;
import co.com.saraitel.gestionsaraitel.entidad.PaisEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class PaisEntidadAssembler implements EntidadAssembler<PaisDominio, PaisEntidad>{

	private static final EntidadAssembler<PaisDominio, PaisEntidad> instancia = new PaisEntidadAssembler();
	
	public static EntidadAssembler<PaisDominio, PaisEntidad> getInstance() {
		return instancia;
	}
	
	private PaisEntidadAssembler() {	
		
	}
	
	@Override
	public PaisEntidad convertirAEntidad(PaisDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, 
				new PaisDominio.Builder().build());
		return new PaisEntidad(dominioTmp.getId(), dominioTmp.getNombre());
	}

	@Override
	public PaisDominio convertirADominio(PaisEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, 
				new PaisEntidad());
		return new PaisDominio.Builder()
				.id(entidadTmp.getId())
				.nombre(entidadTmp.getNombre()).build();
	}
	
	
}
