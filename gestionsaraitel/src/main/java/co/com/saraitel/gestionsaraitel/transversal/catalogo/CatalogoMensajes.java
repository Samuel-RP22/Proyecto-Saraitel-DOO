package co.com.saraitel.gestionsaraitel.transversal.catalogo;

public final class CatalogoMensajes {

	private CatalogoMensajes() {
	}

	public static final class EmpleadoAutenticado {

		private EmpleadoAutenticado() {
		}

		public static final String USUARIO_AUTENTICADO_NO_ES_EMPLEADO_ACTIVO = "El usuario con el que inició sesión no está registrado como un empleado activo, por lo que no puede registrar procesos de compra. Contacte al administrador de la aplicación";
		public static final String USUARIO_NO_ES_EMPLEADO_ACTIVO_PARA_INGRESAR = "No puede ingresar a Saraitel: el correo con el que se autenticó no pertenece a un empleado activo. Intente con otra cuenta o contacte al administrador de la aplicación";
	}

	public static final class AbstractRestController {

		private AbstractRestController() {
		}

		public static final String USUARIO_ERROR_RECURSO_NO_EXISTE = "El recurso que pidió no existe: ";
		public static final String USUARIO_ERROR_RECURSO_NO_EXISTE_POR_METODO = " por el método: ";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO = "Se ha presentado un problema inesperado tratando de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y entréguele el código que se muestra a continuación";
		public static final String TECNICO_RECURSO_NO_ENCONTRADO = "[{}] Recurso no encontrado: {} {}";
	}

	public static final class ClienteRegistradoJControlador {

		private ClienteRegistradoJControlador() {
		}

		public static final String USUARIO_EXITO_CLIENTE_JURIDICO_REGISTRADO = "Se ha registrado la información del nuevo cliente jurídico de forma exitosa";
	}

	public static final class ClienteRegistradoNControlador {

		private ClienteRegistradoNControlador() {
		}

		public static final String USUARIO_EXITO_CLIENTE_NATURAL_REGISTRADO = "Se ha registrado la información del nuevo cliente natural de forma exitosa";
	}

	public static final class ProcesoCompraControlador {

		private ProcesoCompraControlador() {
		}

		public static final String USUARIO_EXITO_PROCESO_COMPRA_REGISTRADO = "Se ha registrado la información del nuevo proceso de compra de forma exitosa";
	}

	public static final class PaisFachadaImpl {

		private PaisFachadaImpl() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAISES_CON_FILTRO = "Se ha presentado un problema inesperado tratando de consultar la información de los países con el filtro deseado, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAISES = "Se ha presentado un problema inesperado tratando de consultar la información de los países, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAIS_POR_ID = "Se ha presentado un problema inesperado tratando de consultar la información del país, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
	}

	public static final class DepartamentoFachadaImpl {

		private DepartamentoFachadaImpl() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DEPARTAMENTOS_CON_FILTRO = "Se ha presentado un problema inesperado tratando de consultar la información de los departamentos con el filtro deseado, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DEPARTAMENTOS = "Se ha presentado un problema inesperado tratando de consultar la información de los departamentos, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DEPARTAMENTO_POR_ID = "Se ha presentado un problema inesperado tratando de consultar la información del departamento, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
	}

	public static final class CiudadFachadaImpl {

		private CiudadFachadaImpl() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CIUDADES_CON_FILTRO = "Se ha presentado un problema inesperado tratando de consultar la información de las ciudades con el filtro deseado, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CIUDADES = "Se ha presentado un problema inesperado tratando de consultar la información de las ciudades, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CIUDAD_POR_ID = "Se ha presentado un problema inesperado tratando de consultar la información de la ciudad, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
	}

	public static final class TipoDocumentoFachadaImpl {

		private TipoDocumentoFachadaImpl() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_TIPOS_DOCUMENTO_CON_FILTRO = "Se ha presentado un problema inesperado tratando de consultar la información de los tipos de documento con el filtro deseado, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_TIPOS_DOCUMENTO = "Se ha presentado un problema inesperado tratando de consultar la información de los tipos de documento, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_TIPO_DOCUMENTO_POR_ID = "Se ha presentado un problema inesperado tratando de consultar la información del tipo de documento, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
	}

	public static final class PrefijoFachadaImpl {

