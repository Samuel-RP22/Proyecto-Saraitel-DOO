package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ActualizarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.CrearDao;
import co.com.saraitel.gestionsaraitel.entidad.EmpleadoEntidad;

public interface EmpleadoDAO
        extends CrearDao<EmpleadoEntidad>,
                ConsultarDao<EmpleadoEntidad, UUID>,
                ActualizarDao<EmpleadoEntidad, UUID> {

}