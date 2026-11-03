package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.CrearDAO;
import co.com.saraitel.gestionsaraitel.entidad.CompraEntidad;

public interface CompraDAO extends CrearDAO<CompraEntidad>, ConsultarDAO<CompraEntidad, UUID> {

}