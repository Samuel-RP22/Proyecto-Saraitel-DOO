package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.CrearDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.EliminarDao;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;

public interface ClienteDAO extends CrearDAO<ClienteEntidad>, ConsultarDAO<ClienteEntidad, UUID>, EliminarDao<UUID> {

}