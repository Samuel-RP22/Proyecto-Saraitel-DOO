package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoJEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PrefijoEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;

public class AsegurarTelefonoNuevoClienteJuridicoNoExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarTelefonoNuevoClienteJuridicoNoExistaRule();

	private AsegurarTelefonoNuevoClienteJuridicoNoExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 3);

		var idPrefijo = (UUID) datos[0];
		var telefonoClienteJuridico = (String) datos[1];
		var daoFactory = (DAOFactory) datos[2];

		var prefijoFiltro = new PrefijoEntidad();
		prefijoFiltro.setId(idPrefijo);

		var entidadFiltro = new ClienteRegistradoJEntidad();
		entidadFiltro.setPrefijo(prefijoFiltro);
		entidadFiltro.setTelefono(telefonoClienteJuridico);

		var resultados = daoFactory.obtenerClienteRegistradoJDao().consultarPorFiltro(entidadFiltro);

		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJNegocioImpl.CLIENTE_JURIDICO_YA_EXISTE_CON_EL_MISMO_TELEFONO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
