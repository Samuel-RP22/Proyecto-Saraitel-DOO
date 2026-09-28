package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.crearDao;
import co.com.saraitel.gestionsaraitel.dao.datos.ActualizarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.EliminarDao;
import co.com.saraitel.gestionsaraitel.entidad.CiudadEntidad;

public interface CiudadDao extends crearDao<CiudadEntidad>, ConsultarDao<CiudadEntidad, UUID>, ActualizarDao<CiudadEntidad, UUID>, EliminarDao<CiudadEntidad> {
}
