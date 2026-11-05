package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AsegurarClienteJuridicoExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarClienteJuridicoExistaRule();

	private AsegurarClienteJuridicoExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 2);

		var idClienteJuridico = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var clienteJuridicoExistente = daoFactory.obtenerClienteRegistradoJDao().consultarPorId(idClienteJuridico);

		if (UtilUUID.esValorDefecto(clienteJuridicoExistente.getId())) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJNegocioImpl.CLIENTE_JURIDICO_NO_EXISTE;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
