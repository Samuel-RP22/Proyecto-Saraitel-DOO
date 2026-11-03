package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.PersonaDominio;
import co.com.saraitel.gestionsaraitel.entidad.PersonaEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class PersonaEntidadAssembler implements EntidadAssembler<PersonaDominio, PersonaEntidad> {

	private static final EntidadAssembler<PersonaDominio, PersonaEntidad> instancia = new PersonaEntidadAssembler();

	private PersonaEntidadAssembler() {
	}

	public static EntidadAssembler<PersonaDominio, PersonaEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public PersonaEntidad convertirAEntidad(PersonaDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				PersonaDominio.obtenerValorDefecto());
		return new PersonaEntidad.Builder().id(dominioTmp.getId())
				.tipoDocumento(
						TipoDocumentoEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getTipoDocumento()))
				.prefijo(PrefijoEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getPrefijo()))
				.numeroDocumento(dominioTmp.getNumeroDocumento()).telefono(dominioTmp.getTelefono())
				.nombre(dominioTmp.getNombre()).apellido(dominioTmp.getApellido()).correo(dominioTmp.getCorreo())
				.telefonoConfirmado(dominioTmp.getTelefonoConfirmado())
				.correoConfirmado(dominioTmp.getCorreoConfirmado()).construir();
	}

	@Override
	public PersonaDominio convertirADominio(PersonaEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new PersonaEntidad());
		return new PersonaDominio.Builder().id(entidadTmp.getId())
				.tipoDocumento(
						TipoDocumentoEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getTipoDocumento()))
				.prefijo(PrefijoEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getPrefijo()))
				.numeroDocumento(entidadTmp.getNumeroDocumento()).telefono(entidadTmp.getTelefono())
				.nombre(entidadTmp.getNombre()).apellido(entidadTmp.getApellido()).correo(entidadTmp.getCorreo())
				.telefonoConfirmado(entidadTmp.getTelefonoConfirmado())
				.correoConfirmado(entidadTmp.getCorreoConfirmado()).construir();
	}
}