		private PrefijoFachadaImpl() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PREFIJOS_CON_FILTRO = "Se ha presentado un problema inesperado tratando de consultar la información de los prefijos con el filtro deseado, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PREFIJOS = "Se ha presentado un problema inesperado tratando de consultar la información de los prefijos, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PREFIJO_POR_ID = "Se ha presentado un problema inesperado tratando de consultar la información del prefijo, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
	}

	public static final class SedeFachadaImpl {

		private SedeFachadaImpl() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_SEDE = "Se ha presentado un problema inesperado tratando de registrar la información de la nueva sede, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_MODIFICANDO_SEDE = "Se ha presentado un problema inesperado tratando de modificar la información de la sede, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_SEDES_CON_FILTRO = "Se ha presentado un problema inesperado tratando de consultar la información de las sedes con el filtro deseado, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_SEDES = "Se ha presentado un problema inesperado tratando de consultar la información de las sedes, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_SEDE_POR_ID = "Se ha presentado un problema inesperado tratando de consultar la información de la sede, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
	}

	public static final class PersonaFachadaImpl {

		private PersonaFachadaImpl() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_PERSONA = "Se ha presentado un problema inesperado tratando de registrar la información de la nueva persona, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_MODIFICANDO_PERSONA = "Se ha presentado un problema inesperado tratando de modificar la información de la persona, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_DANDO_DE_BAJA_PERSONA = "Se ha presentado un problema inesperado tratando de dar de baja la información de la persona, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PERSONAS_CON_FILTRO = "Se ha presentado un problema inesperado tratando de consultar la información de las personas con el filtro deseado, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PERSONAS = "Se ha presentado un problema inesperado tratando de consultar la información de las personas, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PERSONA_POR_ID = "Se ha presentado un problema inesperado tratando de consultar la información de la persona, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
	}

	public static final class ClienteFachadaImpl {

		private ClienteFachadaImpl() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_CLIENTE = "Se ha presentado un problema inesperado tratando de registrar la información del nuevo cliente, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_DANDO_DE_BAJA_CLIENTE = "Se ha presentado un problema inesperado tratando de dar de baja la información del cliente, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTES_CON_FILTRO = "Se ha presentado un problema inesperado tratando de consultar la información de los clientes con el filtro deseado, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTES = "Se ha presentado un problema inesperado tratando de consultar la información de los clientes, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTE_POR_ID = "Se ha presentado un problema inesperado tratando de consultar la información del cliente, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
	}

	public static final class EmpleadoFachadaImpl {

		private EmpleadoFachadaImpl() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_EMPLEADO = "Se ha presentado un problema inesperado tratando de registrar la información del nuevo empleado, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_MODIFICANDO_EMPLEADO = "Se ha presentado un problema inesperado tratando de modificar la información del empleado, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_DANDO_DE_BAJA_EMPLEADO = "Se ha presentado un problema inesperado tratando de dar de baja la información del empleado, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_EMPLEADOS_CON_FILTRO = "Se ha presentado un problema inesperado tratando de consultar la información de los empleados con el filtro deseado, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_EMPLEADOS = "Se ha presentado un problema inesperado tratando de consultar la información de los empleados, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_EMPLEADO_POR_ID = "Se ha presentado un problema inesperado tratando de consultar la información del empleado, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
	}

	public static final class EstadoProcesoCompraFachadaImpl {

		private EstadoProcesoCompraFachadaImpl() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_ESTADO_PROCESO_COMPRA = "Se ha presentado un problema inesperado tratando de registrar la información del nuevo estado de proceso de compra, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADOS_PROCESO_COMPRA_CON_FILTRO = "Se ha presentado un problema inesperado tratando de consultar la información de los estados de proceso de compra con el filtro deseado, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADOS_PROCESO_COMPRA = "Se ha presentado un problema inesperado tratando de consultar la información de los estados de proceso de compra, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADO_PROCESO_COMPRA_POR_ID = "Se ha presentado un problema inesperado tratando de consultar la información del estado de proceso de compra, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
	}

	public static final class ProcesoCompraFachadaImpl {

