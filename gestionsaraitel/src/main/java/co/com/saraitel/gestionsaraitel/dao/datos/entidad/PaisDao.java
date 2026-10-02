package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ActualizarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.EliminarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.CrearDao;
import co.com.saraitel.gestionsaraitel.entidad.PaisEntidad;

public interface PaisDao extends CrearDao<PaisEntidad>, ConsultarDao<PaisEntidad, UUID>, ActualizarDao<PaisEntidad, UUID>, EliminarDao<UUID> {

}
