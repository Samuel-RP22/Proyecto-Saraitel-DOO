package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.PagoNormalDominio;
import co.com.saraitel.gestionsaraitel.entidad.PagoNormalEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class PagoNormalEntidadAssembler implements EntidadAssembler<PagoNormalDominio, PagoNormalEntidad> {

	private static final EntidadAssembler<PagoNormalDominio, PagoNormalEntidad> instancia = new PagoNormalEntidadAssembler();

	private PagoNormalEntidadAssembler() {
	}

	public static EntidadAssembler<PagoNormalDominio, PagoNormalEntidad> getInstance() {
		return instancia;
	}

	@Override
	public PagoNormalEntidad convertirAEntidad(PagoNormalDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				PagoNormalDominio.obtenerValorDefecto());
		return new PagoNormalEntidad(dominioTmp.getId(),
				MetodoPagoEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getMetodoPago()),
				PagoEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getPago()),
				dominioTmp.getMontoPagar());
	}

	@Override
	public PagoNormalDominio convertirADominio(PagoNormalEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new PagoNormalEntidad());
		return new PagoNormalDominio(entidadTmp.getId(),
				MetodoPagoEntidadAssembler.getInstance().convertirADominio(entidadTmp.getMetodoPago()),
				PagoEntidadAssembler.getInstance().convertirADominio(entidadTmp.getPago()),
				entidadTmp.getMontoPagar());
	}
}