		private ProcesoCompraFachadaImpl() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_PROCESO_COMPRA = "Se ha presentado un problema inesperado tratando de registrar la información del nuevo proceso de compra, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PROCESOS_COMPRA_CON_FILTRO = "Se ha presentado un problema inesperado tratando de consultar la información de los procesos de compra con el filtro deseado, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PROCESOS_COMPRA = "Se ha presentado un problema inesperado tratando de consultar la información de los procesos de compra, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PROCESO_COMPRA_POR_ID = "Se ha presentado un problema inesperado tratando de consultar la información del proceso de compra, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
	}

	public static final class ClienteRegistradoNFachadaImpl {
		private ClienteRegistradoNFachadaImpl() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_CLIENTE_NATURAL = "Se ha presentado un problema inesperado tratando de registrar la información del nuevo cliente natural, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTE_NATURALS = "Se ha presentado un problema inesperado tratando de consultar la información de los clientes naturales, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
	}

	public static final class ClienteRegistradoJFachadaImpl {
		private ClienteRegistradoJFachadaImpl() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_CLIENTE_JURIDICO = "Se ha presentado un problema inesperado tratando de registrar la información del nuevo cliente jurídico, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTE_JURIDICOS = "Se ha presentado un problema inesperado tratando de consultar la información de los clientes jurídicos, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
	}

	public static final class SedeNegocioImpl {
		private SedeNegocioImpl() {
		}

		public static final String SEDE_YA_EXISTE_CON_EL_MISMO_NOMBRE_DE_SEDE_A_CREAR = "Ya existe otra sede con el nombre con el cual se desea crear la sede deseada";
		public static final String SEDE_YA_EXISTE_CON_EL_MISMO_NIT_DE_SEDE_A_CREAR = "Ya existe otra sede con el NIT con el cual se desea crear la sede deseada";
		public static final String SEDE_YA_EXISTE_CON_LA_MISMA_DIRECCION_DE_SEDE_A_CREAR = "Ya existe otra sede con la dirección con la cual se desea crear la sede deseada";

		public static final String CIUDAD_SEDE_OBLIGATORIA = "La ciudad de la sede es obligatoria para llevar a cabo la operación deseada";

		public static final String NOMBRE_SEDE_OBLIGATORIO = "El nombre de la sede es obligatorio para llevar a cabo la operación deseada";
		public static final String LONGITUD_NOMBRE_SEDE_NO_VALIDA = "La longitud del nombre de la sede no es válida, asegúrese de que esté entre 1 y 50";
		public static final String FORMATO_NOMBRE_SEDE_NO_VALIDO = "El formato del nombre de la sede no es válido, asegúrese de que solo posea letras de la A a la Z mayúsculas y minúsculas y espacios";

		public static final String NIT_SEDE_OBLIGATORIO = "El NIT de la sede es obligatorio para llevar a cabo la operación deseada";
		public static final String LONGITUD_NIT_SEDE_NO_VALIDA = "La longitud del NIT de la sede no es válida, asegúrese de que esté entre 9 y 12 caracteres";
		public static final String FORMATO_NIT_SEDE_NO_VALIDO = "El formato del NIT de la sede no es válido, asegúrese de que posea entre 9 y 10 dígitos y, opcionalmente, el dígito de verificación separado por un guion (ejemplo: 900123456-7)";

		public static final String DIRECCION_SEDE_OBLIGATORIA = "La dirección de la sede es obligatoria para llevar a cabo la operación deseada";
		public static final String LONGITUD_DIRECCION_SEDE_NO_VALIDA = "La longitud de la dirección de la sede no es válida, asegúrese de que esté entre 5 y 100";
		public static final String FORMATO_DIRECCION_SEDE_NO_VALIDO = "El formato de la dirección de la sede no es válido, asegúrese de que solo posea letras, números, espacios y los símbolos # - . , °";
	}

	public static final class EmpleadoNegocioImpl {
		private EmpleadoNegocioImpl() {
		}

		public static final String EMPLEADO_YA_EXISTE_CON_LA_MISMA_PERSONA_DE_EMPLEADO_A_CREAR = "Ya existe un empleado registrado con la persona con la cual se desea crear el empleado deseado";

		public static final String SEDE_EMPLEADO_OBLIGATORIA = "La sede del empleado es obligatoria para llevar a cabo la operación deseada";
		public static final String SEDE_EMPLEADO_NO_EXISTE = "La sede asignada al empleado no existe, asegúrese de seleccionar una sede registrada";
		public static final String SEDE_EMPLEADO_NO_ACTIVA = "La sede asignada al empleado no se encuentra activa, asegúrese de seleccionar una sede abierta al público";

