package co.com.saraitel.gestionsaraitel.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dominio.EmpleadoDominio;

public interface EmpleadoNegocio {

	void registrarInformacionNuevoEmpleado(EmpleadoDominio datos);

	void modificarInformacionEmpleadoExistente(UUID id, EmpleadoDominio datos);

	void darBajaInformacionEmpleadoExistente(UUID id);

	List<EmpleadoDominio> consultarPorFiltro(EmpleadoDominio filtro);

	List<EmpleadoDominio> consultarTodos();

	EmpleadoDominio consultarPorId(UUID id);
}
