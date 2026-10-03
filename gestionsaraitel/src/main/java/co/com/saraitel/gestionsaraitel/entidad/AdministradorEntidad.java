package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AdministradorEntidad {

	private UUID id;
	private EmpleadoEntidad empleado;

	public AdministradorEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setEmpleado(new EmpleadoEntidad());
	}

	public AdministradorEntidad(final UUID id, final EmpleadoEntidad empleado) {
		setId(id);
		setEmpleado(empleado);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public EmpleadoEntidad getEmpleado() {
		return empleado;
	}

	public void setEmpleado(final EmpleadoEntidad empleado) {
		this.empleado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(empleado, new EmpleadoEntidad());
	}
}