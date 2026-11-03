package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.ConsultarDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.CrearDAO;
import co.com.saraitel.gestionsaraitel.entidad.VendedorEntidad;

public interface VendedorDAO extends CrearDAO<VendedorEntidad>, ConsultarDAO<VendedorEntidad, UUID> {

}