package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ActualizarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.EliminarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.crearDao;
import co.com.saraitel.gestionsaraitel.entidad.DepartamentoEntidad;

public interface DepartamentoDao extends crearDao<DepartamentoEntidad>, ConsultarDao<DepartamentoEntidad, UUID>, ActualizarDao<DepartamentoEntidad, UUID>, EliminarDao<UUID> {

}