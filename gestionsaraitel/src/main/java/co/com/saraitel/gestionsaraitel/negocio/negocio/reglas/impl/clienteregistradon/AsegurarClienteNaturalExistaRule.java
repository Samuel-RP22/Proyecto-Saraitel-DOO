package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradon;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AsegurarClienteNaturalExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarClienteNaturalExistaRule();

	private AsegurarClienteNaturalExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 2);

		var idClienteNatural = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var clienteNaturalExistente = daoFactory.obtenerClienteRegistradoNDao().consultarPorId(idClienteNatural);

		if (UtilUUID.esValorDefecto(clienteNaturalExistente.getId())) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoNNegocioImpl.CLIENTE_NATURAL_NO_EXISTE;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
