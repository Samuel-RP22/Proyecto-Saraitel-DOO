package co.com.saraitel.gestionsaraitel.controlador.respuesta;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;

public class RespuestaOk<D> extends Respuesta<D> {

	protected RespuestaOk(List<String> mensajes, List<D> datos) {
		super(mensajes, datos, EstadoRespuesta.OK);
		// TODO Auto-generated constructor stub
	}
	
	public static <D> RespuestaOk<D> crear(List<String> mensajes, List<D> datos) {
		return new RespuestaOk<>(mensajes, datos);
	}
	
	public static <D> RespuestaOk<String> crear(List<D> datos) {
		return new RespuestaOk<>(List.of(), datos);
	}
	
	public static <D> RespuestaOk<String> crear(List<D> datos) {
		return new RespuestaOk<>(List.of(), datos);
	}
}
