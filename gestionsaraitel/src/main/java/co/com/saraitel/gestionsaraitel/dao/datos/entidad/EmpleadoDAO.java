package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ActualizarDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.CrearDAO;
import co.com.saraitel.gestionsaraitel.entidad.EmpleadoEntidad;

public interface EmpleadoDAO
		extends CrearDAO<EmpleadoEntidad>, ConsultarDAO<EmpleadoEntidad, UUID>, ActualizarDAO<EmpleadoEntidad, UUID> {

}