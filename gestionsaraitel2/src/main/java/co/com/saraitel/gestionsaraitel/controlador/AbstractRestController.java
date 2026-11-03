package co.com.saraitel.gestionsaraitel.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import co.com.saraitel.gestionsaraitel.controlador.respuesta.RespuestaError;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.logger.GestionSaraitelLogger;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

@RestControllerAdvice
public abstract class AbstractRestController {

	private final GestionSaraitelLogger logger = GestionSaraitelLogger.obtener(getClass());

	@ExceptionHandler(GestionSaraitelExcepcion.class)
	public ResponseEntity<RespuestaError<String>> controlarGestionSaraitelExcepcion(
			GestionSaraitelExcepcion excepcion) {
		var respuesta = RespuestaError.crear(excepcion.getMensajeUsuario());
		logger.registrarExcepcion(respuesta.getCorrelationId(), excepcion);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
	}

	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<RespuestaError<String>> controlarNoResourceFoundException(
			NoResourceFoundException excepcion) {
		var mensajeRespuesta = UtilTexto.concatenar(
				CatalogoMensajes.AbstractRestController.USUARIO_ERROR_RECURSO_NO_EXISTE, excepcion.getResourcePath(),
				CatalogoMensajes.AbstractRestController.USUARIO_ERROR_RECURSO_NO_EXISTE_POR_METODO,
				excepcion.getHttpMethod().name());
		var respuesta = RespuestaError.crear(mensajeRespuesta);
		logger.advertencia(CatalogoMensajes.AbstractRestController.TECNICO_RECURSO_NO_ENCONTRADO,
				respuesta.getCorrelationId(), excepcion.getHttpMethod(), excepcion.getResourcePath());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<RespuestaError<String>> controlarExcepcionNoControlada(Exception excepcion) {
		var mensajeRespuesta = CatalogoMensajes.AbstractRestController.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO;
		var respuesta = RespuestaError.crear(mensajeRespuesta);
		logger.registrarExcepcion(respuesta.getCorrelationId(), excepcion);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
	}
}