package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ActualizarDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.CrearDAO;
import co.com.saraitel.gestionsaraitel.entidad.DevolucionEntidad;

public interface DevolucionDAO extends CrearDAO<DevolucionEntidad>, ConsultarDAO<DevolucionEntidad, UUID>,
		ActualizarDAO<DevolucionEntidad, UUID> {

}