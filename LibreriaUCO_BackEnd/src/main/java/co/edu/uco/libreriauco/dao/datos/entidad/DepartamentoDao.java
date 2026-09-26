package co.edu.uco.libreriauco.dao.datos.entidad;

import java.util.UUID;

import co.edu.uco.libreriauco.dao.datos.crearDAO;
import co.edu.uco.libreriauco.dao.datos.EliminarDao;
import co.edu.uco.libreriauco.dao.datos.ConsultarDao;
import co.edu.uco.libreriauco.dao.datos.ActualizarDao;
import co.edu.uco.libreriauco.entidad.DepartamentoEntidad;

public interface DepartamentoDao extends crearDAO<DepartamentoEntidad>, ConsultarDao<DepartamentoEntidad, UUID>, ActualizarDao<DepartamentoEntidad, UUID>, EliminarDao<UUID> {

}