		public static final String PERSONA_EMPLEADO_OBLIGATORIA = "La persona del empleado es obligatoria para llevar a cabo la operación deseada";
		public static final String PERSONA_EMPLEADO_NO_EXISTE = "La persona asignada al empleado no existe, asegúrese de registrar primero la persona";
	}

	public static final class EstadoProcesoCompraNegocioImpl {
		private EstadoProcesoCompraNegocioImpl() {
		}

		public static final String ESTADO_PROCESO_COMPRA_YA_EXISTE_CON_EL_MISMO_CODIGO_DE_ESTADO_A_CREAR = "Ya existe otro estado de proceso de compra con el código con el cual se desea crear el estado deseado";
		public static final String ESTADO_PROCESO_COMPRA_YA_EXISTE_CON_EL_MISMO_NOMBRE_DE_ESTADO_A_CREAR = "Ya existe otro estado de proceso de compra con el nombre con el cual se desea crear el estado deseado";

		public static final String CODIGO_ESTADO_PROCESO_COMPRA_OBLIGATORIO = "El código del estado de proceso de compra es obligatorio para llevar a cabo la operación deseada";
		public static final String LONGITUD_CODIGO_ESTADO_PROCESO_COMPRA_NO_VALIDA = "La longitud del código del estado de proceso de compra no es válida, asegúrese de que esté entre 2 y 20";
		public static final String FORMATO_CODIGO_ESTADO_PROCESO_COMPRA_NO_VALIDO = "El formato del código del estado de proceso de compra no es válido, asegúrese de que solo posea letras mayúsculas de la A a la Z, números y guion bajo (ejemplo: EP)";

		public static final String NOMBRE_ESTADO_PROCESO_COMPRA_OBLIGATORIO = "El nombre del estado de proceso de compra es obligatorio para llevar a cabo la operación deseada";
		public static final String LONGITUD_NOMBRE_ESTADO_PROCESO_COMPRA_NO_VALIDA = "La longitud del nombre del estado de proceso de compra no es válida, asegúrese de que esté entre 1 y 50";
		public static final String FORMATO_NOMBRE_ESTADO_PROCESO_COMPRA_NO_VALIDO = "El formato del nombre del estado de proceso de compra no es válido, asegúrese de que solo posea letras (con tildes o ñ) y espacios";
	}

	public static final class ClienteNegocioImpl {
		private ClienteNegocioImpl() {
		}

		public static final String CLIENTE_ESTA_SIENDO_UTILIZADO_POR_CLIENTE_REGISTRADO = "No es posible eliminar el cliente deseado, debido a que se encuentra asociado a un cliente registrado";
		public static final String CLIENTE_ESTA_SIENDO_UTILIZADO_POR_CLIENTE_NO_REGISTRADO = "No es posible eliminar el cliente deseado, debido a que se encuentra asociado a un cliente no registrado";
		public static final String CLIENTE_ESTA_SIENDO_UTILIZADO_POR_PROCESO_COMPRA = "No es posible eliminar el cliente deseado, debido a que se encuentra asociado a uno o más procesos de compra";
	}

	public static final class ProcesoCompraNegocioImpl {
		private ProcesoCompraNegocioImpl() {
		}

		public static final String CLIENTE_YA_TIENE_PROCESO_COMPRA_CON_LA_MISMA_FECHA_INICIO = "El cliente ya tiene un proceso de compra registrado con la misma fecha y hora de inicio";
		public static final String EMPLEADO_YA_TIENE_PROCESO_COMPRA_CON_LA_MISMA_FECHA_INICIO = "El empleado ya está atendiendo un proceso de compra con la misma fecha y hora de inicio";
		public static final String CLIENTE_YA_TIENE_PROCESO_COMPRA_CON_LA_MISMA_FECHA_ACTUALIZACION = "El cliente ya tiene un proceso de compra actualizado en la misma fecha y hora de actualización";
		public static final String EMPLEADO_YA_TIENE_PROCESO_COMPRA_CON_LA_MISMA_FECHA_ACTUALIZACION = "El empleado ya está atendiendo un proceso de compra actualizado en la misma fecha y hora de actualización";

