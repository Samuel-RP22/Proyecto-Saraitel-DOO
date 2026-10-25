package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AsegurarPrefijoClienteJuridicoExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarPrefijoClienteJuridicoExistaRule();

	private AsegurarPrefijoClienteJuridicoExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		var idPrefijo = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var prefijoExistente = daoFactory.obtenerPrefijoDao().consultarPorId(idPrefijo);

		if (prefijoExistente.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJNegocioImpl.PREFIJO_CLIENTE_JURIDICO_NO_EXISTE;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
