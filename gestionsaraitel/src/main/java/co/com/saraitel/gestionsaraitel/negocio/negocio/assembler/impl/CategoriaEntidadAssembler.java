package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.CategoriaDominio;
import co.com.saraitel.gestionsaraitel.entidad.CategoriaEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class CategoriaEntidadAssembler implements EntidadAssembler<CategoriaDominio, CategoriaEntidad> {

	private static final EntidadAssembler<CategoriaDominio, CategoriaEntidad> instancia = new CategoriaEntidadAssembler();

	private CategoriaEntidadAssembler() {
	}

	public static EntidadAssembler<CategoriaDominio, CategoriaEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public CategoriaEntidad convertirAEntidad(CategoriaDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				CategoriaDominio.obtenerValorDefecto());
		return new CategoriaEntidad(dominioTmp.getId(), dominioTmp.getNombre(), dominioTmp.getIdCategoriaPadre(),
				dominioTmp.getNivel());
	}

	@Override
	public CategoriaDominio convertirADominio(CategoriaEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new CategoriaEntidad());
		return new CategoriaDominio(entidadTmp.getId(), entidadTmp.getNombre(), entidadTmp.getIdCategoriaPadre(),
				entidadTmp.getNivel());
	}
}