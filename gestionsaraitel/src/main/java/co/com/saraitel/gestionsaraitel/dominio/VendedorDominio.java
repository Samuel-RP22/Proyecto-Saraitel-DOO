package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class VendedorDominio {

	private final UUID id;
	private final EmpleadoDominio empleado;

	public VendedorDominio() {
		this.id = UtilUUID.obtenerUUIDDefecto();
		this.empleado = new EmpleadoDominio();
	}

	public VendedorDominio(final UUID id, final EmpleadoDominio empleado) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.empleado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(empleado, new EmpleadoDominio());
	}

	public UUID getId() {
		return id;
	}

	public EmpleadoDominio getEmpleado() {
		return empleado;
	}
}