		public static final String CLIENTE_PROCESO_COMPRA_OBLIGATORIO = "El cliente del proceso de compra es obligatorio para llevar a cabo la operación deseada";
		public static final String CLIENTE_PROCESO_COMPRA_NO_EXISTE = "El cliente asignado al proceso de compra no existe, asegúrese de seleccionar un cliente registrado";

		public static final String EMPLEADO_PROCESO_COMPRA_OBLIGATORIO = "El empleado que atiende el proceso de compra es obligatorio para llevar a cabo la operación deseada";
		public static final String EMPLEADO_PROCESO_COMPRA_NO_EXISTE = "El empleado asignado al proceso de compra no existe, asegúrese de seleccionar un empleado registrado";
		public static final String EMPLEADO_PROCESO_COMPRA_NO_ACTIVO = "El empleado asignado al proceso de compra no se encuentra activo, asegúrese de seleccionar un empleado activo";

		public static final String ESTADO_INICIAL_PROCESO_COMPRA_NO_CONFIGURADO = "No es posible registrar el proceso de compra porque no existe el estado inicial En proceso (código EP), por favor contacte al administrador de la aplicación";
		public static final String CLIENTE_GENERICO_NO_CONFIGURADO = "No es posible registrar el proceso de compra con un cliente no registrado porque el cliente genérico (Consumidor final) no está configurado en la base de datos, por favor contacte al administrador de la aplicación";
	}

	public static final class ClienteRegistradoNNegocioImpl {
		private ClienteRegistradoNNegocioImpl() {
		}

		public static final String PERSONA_CLIENTE_NATURAL_NO_EXISTE = "La persona seleccionada para el cliente natural no existe, asegúrese de escoger una persona registrada o de ingresar los datos de una nueva";
		public static final String PERSONA_YA_ES_CLIENTE_NATURAL = "La persona seleccionada ya está registrada como cliente natural, búsquela en la lista de clientes registrados";
	}

	public static final class ClienteRegistradoJNegocioImpl {
		private ClienteRegistradoJNegocioImpl() {
		}

		public static final String CLIENTE_JURIDICO_YA_EXISTE_CON_EL_MISMO_NIT = "Ya existe un cliente jurídico registrado con el NIT con el cual se desea crear el cliente deseado";
		public static final String CLIENTE_JURIDICO_YA_EXISTE_CON_LA_MISMA_RAZON_SOCIAL = "Ya existe un cliente jurídico registrado con la razón social con la cual se desea crear el cliente deseado";

		public static final String NIT_CLIENTE_JURIDICO_OBLIGATORIO = "El NIT del cliente jurídico es obligatorio para llevar a cabo la operación deseada";
		public static final String LONGITUD_NIT_CLIENTE_JURIDICO_NO_VALIDA = "La longitud del NIT del cliente jurídico no es válida, asegúrese de que esté entre 9 y 12 caracteres";
		public static final String FORMATO_NIT_CLIENTE_JURIDICO_NO_VALIDO = "El formato del NIT del cliente jurídico no es válido, asegúrese de que posea entre 9 y 10 dígitos y, opcionalmente, el dígito de verificación separado por un guion (ejemplo: 900123456-7)";

		public static final String RAZON_SOCIAL_CLIENTE_JURIDICO_OBLIGATORIA = "La razón social del cliente jurídico es obligatoria para llevar a cabo la operación deseada";
		public static final String LONGITUD_RAZON_SOCIAL_CLIENTE_JURIDICO_NO_VALIDA = "La longitud de la razón social del cliente jurídico no es válida, asegúrese de que esté entre 2 y 100";
		public static final String FORMATO_RAZON_SOCIAL_CLIENTE_JURIDICO_NO_VALIDO = "El formato de la razón social del cliente jurídico no es válido, asegúrese de que solo posea letras, números, espacios y los símbolos . , & -";

		public static final String PREFIJO_CLIENTE_JURIDICO_OBLIGATORIO = "El prefijo telefónico del cliente jurídico es obligatorio para llevar a cabo la operación deseada";
		public static final String PREFIJO_CLIENTE_JURIDICO_NO_EXISTE = "El prefijo telefónico seleccionado para el cliente jurídico no existe";

