package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.CrearDAO;
import co.com.saraitel.gestionsaraitel.entidad.SaldoFavorEntidad;

public interface SaldoFavorDAO extends CrearDAO<SaldoFavorEntidad>, ConsultarDAO<SaldoFavorEntidad, UUID> {

}