package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.ciudad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AsegurarCiudadExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarCiudadExistaRule();

	private AsegurarCiudadExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 2);

		var idCiudad = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var ciudadExistente = daoFactory.obtenerCiudadDao().consultarPorId(idCiudad);

		if (UtilUUID.esValorDefecto(ciudadExistente.getId())) {
			var mensajeUsuario = CatalogoMensajes.CiudadNegocioImpl.USUARIO_ERROR_CIUDAD_NO_EXISTE;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}