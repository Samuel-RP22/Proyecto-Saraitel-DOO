package co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MapeadorFila<E> {

	E mapear(ResultSet resultados) throws SQLException;

}
