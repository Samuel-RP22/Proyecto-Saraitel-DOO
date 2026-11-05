package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistrado;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AsegurarClienteRegistradoExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarClienteRegistradoExistaRule();

	private AsegurarClienteRegistradoExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 2);

		var idClienteRegistrado = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];
		var clienteRegistradoExistente = daoFactory.obtenerClienteRegistradoDao().consultarPorId(idClienteRegistrado);

		if (UtilUUID.esValorDefecto(clienteRegistradoExistente.getId())) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoNegocioImpl.CLIENTE_REGISTRADO_NO_EXISTE;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}