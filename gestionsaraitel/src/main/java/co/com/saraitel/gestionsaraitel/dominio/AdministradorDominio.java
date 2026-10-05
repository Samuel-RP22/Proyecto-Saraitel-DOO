package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AdministradorDominio {

	private UUID id;
	private EmpleadoDominio empleado;

	
	private AdministradorDominio(Builder builder) {
		this.id = builder.id;
		this.empleado = builder.empleado;
	}

	public UUID getId() {
		return id;
	}
	
	public EmpleadoDominio getSede() {
		return empleado;
	}
	
	public static class Builder {
		private UUID id;
		private EmpleadoDominio empleado;
		
		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			empleado = new EmpleadoDominio.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder empleado(EmpleadoDominio empleado) {
			this.empleado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(empleado, new EmpleadoDominio.Builder().build());
			return this;
		}

		public AdministradorDominio build() {
			return new AdministradorDominio(this);
		}
	}
}