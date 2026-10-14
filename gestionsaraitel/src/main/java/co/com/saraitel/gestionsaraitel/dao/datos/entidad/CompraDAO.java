package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.CrearDao;
import co.com.saraitel.gestionsaraitel.entidad.CompraEntidad;

public interface CompraDAO
        extends CrearDao<CompraEntidad>,
                ConsultarDao<CompraEntidad, UUID> {

}