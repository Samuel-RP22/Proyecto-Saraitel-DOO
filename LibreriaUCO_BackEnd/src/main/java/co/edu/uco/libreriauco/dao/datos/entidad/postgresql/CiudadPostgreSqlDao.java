package co.edu.uco.libreriauco.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.libreriauco.dao.datos.entidad.CiudadDao;
import co.edu.uco.libreriauco.entidad.CiudadEntidad;

public class CiudadPostgreSqlDao extends SqlDAO implements CiudadDao {

    public CiudadPostgreSqlDao(final Connection conexion) {
        super(conexion);
    }

    @Override
    public void crear(final CiudadEntidad entidad) {
        // Lógica de inserción
    }

    @Override
    public void actualizar(final CiudadEntidad entidad) {
        // Lógica de actualización
    }

    @Override
    public void eliminar(final CiudadEntidad entidad) {
        // Lógica de eliminación
    }

    @Override
    public List<CiudadEntidad> consultar(final CiudadEntidad entidad) {
        return null;
    }
}
