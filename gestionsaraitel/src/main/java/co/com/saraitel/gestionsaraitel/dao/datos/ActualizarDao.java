package co.com.saraitel.gestionsaraitel.dao.datos;

public interface ActualizarDao<E, ID> {
	
	void actualizar(ID id, E entidad);

}
