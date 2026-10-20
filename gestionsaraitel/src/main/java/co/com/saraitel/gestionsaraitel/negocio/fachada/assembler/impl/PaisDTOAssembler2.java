package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.PaisDominio;
import co.com.saraitel.gestionsaraitel.dto.PaisDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class PaisDTOAssembler2 implements DTOAssembler<PaisDominio, PaisDTO> {

	private static final DTOAssembler<PaisDominio, PaisDTO> instancia = new PaisDTOAssembler2();

	private PaisDTOAssembler2() {
	}

	public static DTOAssembler<PaisDominio, PaisDTO> getInstance() {
		return instancia;
	}

	@Override
	public PaisDTO convertirADTO(PaisDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new PaisDominio.Builder().build());
		return new PaisDTO(dominioTmp.getId(), dominioTmp.getNombre());
	}

	@Override
	public PaisDominio convertirADominio(PaisDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new PaisDTO());
		return new PaisDominio.Builder().id(dtoTmp.getId()).nombre(dtoTmp.getNombre()).build();
	}

	@Override
	public List<PaisDTO> convertirADTO(java.util.List<PaisDominio> listaDominios) {
		// TODO Auto-generated method stub
		return null;
	}

}
