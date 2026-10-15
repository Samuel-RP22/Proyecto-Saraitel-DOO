package co.com.saraitel.gestionsaraitel.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.com.saraitel.gestionsaraitel.controlador.respuesta.RespuestaError;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelException;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

@RestControllerAdvice
public abstract class AbstractRestController {

	@ExceptionHandler(GestionSaraitelException.class)
	public ResponseEntity<RespuestaError<String>> controlarGestionSaraitelExcepcion(GestionSaraitelException excepcion) {
		var respuesta = RespuestaError.crear(excepcion.getMensajeUsuario());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
		//logger.printException(excepcion);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<RespuestaError<String>> controlarExcepcionNoControlada(Exception excepcion) {
		var mensajeRespuesta = "Se ha presentado un problema inesperado tratando de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y entréguele el código que se muestra a continuación"
								.concat();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
		//logger.printException(excepcion);
	}
}
