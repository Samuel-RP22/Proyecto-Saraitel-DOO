package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.MotivoDominio;
import co.com.saraitel.gestionsaraitel.entidad.MotivoEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class MotivoEntidadAssembler implements EntidadAssembler<MotivoDominio, MotivoEntidad> {

	private static final EntidadAssembler<MotivoDominio, MotivoEntidad> instancia = new MotivoEntidadAssembler();

	private MotivoEntidadAssembler() {
	}

	public static EntidadAssembler<MotivoDominio, MotivoEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public MotivoEntidad convertirAEntidad(MotivoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				MotivoDominio.obtenerValorDefecto());
		return new MotivoEntidad(dominioTmp.getId(), dominioTmp.getNombre());
	}

	@Override
	public MotivoDominio convertirADominio(MotivoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new MotivoEntidad());
		return new MotivoDominio(entidadTmp.getId(), entidadTmp.getNombre());
	}
}
