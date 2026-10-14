
package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import co.com.saraitel.gestionsaraitel.dao.datos.CrearDao;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDao;
import co.com.saraitel.gestionsaraitel.entidad.EstadoInventarioEntidad;

public interface EstadoSaldoFavorDAO
        extends CrearDao<EstadoInventarioEntidad>,
                ConsultarDao<EstadoInventarioEntidad, UUID> {

}
