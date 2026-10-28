package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteNoRegistradoDominio {

	private final UUID id;
	private final ClienteDominio cliente;
	private final String nombre;
	private final String apellido;
	private final String numeroDocumento;

	public ClienteNoRegistradoDominio(final UUID id, final ClienteDominio cliente, final String nombre,
			final String apellido, final String numeroDocumento) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente,
				ClienteDominio.obtenerValorDefecto());
		this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
		this.apellido = UtilTexto.quitarEspaciosEnBlanco(apellido);
		this.numeroDocumento = UtilTexto.quitarEspaciosEnBlanco(numeroDocumento);
	}

	public static ClienteNoRegistradoDominio obtenerValorDefecto() {
		return new ClienteNoRegistradoDominio(UtilUUID.obtenerUUIDDefecto(), ClienteDominio.obtenerValorDefecto(),
				UtilTexto.VACIA, UtilTexto.VACIA, UtilTexto.VACIA);
	}

	public UUID getId() {
		return id;
	}

	public ClienteDominio getCliente() {
		return cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}
}
