package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ActualizarDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.CrearDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.EliminarDao;
import co.com.saraitel.gestionsaraitel.entidad.PersonaEntidad;

public interface PersonaDAO extends CrearDAO<PersonaEntidad>, ConsultarDAO<PersonaEntidad, UUID>,
		ActualizarDAO<PersonaEntidad, UUID>, EliminarDao<UUID> {

}