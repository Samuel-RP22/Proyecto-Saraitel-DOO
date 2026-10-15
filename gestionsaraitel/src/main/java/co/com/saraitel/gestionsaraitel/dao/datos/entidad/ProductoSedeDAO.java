package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ActualizarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.CrearDao;
import co.com.saraitel.gestionsaraitel.entidad.ProductoSedeEntidad;

public interface ProductoSedeDAO
        extends CrearDao<ProductoSedeEntidad>,
                ConsultarDao<ProductoSedeEntidad, UUID>,
                ActualizarDao<ProductoSedeEntidad, UUID> {
}