package co.com.saraitel.gestionsaraitel.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import co.com.saraitel.gestionsaraitel.controlador.respuesta.RespuestaError;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;

@RestControllerAdvice
public abstract class AbstractRestController {

	@ExceptionHandler(GestionSaraitelExcepcion.class)
	public ResponseEntity<RespuestaError<String>> controlarGestionSaraitelExcepcion(GestionSaraitelExcepcion excepcion) {
		var respuesta = RespuestaError.crear(excepcion.getMensajeUsuario());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
		//logger.printException(excepcion);
	}

	/*@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<RespuestaError<String>> controlarJsonInvalido(HttpMessageNotReadableException excepcion) {
		var mensajeRespuesta = "El cuerpo de la petición no tiene un formato JSON válido";
		var respuesta = RespuestaError.crear(mensajeRespuesta);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
	}*/ //QUE HACER CON ESTO????

	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<RespuestaError<String>> controlarNoResourceFoundException(NoResourceFoundException excepcion) {
		var mensajeRespuesta = "El recurso que pidió no existe....: " + excepcion.getResourcePath()
		+ "por el método: " + excepcion.getHttpMethod();
		var respuesta = RespuestaError.crear(mensajeRespuesta);
		excepcion.printStackTrace();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		//logger.printException(excepcion);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<RespuestaError<String>> controlarExcepcionNoControlada(Exception excepcion) {
		var mensajeRespuesta = "Se ha presentado un problema inesperado tratando de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y entréguele el código que se muestra a continuación";
		var respuesta = RespuestaError.crear(mensajeRespuesta);
		excepcion.printStackTrace(); // AGREGADO
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
		//logger.printException(excepcion);
	}
}