package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ActualizarDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.CrearDAO;
import co.com.saraitel.gestionsaraitel.entidad.ProcesoCompraEntidad;

public interface ProcesoCompraDAO extends CrearDAO<ProcesoCompraEntidad>, ConsultarDAO<ProcesoCompraEntidad, UUID>,
		ActualizarDAO<ProcesoCompraEntidad, UUID> {

}