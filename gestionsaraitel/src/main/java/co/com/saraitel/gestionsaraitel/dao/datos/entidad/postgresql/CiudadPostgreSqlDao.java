package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.CiudadDao;
import co.com.saraitel.gestionsaraitel.entidad.CiudadEntidad;

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
