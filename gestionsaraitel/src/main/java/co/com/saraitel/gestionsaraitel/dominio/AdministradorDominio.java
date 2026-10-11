package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AdministradorDominio {

	private UUID id;
	private EmpleadoDominio empleado;

	public AdministradorDominio() {
		this.id = UtilUUID.obtenerUUIDDefecto();
		this.empleado = new EmpleadoDominio();
	}

	public AdministradorDominio(final UUID id, final EmpleadoDominio empleado) {
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