
package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.CrearDao;
import co.com.saraitel.gestionsaraitel.entidad.EstadoSaldoFavorEntidad;

public interface EstadoInventarioDAO
        extends CrearDao<EstadoSaldoFavorEntidad>,
                ConsultarDao<EstadoSaldoFavorEntidad, UUID> {

}
