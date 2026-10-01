package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class VendedorEntidad {

	private UUID id;
	private EmpleadoEntidad empleado;

	public VendedorEntidad() {
		super();
	}

	public VendedorEntidad(final UUID id, final EmpleadoEntidad empleado) {
		super();
		setId(id);
		setEmpleado(empleado);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public EmpleadoEntidad getEmpleado() {
		return empleado;
	}

	public void setEmpleado(final EmpleadoEntidad empleado) {
		this.empleado = empleado;
	}
}