		public static final String TELEFONO_CLIENTE_JURIDICO_OBLIGATORIO = "El teléfono del cliente jurídico es obligatorio para llevar a cabo la operación deseada";
		public static final String LONGITUD_TELEFONO_CLIENTE_JURIDICO_NO_VALIDA = "La longitud del teléfono del cliente jurídico no es válida, asegúrese de que esté entre 7 y 15 dígitos";
		public static final String FORMATO_TELEFONO_CLIENTE_JURIDICO_NO_VALIDO = "El formato del teléfono del cliente jurídico no es válido, asegúrese de que solo posea números";

		public static final String CORREO_CLIENTE_JURIDICO_OBLIGATORIO = "El correo del cliente jurídico es obligatorio para llevar a cabo la operación deseada";
		public static final String LONGITUD_CORREO_CLIENTE_JURIDICO_NO_VALIDA = "La longitud del correo del cliente jurídico no es válida, asegúrese de que esté entre 6 y 100";
		public static final String FORMATO_CORREO_CLIENTE_JURIDICO_NO_VALIDO = "El formato del correo del cliente jurídico no es válido, asegúrese de que tenga una estructura como nombre@dominio.com";
	}

	public static final class PersonaNegocioImpl {

		private PersonaNegocioImpl() {
		}

		public static final String PERSONA_YA_EXISTE_CON_EL_MISMO_NUMERO_DOCUMENTO_DE_PERSONA_A_CREAR = "Ya existe otra persona con el mismo número de documento";
		public static final String PERSONA_YA_EXISTE_CON_EL_MISMO_TELEFONO_DE_PERSONA_A_CREAR = "Ya existe otra persona con el mismo teléfono";
		public static final String PERSONA_YA_EXISTE_CON_EL_MISMO_CORREO_DE_PERSONA_A_CREAR = "Ya existe otra persona con el mismo correo";
		public static final String TIPO_DOCUMENTO_PERSONA_OBLIGATORIO = "El tipo de documento de la persona es obligatorio";
		public static final String NUMERO_DOCUMENTO_PERSONA_OBLIGATORIO = "El número de documento de la persona es obligatorio";
		public static final String LONGITUD_NUMERO_DOCUMENTO_PERSONA_NO_VALIDA = "La longitud del número de documento debe estar entre 5 y 15 caracteres";
		public static final String FORMATO_NUMERO_DOCUMENTO_PERSONA_NO_VALIDO = "El número de documento solo puede contener letras y números";
		public static final String NOMBRE_PERSONA_OBLIGATORIO = "El nombre de la persona es obligatorio";
		public static final String LONGITUD_NOMBRE_PERSONA_NO_VALIDA = "La longitud del nombre debe estar entre 2 y 50 caracteres";
		public static final String FORMATO_NOMBRE_PERSONA_NO_VALIDO = "El nombre solo puede contener letras y espacios";
		public static final String APELLIDO_PERSONA_OBLIGATORIO = "El apellido de la persona es obligatorio";
		public static final String LONGITUD_APELLIDO_PERSONA_NO_VALIDA = "La longitud del apellido debe estar entre 2 y 50 caracteres";
		public static final String FORMATO_APELLIDO_PERSONA_NO_VALIDO = "El apellido solo puede contener letras y espacios";
		public static final String TELEFONO_PERSONA_OBLIGATORIO = "El teléfono de la persona es obligatorio";
		public static final String LONGITUD_TELEFONO_PERSONA_NO_VALIDA = "La longitud del teléfono debe estar entre 7 y 15 dígitos";
		public static final String FORMATO_TELEFONO_PERSONA_NO_VALIDO = "El teléfono solo puede contener números";
		public static final String CORREO_PERSONA_OBLIGATORIO = "El correo electrónico de la persona es obligatorio";
		public static final String LONGITUD_CORREO_PERSONA_NO_VALIDA = "La longitud del correo debe estar entre 6 y 100 caracteres";
		public static final String FORMATO_CORREO_PERSONA_NO_VALIDO = "El formato del correo electrónico no es válido";
		public static final String PREFIJO_PERSONA_OBLIGATORIO = "El prefijo telefónico de la persona es obligatorio para llevar a cabo la operación deseada";
	}

	public static final class UtilSQL {

