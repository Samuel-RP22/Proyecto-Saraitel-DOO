package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.cliente;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AsegurarClienteExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarClienteExistaRule();

	private AsegurarClienteExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 2);

		var idCliente = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];
		var clienteExistente = daoFactory.obtenerClienteDao().consultarPorId(idCliente);

		if (UtilUUID.esValorDefecto(clienteExistente.getId())) {
			var mensajeUsuario = CatalogoMensajes.ClienteNegocioImpl.CLIENTE_NO_EXISTE;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}