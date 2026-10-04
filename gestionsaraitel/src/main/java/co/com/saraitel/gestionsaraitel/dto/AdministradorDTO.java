package co.com.saraitel.gestionsaraitel.dto;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AdministradorDTO {

	private UUID id;
	private EmpleadoDTO empleado;

	public AdministradorDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setEmpleado(new EmpleadoDTO());
	}

	public AdministradorDTO(final UUID id, final EmpleadoDTO empleado) {
		setId(id);
		setEmpleado(empleado);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public EmpleadoDTO getEmpleado() {
		return empleado;
	}

	public void setEmpleado(final EmpleadoDTO empleado) {
		this.empleado = UtilObjeto.esNulo(empleado) ? 
				new EmpleadoDTO() : empleado ;
	}
}