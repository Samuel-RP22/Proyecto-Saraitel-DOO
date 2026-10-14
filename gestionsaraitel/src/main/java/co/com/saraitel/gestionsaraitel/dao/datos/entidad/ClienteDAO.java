package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.CrearDao;
import co.com.saraitel.gestionsaraitel.dao.datos.EliminarDao;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;

public interface ClienteDAO
        extends CrearDao<ClienteEntidad>,
                ConsultarDao<ClienteEntidad, UUID>,
                EliminarDao<UUID> {

}