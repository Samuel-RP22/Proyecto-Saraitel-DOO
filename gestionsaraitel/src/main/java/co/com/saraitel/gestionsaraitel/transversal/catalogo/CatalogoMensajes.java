package co.com.saraitel.gestionsaraitel.transversal.catalogo;

public class CatalogoMensajes {

	private CatalogoMensajes() {
	}

	public static class UtilSQL {

		private UtilSQL() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se ha presentado un problema tratando de validar si la conexion contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada estaba abierta o no abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se ha presentado un problema NO CONTROLADO tratando de validar si la conexión contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada estaba abierta o no abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = "Se ha presentado un problema tratando de validar si la conexión contra la fuente de información estaba en un estado consistente al tratar de llevar a cabo la operación deseada, por favor intente de nuevo y si el problema persiste contante al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = "Se ha presentado un problema NO CONTROLADO tratando  de validar si la conexión contra la fuente de información estaba en un estado consistente al tratar de llevar a cabo la operación deseada, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL = "No es posible continuar con la operación deseada, debido a que la conexión contra la fuente de información, se encuentra en un estado inconsistente, porque esta cerrada, esta vacia o porque la transacción ya fue iniciada, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_INICIANDO_TRANSACCION_SQL = "Se ha presentado un problema tratando de iniciar la transacción contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_INICIANDO_TRANSACCION_SQL = "Se ha presentado un problema NO CONTROLADO tratando de iniciar la transacción contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CONFIRMAR_TRANSACCION_SQL = "No es posible continuar con la operación deseada, debido a que la conexión contra la fuente de información, se encuentra en un estado inconsistente, porque esta cerrada, esta vacia o porque la transacción no fue iniciada, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONFIRMANDO_TRANSACCION_SQL = "Se ha presentado un problema tratando de confirmar la transacción contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONFIRMANDO_TRANSACCION_SQL = "Se ha presentado un problema NO CONTROLADO tratando de confirmar la transacción contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CANCELAR_TRANSACCION_SQL = "No es posible continuar con la operación deseada, debido a que la conexión contra la fuente de información, se encuentra en un estado inconsistente, porque esta cerrada, esta vacia o porque la transacción no fue iniciada, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CANCELANDO_TRANSACCION_SQL = "Se ha presentado un problema tratando de cancelar la transacción contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CANCELANDO_TRANSACCION_SQL = "Se ha presentado un problema NO CONTROLADO tratando de cancelar la transacción contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CERRAR_CONEXION_SQL = "No es posible continuar con la operación deseada, debido a que la conexión contra la fuente de información, se encuentra en un estado inconsistente, porque esta vacia o porque ya se encontraba cerrada, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CERRANDO_CONEXION_SQL = "Se ha presentado un problema tratando de cerrar la conexión contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CERRANDO_CONEXION_SQL = "Se ha presentado un problema NO CONTROLADO tratando de cerrar la conexión contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
	}


public static class PostgreSqlDAO {

    private PostgreSqlDAO() {
    }

    public static final String USUARIO_ERROR_CREANDO_REGISTRO =
            "Se presentó un problema al registrar la información. "
            + "Por favor, intente de nuevo y si el problema persiste "
            + "contacte al administrador de la aplicación.";

    public static final String USUARIO_ERROR_CONSULTANDO_REGISTROS =
            "Se presentó un problema al consultar la información. "
            + "Por favor, intente de nuevo y si el problema persiste "
            + "contacte al administrador de la aplicación.";

    public static final String USUARIO_ERROR_ACTUALIZANDO_REGISTRO =
            "Se presentó un problema al actualizar la información. "
            + "Por favor, intente de nuevo y si el problema persiste "
            + "contacte al administrador de la aplicación.";

    public static final String USUARIO_ERROR_ELIMINANDO_REGISTRO =
            "Se presentó un problema al eliminar la información. "
            + "Por favor, intente de nuevo y si el problema persiste "
            + "contacte al administrador de la aplicación.";
}


	public static class DAOFactory {
		private DAOFactory() {
		}

		public static final String USUARIO_ERROR_FUENTE_INFORMACION_NO_HABILITADA = "La fuente de información deseada que se solicitó para llevar a cabo la operación no está habilitada, por favor contacte el administrador de la aplicación";
	}


	
	
	
	public static class PaisFachadaImpl {
		private PaisFachadaImpl() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_PAIS = "Se ha presentado un problema inesperado tratando de registrar la información del nuevo país deseado, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static class PaisNegocioImpl {
		private PaisNegocioImpl() {
		}

		public static final String PAIS_YA_EXISTE_CON_EL_MISMO_NOMBRE_DE_PAIS_A_CREAR = "Ya existe otro país con el nombre con el cual se desea crear el pais deseado";
		public static final String NOMBRE_PAIS_OBLIGATORIO = "El nombre del país es obligatorio para llevar a cabo la operación deseada";
		public static final String LONGITUD_NOMBRE_PAIS_NO_VALIDA = "La longitud del nombre del país no es valida, asegurese que este entre 1 y 100";
		public static final String FORMATO_NOMBRE_PAIS_NO_VALIDO = "El formato del nombre del país no es valido, asegurese que solo posea letras de la A a la Z mayúsculas y minúsculas y espacios";
	}
}
