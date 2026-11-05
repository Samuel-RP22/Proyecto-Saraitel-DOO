package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoJEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;

public class AsegurarRazonSocialClienteJuridicoNoExistaEnOtroClienteJuridicoRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarRazonSocialClienteJuridicoNoExistaEnOtroClienteJuridicoRule();

	private AsegurarRazonSocialClienteJuridicoNoExistaEnOtroClienteJuridicoRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 3);

		var idClienteJuridico = (UUID) datos[0];
		var razonSocialClienteJuridico = (String) datos[1];
		var daoFactory = (DAOFactory) datos[2];

		var entidadFiltro = new ClienteRegistradoJEntidad();
		entidadFiltro.setRazonSocial(razonSocialClienteJuridico);

		var resultados = daoFactory.obtenerClienteRegistradoJDao().consultarPorFiltro(entidadFiltro);

		if (resultados.stream().anyMatch(clienteJuridico -> !clienteJuridico.getId().equals(idClienteJuridico))) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJNegocioImpl.RAZON_SOCIAL_CLIENTE_JURIDICO_YA_EXISTE_EN_OTRO_CLIENTE_JURIDICO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
