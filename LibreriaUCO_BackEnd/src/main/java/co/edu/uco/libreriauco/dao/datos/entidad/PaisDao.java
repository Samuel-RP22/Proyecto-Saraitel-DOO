package co.edu.uco.libreriauco.dao.datos.entidad;

import java.util.UUID;

import co.edu.uco.libreriauco.dao.datos.crearDAO;
import co.edu.uco.libreriauco.dao.datos.EliminarDao;
import co.edu.uco.libreriauco.dao.datos.ConsultarDao;
import co.edu.uco.libreriauco.dao.datos.ActualizarDao;
import co.edu.uco.libreriauco.entidad.PaisEntidad;

public interface PaisDao extends crearDAO<PaisEntidad>, ConsultarDao<PaisEntidad, UUID>, ActualizarDao<PaisEntidad, UUID>, EliminarDao<UUID> {

}