		private UtilSQL() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se ha presentado un problema tratando de validar si la conexión contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada estaba abierta o no abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se ha presentado un problema NO CONTROLADO tratando de validar si la conexión contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada estaba abierta o no abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = "Se ha presentado un problema tratando de validar si la conexión contra la fuente de información estaba en un estado consistente al tratar de llevar a cabo la operación deseada, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = "Se ha presentado un problema NO CONTROLADO tratando de validar si la conexión contra la fuente de información estaba en un estado consistente al tratar de llevar a cabo la operación deseada, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL = "No es posible continuar con la operación deseada, debido a que la conexión contra la fuente de información se encuentra en un estado inconsistente, porque está cerrada, está vacía o porque la transacción ya fue iniciada, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_INICIANDO_TRANSACCION_SQL = "Se ha presentado un problema tratando de iniciar la transacción contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_INICIANDO_TRANSACCION_SQL = "Se ha presentado un problema NO CONTROLADO tratando de iniciar la transacción contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CONFIRMAR_TRANSACCION_SQL = "No es posible continuar con la operación deseada, debido a que la conexión contra la fuente de información se encuentra en un estado inconsistente, porque está cerrada, está vacía o porque la transacción no fue iniciada, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONFIRMANDO_TRANSACCION_SQL = "Se ha presentado un problema tratando de confirmar la transacción contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONFIRMANDO_TRANSACCION_SQL = "Se ha presentado un problema NO CONTROLADO tratando de confirmar la transacción contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CANCELAR_TRANSACCION_SQL = "No es posible continuar con la operación deseada, debido a que la conexión contra la fuente de información se encuentra en un estado inconsistente, porque está cerrada, está vacía o porque la transacción no fue iniciada, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CANCELANDO_TRANSACCION_SQL = "Se ha presentado un problema tratando de cancelar la transacción contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CANCELANDO_TRANSACCION_SQL = "Se ha presentado un problema NO CONTROLADO tratando de cancelar la transacción contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CERRAR_CONEXION_SQL = "No es posible continuar con la operación deseada, debido a que la conexión contra la fuente de información se encuentra en un estado inconsistente, porque está vacía o porque ya se encontraba cerrada, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CERRANDO_CONEXION_SQL = "Se ha presentado un problema tratando de cerrar la conexión contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CERRANDO_CONEXION_SQL = "Se ha presentado un problema NO CONTROLADO tratando de cerrar la conexión contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CONTINUAR_CONEXION_SQL_NO_ESTA_ABIERTA = "No es posible continuar con la operación deseada, debido a que la conexión contra la fuente de información en la cual se iba a tratar de llevar a cabo dicha operación se encuentra en un estado inconsistente, porque está cerrada o está vacía, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
	}

	public static final class DAOFactory {

		private DAOFactory() {
		}

		public static final String USUARIO_ERROR_FUENTE_INFORMACION_NO_HABILITADA = "La fuente de información deseada que se solicitó para llevar a cabo la operación no está habilitada, por favor contacte al administrador de la aplicación";
	}

	public static final class PostgreSqlDaoFactory {

		private PostgreSqlDaoFactory() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_ABRIENDO_CONEXION_POSTGRESQL = "Se ha presentado un problema tratando de abrir la conexión contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ABRIENDO_CONEXION_POSTGRESQL = "Se ha presentado un problema NO CONTROLADO tratando de abrir la conexión contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
	}

	public static final class PoolConexionesPostgreSql {

		private PoolConexionesPostgreSql() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_POOL_CONEXIONES_POSTGRESQL = "Se ha presentado un problema tratando de preparar las conexiones contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_CONFIGURACION_CONEXION_POSTGRESQL_INCOMPLETA = "No es posible conectarse con la fuente de información porque su configuración está incompleta, por favor contacte al administrador de la aplicación";
		public static final String TECNICO_ERROR_VARIABLE_ENTORNO_NO_DEFINIDA = "No está definida o está vacía la variable de entorno: ";
	}
	
	public static final class FiltroSql {

		private FiltroSql() {
		}

		public static final String TECNICO_ERROR_LIMITE_INFERIOR_MAYOR_QUE_SUPERIOR = "El límite inferior no puede ser mayor al superior en ";
		public static final String TECNICO_ERROR_FECHA_INICIAL_POSTERIOR_A_FINAL = "La fecha inicial no puede ser posterior a la final en ";
	}
}