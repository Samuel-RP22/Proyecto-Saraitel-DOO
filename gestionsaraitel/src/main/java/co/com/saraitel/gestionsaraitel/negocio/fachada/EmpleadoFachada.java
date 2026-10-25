package co.com.saraitel.gestionsaraitel.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dto.EmpleadoDTO;

public interface EmpleadoFachada {

	void registrarInformacionNuevoEmpleado(EmpleadoDTO datos);

	void modificarInformacionEmpleadoExistente(UUID id, EmpleadoDTO datos);

	void darBajaInformacionEmpleadoExistente(UUID id);

	List<EmpleadoDTO> consultarPorFiltro(EmpleadoDTO filtro);

	List<EmpleadoDTO> consultarTodos();

	EmpleadoDTO consultarPorId(UUID id);
}
