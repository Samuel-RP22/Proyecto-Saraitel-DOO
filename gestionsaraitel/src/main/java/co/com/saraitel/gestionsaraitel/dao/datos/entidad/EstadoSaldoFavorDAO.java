package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import co.com.saraitel.gestionsaraitel.dao.datos.CrearDAO;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDAO;
import co.com.saraitel.gestionsaraitel.entidad.EstadoInventarioEntidad;

public interface EstadoSaldoFavorDAO
		extends CrearDAO<EstadoInventarioEntidad>, ConsultarDAO<EstadoInventarioEntidad, UUID> {

}
