
package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.CrearDao;
import co.com.saraitel.gestionsaraitel.entidad.EstadoCompraEntidad;

public interface EstadoCompraDAO
        extends CrearDao<EstadoCompraEntidad>,
                ConsultarDao<EstadoCompraEntidad, UUID> {

}
