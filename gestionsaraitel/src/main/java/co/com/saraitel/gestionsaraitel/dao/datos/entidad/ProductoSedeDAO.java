package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ActualizarDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.CrearDAO;
import co.com.saraitel.gestionsaraitel.entidad.ProductoSedeEntidad;

public interface ProductoSedeDAO extends CrearDAO<ProductoSedeEntidad>, ConsultarDAO<ProductoSedeEntidad, UUID>,
		ActualizarDAO<ProductoSedeEntidad, UUID> {
}