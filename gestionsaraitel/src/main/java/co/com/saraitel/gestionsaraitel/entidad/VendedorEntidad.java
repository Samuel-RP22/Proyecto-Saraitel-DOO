package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class VendedorEntidad {

	private UUID id;
	private EmpleadoEntidad empleado;

	public VendedorEntidad() {
		super();
	}

	private VendedorEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setEmpleado(builder.empleado);
	}

	public static Builder builder() {
		return new Builder();
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

	public static class Builder {

		private UUID id;
		private EmpleadoEntidad empleado;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder empleado(final EmpleadoEntidad empleado) {
			this.empleado = empleado;
			return this;
		}

		public VendedorEntidad build() {
			return new VendedorEntidad(this);
		}
	}
}