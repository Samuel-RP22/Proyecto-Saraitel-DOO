package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDao;
import co.com.saraitel.gestionsaraitel.dao.datos.CrearDao;
import co.com.saraitel.gestionsaraitel.entidad.SaldoFavorEntidad;

public interface SaldoFavorDAO
        extends CrearDao<SaldoFavorEntidad>,
                ConsultarDao<SaldoFavorEntidad, UUID> {

}