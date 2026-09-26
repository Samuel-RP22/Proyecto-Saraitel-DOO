package co.edu.uco.libreriauco.dao.datos.entidad;

import java.util.UUID;

import co.edu.uco.libreriauco.dao.datos.ActualizarDao;
import co.edu.uco.libreriauco.dao.datos.ConsultarDao;
import co.edu.uco.libreriauco.dao.datos.EliminarDao;
import co.edu.uco.libreriauco.dao.datos.crearDAO;
import co.edu.uco.libreriauco.entidad.CiudadEntidad;

public interface CiudadDao extends crearDAO<CiudadEntidad>, ConsultarDao<CiudadEntidad>, ActualizarDao<CiudadEntidad>, EliminarDao<CiudadEntidad> {
}
