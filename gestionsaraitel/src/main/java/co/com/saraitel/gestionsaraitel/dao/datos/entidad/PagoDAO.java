package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.CrearDao;
import co.com.saraitel.gestionsaraitel.entidad.PagoEntidad;

public interface PagoDAO
        extends CrearDao<PagoEntidad>,
                ConsultarDao<PagoEntidad, UUID> {

}