package co.com.saraitel.gestionsaraitel.dao.factoria.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelTransversalExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

final class PoolConexionesPostgreSql {

	private static final String VARIABLE_URL = "DATABASE_URL";
	private static final String VARIABLE_USUARIO = "DATABASE_USER";
	private static final String VARIABLE_CONTRASENA = "DATABASE_PASSWORD";
	private static final String NOMBRE_POOL = "PoolGestionSaraitel";
	private static final int MAXIMO_CONEXIONES = 10;
	private static final int MINIMO_CONEXIONES_INACTIVAS = 2;
	private static final long TIEMPO_MAXIMO_ESPERA_MILISEGUNDOS = 30_000L;

	private static HikariDataSource fuenteDatos;

	private PoolConexionesPostgreSql() {
	}

	static Connection obtenerConexion() throws SQLException {
		return obtenerFuenteDatos().getConnection();
	}

	private static synchronized HikariDataSource obtenerFuenteDatos() {
		if (UtilObjeto.esNulo(fuenteDatos)) {
			fuenteDatos = crearFuenteDatos();
		}
		return fuenteDatos;
	}

	private static HikariDataSource crearFuenteDatos() {
		var configuracion = new HikariConfig();
		configuracion.setPoolName(NOMBRE_POOL);
		configuracion.setJdbcUrl(obtenerVariableEntorno(VARIABLE_URL));
		configuracion.setUsername(obtenerVariableEntorno(VARIABLE_USUARIO));
		configuracion.setPassword(obtenerVariableEntorno(VARIABLE_CONTRASENA));
		configuracion.setMaximumPoolSize(MAXIMO_CONEXIONES);
		configuracion.setMinimumIdle(MINIMO_CONEXIONES_INACTIVAS);
		configuracion.setConnectionTimeout(TIEMPO_MAXIMO_ESPERA_MILISEGUNDOS);
		try {
			return new HikariDataSource(configuracion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.PoolConexionesPostgreSql.USUARIO_ERROR_PROBLEMA_CREANDO_POOL_CONEXIONES_POSTGRESQL;
			throw GestionSaraitelTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	private static String obtenerVariableEntorno(final String nombreVariable) {
		var valor = System.getenv(nombreVariable);
		if (UtilTexto.esVacia(valor)) {
			var mensajeUsuario = CatalogoMensajes.PoolConexionesPostgreSql.USUARIO_ERROR_CONFIGURACION_CONEXION_POSTGRESQL_INCOMPLETA;
			var mensajeTecnico = UtilTexto.concatenar(
					CatalogoMensajes.PoolConexionesPostgreSql.TECNICO_ERROR_VARIABLE_ENTORNO_NO_DEFINIDA, nombreVariable);
			throw GestionSaraitelTransversalExcepcion.crear(mensajeUsuario, mensajeTecnico);
		}
		return valor;
	}
}