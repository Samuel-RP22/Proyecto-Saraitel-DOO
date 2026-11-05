package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoJEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PrefijoEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;

public class AsegurarTelefonoClienteJuridicoNoExistaEnOtroClienteJuridicoRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarTelefonoClienteJuridicoNoExistaEnOtroClienteJuridicoRule();

	private AsegurarTelefonoClienteJuridicoNoExistaEnOtroClienteJuridicoRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 4);

		var idClienteJuridico = (UUID) datos[0];
		var idPrefijo = (UUID) datos[1];
		var telefonoClienteJuridico = (String) datos[2];
		var daoFactory = (DAOFactory) datos[3];

		var prefijoFiltro = new PrefijoEntidad();
		prefijoFiltro.setId(idPrefijo);

		var entidadFiltro = new ClienteRegistradoJEntidad();
		entidadFiltro.setPrefijo(prefijoFiltro);
		entidadFiltro.setTelefono(telefonoClienteJuridico);

		var resultados = daoFactory.obtenerClienteRegistradoJDao().consultarPorFiltro(entidadFiltro);

		if (resultados.stream().anyMatch(clienteJuridico -> !clienteJuridico.getId().equals(idClienteJuridico))) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJNegocioImpl.TELEFONO_CLIENTE_JURIDICO_YA_EXISTE_EN_OTRO_CLIENTE_JURIDICO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
