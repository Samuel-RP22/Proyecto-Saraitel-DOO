package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.CrearDao;
import co.com.saraitel.gestionsaraitel.dao.datos.EliminarDao;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoNEntidad;

public interface ClienteRegistradoNDAO
        extends CrearDao<ClienteRegistradoNEntidad>,
                ConsultarDao<ClienteRegistradoNEntidad, UUID>,
                EliminarDao<UUID> {

}