package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ActualizarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.EliminarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.CrearDao;
import co.com.saraitel.gestionsaraitel.entidad.DepartamentoEntidad;

public interface DepartamentoDao extends CrearDao<DepartamentoEntidad>, ConsultarDao<DepartamentoEntidad, UUID>, ActualizarDao<DepartamentoEntidad, UUID>, EliminarDao<UUID> {

}