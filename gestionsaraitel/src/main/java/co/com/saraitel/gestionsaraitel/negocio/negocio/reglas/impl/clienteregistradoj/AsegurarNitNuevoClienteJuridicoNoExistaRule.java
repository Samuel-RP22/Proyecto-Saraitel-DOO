package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoJEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;

public class AsegurarNitNuevoClienteJuridicoNoExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarNitNuevoClienteJuridicoNoExistaRule();

	private AsegurarNitNuevoClienteJuridicoNoExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		var nitClienteJuridico = (String) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var entidadFiltro = new ClienteRegistradoJEntidad();
		entidadFiltro.setNit(nitClienteJuridico);

		var resultados = daoFactory.obtenerClienteRegistradoJDao().consultarPorFiltro(entidadFiltro);

		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJNegocioImpl.CLIENTE_JURIDICO_YA_EXISTE_CON_EL_MISMO_NIT;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
