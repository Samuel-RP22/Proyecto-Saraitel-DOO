package co.com.saraitel.gestionsaraitel.transversal.catalogo;

public final class CatalogoMensajesSql {

	private CatalogoMensajesSql() {
	}

	public static final class AdministradorPostgreSqlDAO {

		private AdministradorPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_ADMINISTRADOR = "Se ha presentado un problema tratando de registrar la información del administrador. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_ADMINISTRADOR = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del administrador. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_ADMINISTRADORES = "Se ha presentado un problema tratando de consultar la información de los administradores. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ADMINISTRADORES = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los administradores. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"Administrador\" (\"id\", \"Empleado_id\") VALUES (?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Empleado_id\" FROM saraitel.\"Administrador\"";
	}

	public static final class AplicacionSaldoPostgreSqlDAO {

		private AplicacionSaldoPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_APLICACION_DE_SALDO = "Se ha presentado un problema tratando de registrar la información de la aplicación de saldo. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_APLICACION_DE_SALDO = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información de la aplicación de saldo. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_APLICACION_DE_SALDO = "Se ha presentado un problema tratando de consultar la información de la aplicación de saldo. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_APLICACION_DE_SALDO = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de la aplicación de saldo. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_APLICACIONES_DE_SALDO = "Se ha presentado un problema tratando de consultar la información de las aplicaciones de saldo. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_APLICACIONES_DE_SALDO = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de las aplicaciones de saldo. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"AplicacionSaldo\" (\"id\", \"SaldoFavor_id\", \"Pago_id\", \"ValorAplicado\") VALUES (?, ?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"SaldoFavor_id\", \"Pago_id\", \"ValorAplicado\" FROM saraitel.\"AplicacionSaldo\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"SaldoFavor_id\", \"Pago_id\", \"ValorAplicado\" FROM saraitel.\"AplicacionSaldo\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"SaldoFavor_id\", \"Pago_id\", \"ValorAplicado\" FROM saraitel.\"AplicacionSaldo\"";
	}

	public static final class CategoriaPostgreSqlDAO {

		private CategoriaPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_CATEGORIA = "Se ha presentado un problema tratando de registrar la información de la categoría. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_CATEGORIA = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información de la categoría. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_CATEGORIAS = "Se ha presentado un problema tratando de consultar la información de las categorías. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CATEGORIAS = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de las categorías. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_CATEGORIA = "Se ha presentado un problema tratando de modificar la información de la categoría. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_CATEGORIA = "Se ha presentado un problema NO CONTROLADO tratando de modificar la información de la categoría. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ELIMINANDO_CATEGORIA = "Se ha presentado un problema tratando de eliminar la información de la categoría. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ELIMINANDO_CATEGORIA = "Se ha presentado un problema NO CONTROLADO tratando de eliminar la información de la categoría. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_INSERTAR = "INSERT INTO saraitel.\"Categoria\" (\"id\", \"Nombre\", \"CategoriaPadre_id\", \"Nivel\") VALUES (?, ?, ?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Nombre\", \"CategoriaPadre_id\", \"Nivel\" FROM saraitel.\"Categoria\"";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"Categoria\" SET \"Nombre\" = ?, \"CategoriaPadre_id\" = ?, \"Nivel\" = ? WHERE \"id\" = ?";
		public static final String SQL_ELIMINAR = "DELETE FROM saraitel.\"Categoria\" WHERE \"id\" = ?";
	}

	public static final class CiudadPostgreSqlDAO {

		private CiudadPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_CIUDADES = "Se ha presentado un problema tratando de consultar la información de las ciudades. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CIUDADES = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de las ciudades. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Departamento_id\", \"Nombre\" FROM saraitel.\"Ciudad\"";
	}

	public static final class ClienteNoRegistradoPostgreSqlDAO {

		private ClienteNoRegistradoPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_CLIENTE_NO_REGISTRADO = "Se ha presentado un problema tratando de registrar la información del cliente no registrado. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_CLIENTE_NO_REGISTRADO = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del cliente no registrado. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_CLIENTES_NO_REGISTRADOS = "Se ha presentado un problema tratando de consultar la información de los clientes no registrados. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTES_NO_REGISTRADOS = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los clientes no registrados. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_INSERTAR = "INSERT INTO saraitel.\"ClienteNoRegistrado\" (\"id\", \"Cliente_id\", \"Nombre\", \"Apellido\", \"NumeroDocumento\") VALUES (?, ?, ?, ?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Cliente_id\", \"Nombre\", \"Apellido\", \"NumeroDocumento\" FROM saraitel.\"ClienteNoRegistrado\"";
	}

	public static final class ClientePostgreSqlDAO {

		private ClientePostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_CLIENTE = "Se ha presentado un problema tratando de registrar la información del cliente. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_CLIENTE = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del cliente. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_CLIENTES = "Se ha presentado un problema tratando de consultar la información de los clientes. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTES = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los clientes. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ELIMINANDO_CLIENTE = "Se ha presentado un problema tratando de eliminar la información del cliente. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ELIMINANDO_CLIENTE = "Se ha presentado un problema NO CONTROLADO tratando de eliminar la información del cliente. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_INSERTAR = "INSERT INTO saraitel.\"Cliente\" (\"id\", \"EsClienteRegistrado\") VALUES (?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"EsClienteRegistrado\" FROM saraitel.\"Cliente\"";
		public static final String SQL_ELIMINAR = "DELETE FROM saraitel.\"Cliente\" WHERE \"id\" = ?";
	}

	public static final class ClienteRegistradoJPostgreSqlDAO {

		private ClienteRegistradoJPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_CLIENTE_REGISTRADO_JURIDICO = "Se ha presentado un problema tratando de registrar la información del cliente registrado jurídico. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_CLIENTE_REGISTRADO_JURIDICO = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del cliente registrado jurídico. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_CLIENTES_REGISTRADOS_JURIDICOS = "Se ha presentado un problema tratando de consultar la información de los clientes registrados jurídicos. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTES_REGISTRADOS_JURIDICOS = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los clientes registrados jurídicos. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_CLIENTE_REGISTRADO_JURIDICO = "Se ha presentado un problema tratando de modificar la información del cliente registrado jurídico. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_CLIENTE_REGISTRADO_JURIDICO = "Se ha presentado un problema NO CONTROLADO tratando de modificar la información del cliente registrado jurídico. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ELIMINANDO_CLIENTE_REGISTRADO_JURIDICO = "Se ha presentado un problema tratando de eliminar la información del cliente registrado jurídico. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ELIMINANDO_CLIENTE_REGISTRADO_JURIDICO = "Se ha presentado un problema NO CONTROLADO tratando de eliminar la información del cliente registrado jurídico. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_INSERTAR = "INSERT INTO saraitel.\"ClienteRegistradoJ\" (\"id\", \"ClienteRegistrado_id\", \"Prefijo_id\", \"Telefono\", \"Nit\", \"RazonSocial\", \"Correo\", \"TelefonoConfirmado\", \"CorreoConfirmado\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		public static final String SQL_CONSULTAR = "SELECT * FROM (SELECT j.\"id\", j.\"ClienteRegistrado_id\", j.\"Prefijo_id\", j.\"Telefono\", j.\"Nit\", j.\"RazonSocial\", j.\"Correo\", j.\"TelefonoConfirmado\", j.\"CorreoConfirmado\", cr.\"Cliente_id\" FROM saraitel.\"ClienteRegistradoJ\" j JOIN saraitel.\"ClienteRegistrado\" cr ON cr.\"id\" = j.\"ClienteRegistrado_id\") AS clientes_juridicos";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"ClienteRegistradoJ\" SET \"ClienteRegistrado_id\" = ?, \"Prefijo_id\" = ?, \"Telefono\" = ?, \"Nit\" = ?, \"RazonSocial\" = ?, \"Correo\" = ?, \"TelefonoConfirmado\" = ?, \"CorreoConfirmado\" = ? WHERE \"id\" = ?";
		public static final String SQL_ELIMINAR = "DELETE FROM saraitel.\"ClienteRegistradoJ\" WHERE \"id\" = ?";
	}

	public static final class ClienteRegistradoNPostgreSqlDAO {

		private ClienteRegistradoNPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_CLIENTE_REGISTRADO = "Se ha presentado un problema tratando de registrar la información del cliente registrado. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_CLIENTE_REGISTRADO = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del cliente registrado. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_CLIENTES_REGISTRADOS = "Se ha presentado un problema tratando de consultar la información de los clientes registrados. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTES_REGISTRADOS = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los clientes registrados. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ELIMINANDO_CLIENTE_REGISTRADO = "Se ha presentado un problema tratando de eliminar la información del cliente registrado. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ELIMINANDO_CLIENTE_REGISTRADO = "Se ha presentado un problema NO CONTROLADO tratando de eliminar la información del cliente registrado. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_INSERTAR = "INSERT INTO saraitel.\"ClienteRegistradoN\" (\"id\", \"ClienteRegistrado_id\", \"Persona_id\") VALUES (?, ?, ?)";
		public static final String SQL_CONSULTAR = "SELECT * FROM (SELECT n.\"id\", n.\"ClienteRegistrado_id\", n.\"Persona_id\", cr.\"Cliente_id\", p.\"TipoDocumento_id\", p.\"Prefijo_id\", p.\"NumeroDocumento\", p.\"Telefono\", p.\"Nombre\", p.\"Apellido\", p.\"Correo\" FROM saraitel.\"ClienteRegistradoN\" n JOIN saraitel.\"ClienteRegistrado\" cr ON cr.\"id\" = n.\"ClienteRegistrado_id\" JOIN saraitel.\"Persona\" p ON p.\"id\" = n.\"Persona_id\") AS clientes_naturales";
		public static final String SQL_ELIMINAR = "DELETE FROM saraitel.\"ClienteRegistradoN\" WHERE \"id\" = ?";
	}

	public static final class ClienteRegistradoPostgreSqlDAO {

		private ClienteRegistradoPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_CLIENTE_REGISTRADO = "Se ha presentado un problema tratando de registrar la información del cliente registrado. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_CLIENTE_REGISTRADO = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del cliente registrado. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_CLIENTES_REGISTRADOS = "Se ha presentado un problema tratando de consultar la información de los clientes registrados. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTES_REGISTRADOS = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los clientes registrados. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ELIMINANDO_CLIENTE_REGISTRADO = "Se ha presentado un problema tratando de eliminar la información del cliente registrado. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ELIMINANDO_CLIENTE_REGISTRADO = "Se ha presentado un problema NO CONTROLADO tratando de eliminar la información del cliente registrado. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_INSERTAR = "INSERT INTO saraitel.\"ClienteRegistrado\" (\"id\", \"Cliente_id\") VALUES (?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Cliente_id\" FROM saraitel.\"ClienteRegistrado\"";
		public static final String SQL_ELIMINAR = "DELETE FROM saraitel.\"ClienteRegistrado\" WHERE \"id\" = ?";
	}

	public static final class CompraPostgreSqlDAO {

		private CompraPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_COMPRA = "Se ha presentado un problema tratando de registrar la información de la compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_COMPRA = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información de la compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_COMPRA = "Se ha presentado un problema tratando de consultar la información de la compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_COMPRA = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de la compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_COMPRAS = "Se ha presentado un problema tratando de consultar la información de las compras. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_COMPRAS = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de las compras. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"Compra\" (\"id\", \"ProcesoCompra_id\", \"EstadoCompra_id\", \"FechaCompra\") VALUES (?, ?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"ProcesoCompra_id\", \"EstadoCompra_id\", \"FechaCompra\" FROM saraitel.\"Compra\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"ProcesoCompra_id\", \"EstadoCompra_id\", \"FechaCompra\" FROM saraitel.\"Compra\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"ProcesoCompra_id\", \"EstadoCompra_id\", \"FechaCompra\" FROM saraitel.\"Compra\"";
	}

	public static final class DepartamentoPostgreSqlDAO {

		private DepartamentoPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_DEPARTAMENTOS = "Se ha presentado un problema tratando de consultar la información de los departamentos. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DEPARTAMENTOS = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los departamentos. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Pais_id\", \"Nombre\" FROM saraitel.\"Departamento\"";
	}

	public static final class DetalleCompraPostgreSqlDAO {

		private DetalleCompraPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_DETALLE_DE_LA_COMPRA = "Se ha presentado un problema tratando de registrar la información del detalle de la compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_DETALLE_DE_LA_COMPRA = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del detalle de la compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_DETALLE_DE_LA_COMPRA = "Se ha presentado un problema tratando de consultar la información del detalle de la compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DETALLE_DE_LA_COMPRA = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información del detalle de la compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_DETALLES_DE_LA_COMPRA = "Se ha presentado un problema tratando de consultar la información de los detalles de la compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DETALLES_DE_LA_COMPRA = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los detalles de la compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_DETALLE_DE_LA_COMPRA = "Se ha presentado un problema tratando de modificar la información del detalle de la compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_DETALLE_DE_LA_COMPRA = "Se ha presentado un problema NO CONTROLADO tratando de modificar la información del detalle de la compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ELIMINANDO_DETALLE_DE_LA_COMPRA = "Se ha presentado un problema tratando de eliminar la información del detalle de la compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ELIMINANDO_DETALLE_DE_LA_COMPRA = "Se ha presentado un problema NO CONTROLADO tratando de eliminar la información del detalle de la compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"DetalleCompra\" (\"id\", \"ProcesoCompra_id\", \"ProductoSede_id\", \"Cantidad\", \"PrecioUnitario\", \"Subtotal\") VALUES (?, ?, ?, ?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"ProcesoCompra_id\", \"ProductoSede_id\", \"Cantidad\", \"PrecioUnitario\", \"Subtotal\" FROM saraitel.\"DetalleCompra\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"ProcesoCompra_id\", \"ProductoSede_id\", \"Cantidad\", \"PrecioUnitario\", \"Subtotal\" FROM saraitel.\"DetalleCompra\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"ProcesoCompra_id\", \"ProductoSede_id\", \"Cantidad\", \"PrecioUnitario\", \"Subtotal\" FROM saraitel.\"DetalleCompra\"";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"DetalleCompra\" SET \"ProcesoCompra_id\" = ?, \"ProductoSede_id\" = ?, \"Cantidad\" = ?, \"PrecioUnitario\" = ?, \"Subtotal\" = ? WHERE \"id\" = ?";
		public static final String SQL_ELIMINAR = "DELETE FROM saraitel.\"DetalleCompra\" WHERE \"id\" = ?";
	}

	public static final class DetalleIngresoPostgreSqlDAO {

		private DetalleIngresoPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_DETALLE_DEL_INGRESO = "Se ha presentado un problema tratando de registrar la información del detalle del ingreso. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_DETALLE_DEL_INGRESO = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del detalle del ingreso. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_DETALLE_DEL_INGRESO = "Se ha presentado un problema tratando de consultar la información del detalle del ingreso. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DETALLE_DEL_INGRESO = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información del detalle del ingreso. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_DETALLES_DEL_INGRESO = "Se ha presentado un problema tratando de consultar la información de los detalles del ingreso. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DETALLES_DEL_INGRESO = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los detalles del ingreso. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_DETALLE_DEL_INGRESO = "Se ha presentado un problema tratando de modificar la información del detalle del ingreso. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_DETALLE_DEL_INGRESO = "Se ha presentado un problema NO CONTROLADO tratando de modificar la información del detalle del ingreso. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ELIMINANDO_DETALLE_DEL_INGRESO = "Se ha presentado un problema tratando de eliminar la información del detalle del ingreso. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ELIMINANDO_DETALLE_DEL_INGRESO = "Se ha presentado un problema NO CONTROLADO tratando de eliminar la información del detalle del ingreso. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"DetalleIngreso\" (\"id\", \"IngresoInventario_id\", \"ProductoSede_id\", \"Cantidad\", \"CostoUnitario\", \"Subtotal\") VALUES (?, ?, ?, ?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"IngresoInventario_id\", \"ProductoSede_id\", \"Cantidad\", \"CostoUnitario\", \"Subtotal\" FROM saraitel.\"DetalleIngreso\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"IngresoInventario_id\", \"ProductoSede_id\", \"Cantidad\", \"CostoUnitario\", \"Subtotal\" FROM saraitel.\"DetalleIngreso\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"IngresoInventario_id\", \"ProductoSede_id\", \"Cantidad\", \"CostoUnitario\", \"Subtotal\" FROM saraitel.\"DetalleIngreso\"";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"DetalleIngreso\" SET \"IngresoInventario_id\" = ?, \"ProductoSede_id\" = ?, \"Cantidad\" = ?, \"CostoUnitario\" = ?, \"Subtotal\" = ? WHERE \"id\" = ?";
		public static final String SQL_ELIMINAR = "DELETE FROM saraitel.\"DetalleIngreso\" WHERE \"id\" = ?";
	}

	public static final class DevolucionPostgreSqlDAO {

		private DevolucionPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_DEVOLUCION = "Se ha presentado un problema tratando de registrar la información de la devolución. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_DEVOLUCION = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información de la devolución. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_DEVOLUCION = "Se ha presentado un problema tratando de consultar la información de la devolución. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DEVOLUCION = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de la devolución. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_DEVOLUCIONES = "Se ha presentado un problema tratando de consultar la información de las devoluciones. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DEVOLUCIONES = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de las devoluciones. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_DEVOLUCION = "Se ha presentado un problema tratando de modificar la información de la devolución. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_DEVOLUCION = "Se ha presentado un problema NO CONTROLADO tratando de modificar la información de la devolución. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"Devolucion\" (\"id\", \"DetalleCompra_id\", \"Motivo_id\", \"FechaDevolucion\", \"Cantidad\", \"MontoDevolucion\", \"Estado\") VALUES (?, ?, ?, ?, ?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"DetalleCompra_id\", \"Motivo_id\", \"FechaDevolucion\", \"Cantidad\", \"MontoDevolucion\", \"Estado\" FROM saraitel.\"Devolucion\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"DetalleCompra_id\", \"Motivo_id\", \"FechaDevolucion\", \"Cantidad\", \"MontoDevolucion\", \"Estado\" FROM saraitel.\"Devolucion\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"DetalleCompra_id\", \"Motivo_id\", \"FechaDevolucion\", \"Cantidad\", \"MontoDevolucion\", \"Estado\" FROM saraitel.\"Devolucion\"";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"Devolucion\" SET \"DetalleCompra_id\" = ?, \"Motivo_id\" = ?, \"FechaDevolucion\" = ?, \"Cantidad\" = ?, \"MontoDevolucion\" = ?, \"Estado\" = ? WHERE \"id\" = ?";
	}

	public static final class EmpleadoPostgreSqlDAO {

		private EmpleadoPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_EMPLEADO = "Se ha presentado un problema tratando de registrar la información del empleado. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_EMPLEADO = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del empleado. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_EMPLEADOS = "Se ha presentado un problema tratando de consultar la información de los empleados. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_EMPLEADOS = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los empleados. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_EMPLEADO = "Se ha presentado un problema tratando de modificar la información del empleado. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_EMPLEADO = "Se ha presentado un problema NO CONTROLADO tratando de modificar la información del empleado. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"Empleado\" (\"id\", \"Sede_id\", \"Persona_id\", \"EsActivo\") VALUES (?, ?, ?, ?)";
		public static final String SQL_CONSULTAR = "SELECT * FROM (SELECT e.\"id\", e.\"Sede_id\", e.\"Persona_id\", e.\"EsActivo\", p.\"NumeroDocumento\", p.\"Nombre\", p.\"Apellido\", p.\"Correo\", s.\"Nombre\" AS \"NombreSede\" FROM saraitel.\"Empleado\" e JOIN saraitel.\"Persona\" p ON p.\"id\" = e.\"Persona_id\" JOIN saraitel.\"Sede\" s ON s.\"id\" = e.\"Sede_id\") AS empleados";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"Empleado\" SET \"Sede_id\" = ?, \"Persona_id\" = ?, \"EsActivo\" = ? WHERE \"id\" = ?";
	}

	public static final class EstadoCompraPostgreSqlDAO {

		private EstadoCompraPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_ESTADO_DE_COMPRA = "Se ha presentado un problema tratando de registrar la información del estado de compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_ESTADO_DE_COMPRA = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del estado de compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_ESTADO_DE_COMPRA = "Se ha presentado un problema tratando de consultar la información del estado de compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADO_DE_COMPRA = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información del estado de compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_ESTADOS_DE_COMPRA = "Se ha presentado un problema tratando de consultar la información de los estados de compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADOS_DE_COMPRA = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los estados de compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"EstadoCompra\" (\"id\", \"Codigo\", \"Nombre\") VALUES (?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoCompra\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoCompra\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoCompra\"";
	}

	public static final class EstadoInventarioPostgreSqlDAO {

		private EstadoInventarioPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_ESTADO_DEL_INVENTARIO = "Se ha presentado un problema tratando de registrar la información del estado del inventario. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_ESTADO_DEL_INVENTARIO = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del estado del inventario. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_ESTADO_DEL_INVENTARIO = "Se ha presentado un problema tratando de consultar la información del estado del inventario. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADO_DEL_INVENTARIO = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información del estado del inventario. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_ESTADOS_DEL_INVENTARIO = "Se ha presentado un problema tratando de consultar la información de los estados del inventario. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADOS_DEL_INVENTARIO = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los estados del inventario. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"EstadoInventario\" (\"id\", \"Codigo\", \"Nombre\") VALUES (?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoInventario\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoInventario\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoInventario\"";
	}

	public static final class EstadoProcesoCompraPostgreSqlDAO {

		private EstadoProcesoCompraPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_ESTADO_DEL_PROCESO_DE_COMPRA = "Se ha presentado un problema tratando de registrar la información del estado del proceso de compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_ESTADO_DEL_PROCESO_DE_COMPRA = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del estado del proceso de compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_ESTADO_DEL_PROCESO_DE_COMPRA = "Se ha presentado un problema tratando de consultar la información del estado del proceso de compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADO_DEL_PROCESO_DE_COMPRA = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información del estado del proceso de compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_ESTADOS_DEL_PROCESO_DE_COMPRA = "Se ha presentado un problema tratando de consultar la información de los estados del proceso de compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADOS_DEL_PROCESO_DE_COMPRA = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los estados del proceso de compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"EstadoProcesoCompra\" (\"id\", \"Codigo\", \"Nombre\") VALUES (?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoProcesoCompra\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoProcesoCompra\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoProcesoCompra\"";
	}

	public static final class EstadoSaldoFavorPostgreSqlDAO {

		private EstadoSaldoFavorPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_ESTADO_DE_SALDO_A_FAVOR = "Se ha presentado un problema tratando de registrar la información del estado de saldo a favor. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_ESTADO_DE_SALDO_A_FAVOR = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del estado de saldo a favor. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_ESTADO_DE_SALDO_A_FAVOR = "Se ha presentado un problema tratando de consultar la información del estado de saldo a favor. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADO_DE_SALDO_A_FAVOR = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información del estado de saldo a favor. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_ESTADOS_DE_SALDO_A_FAVOR = "Se ha presentado un problema tratando de consultar la información de los estados de saldo a favor. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADOS_DE_SALDO_A_FAVOR = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los estados de saldo a favor. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"EstadoSaldoFavor\" (\"id\", \"Codigo\", \"Nombre\") VALUES (?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoSaldoFavor\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoSaldoFavor\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoSaldoFavor\"";
	}

	public static final class FacturaPostgreSqlDAO {

		private FacturaPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_FACTURA = "Se ha presentado un problema tratando de registrar la información de la factura. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_FACTURA = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información de la factura. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_FACTURA = "Se ha presentado un problema tratando de consultar la información de la factura. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_FACTURA = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de la factura. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_FACTURAS = "Se ha presentado un problema tratando de consultar la información de las facturas. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_FACTURAS = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de las facturas. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"Factura\" (\"id\", \"Compra_id\", \"FechaEmision\") VALUES (?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Compra_id\", \"FechaEmision\" FROM saraitel.\"Factura\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Compra_id\", \"FechaEmision\" FROM saraitel.\"Factura\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Compra_id\", \"FechaEmision\" FROM saraitel.\"Factura\"";
	}

	public static final class IngresoInventarioPostgreSqlDAO {

		private IngresoInventarioPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_INGRESO_DE_INVENTARIO = "Se ha presentado un problema tratando de registrar la información del ingreso de inventario. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_INGRESO_DE_INVENTARIO = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del ingreso de inventario. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_INGRESOS_DE_INVENTARIO = "Se ha presentado un problema tratando de consultar la información de los ingresos de inventario. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_INGRESOS_DE_INVENTARIO = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los ingresos de inventario. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_INSERTAR = "INSERT INTO saraitel.\"IngresoInventario\" (\"id\", \"Sede_id\", \"EstadoInventario_id\", \"FechaLlegada\", \"Total\") VALUES (?, ?, ?, ?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Sede_id\", \"EstadoInventario_id\", \"FechaLlegada\", \"Total\" FROM saraitel.\"IngresoInventario\"";
	}

	public static final class MarcaPostgreSqlDAO {

		private MarcaPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_MARCA = "Se ha presentado un problema tratando de registrar la información de la marca. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_MARCA = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información de la marca. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_MARCAS = "Se ha presentado un problema tratando de consultar la información de las marcas. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_MARCAS = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de las marcas. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_INSERTAR = "INSERT INTO saraitel.\"Marca\" (\"id\", \"Nombre\", \"EsActivo\") VALUES (?, ?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Nombre\", \"EsActivo\" FROM saraitel.\"Marca\"";
	}

	public static final class MetodoPagoPostgreSqlDAO {

		private MetodoPagoPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_METODO_DE_PAGO = "Se ha presentado un problema tratando de registrar la información del método de pago. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_METODO_DE_PAGO = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del método de pago. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_METODO_DE_PAGO = "Se ha presentado un problema tratando de consultar la información del método de pago. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_METODO_DE_PAGO = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información del método de pago. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_METODOS_DE_PAGO = "Se ha presentado un problema tratando de consultar la información de los métodos de pago. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_METODOS_DE_PAGO = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los métodos de pago. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"MetodoPago\" (\"id\", \"Nombre\", \"EsActivo\") VALUES (?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Nombre\", \"EsActivo\" FROM saraitel.\"MetodoPago\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Nombre\", \"EsActivo\" FROM saraitel.\"MetodoPago\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Nombre\", \"EsActivo\" FROM saraitel.\"MetodoPago\"";
	}

	public static final class MotivoPostgreSqlDAO {

		private MotivoPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_MOTIVO = "Se ha presentado un problema tratando de consultar la información del motivo. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_MOTIVO = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información del motivo. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_MOTIVOS = "Se ha presentado un problema tratando de consultar la información de los motivos. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_MOTIVOS = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los motivos. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Nombre\" FROM saraitel.\"Motivo\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Nombre\" FROM saraitel.\"Motivo\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Nombre\" FROM saraitel.\"Motivo\"";
	}

	public static final class PagoNormalPostgreSqlDAO {

		private PagoNormalPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_PAGO_NORMAL = "Se ha presentado un problema tratando de registrar la información del pago normal. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_PAGO_NORMAL = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del pago normal. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_PAGO_NORMAL = "Se ha presentado un problema tratando de consultar la información del pago normal. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAGO_NORMAL = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información del pago normal. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_PAGOS_NORMALES = "Se ha presentado un problema tratando de consultar la información de los pagos normales. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAGOS_NORMALES = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los pagos normales. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"PagoNormal\" (\"id\", \"MetodoPago_id\", \"Pago_id\", \"MontoPagar\") VALUES (?, ?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"MetodoPago_id\", \"Pago_id\", \"MontoPagar\" FROM saraitel.\"PagoNormal\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"MetodoPago_id\", \"Pago_id\", \"MontoPagar\" FROM saraitel.\"PagoNormal\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"MetodoPago_id\", \"Pago_id\", \"MontoPagar\" FROM saraitel.\"PagoNormal\"";
	}

	public static final class PagoPostgreSqlDAO {

		private PagoPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_PAGO = "Se ha presentado un problema tratando de registrar la información del pago. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_PAGO = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del pago. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_PAGO = "Se ha presentado un problema tratando de consultar la información del pago. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAGO = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información del pago. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_PAGOS = "Se ha presentado un problema tratando de consultar la información de los pagos. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAGOS = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los pagos. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"Pago\" (\"id\", \"Compra_id\", \"MontoPagado\", \"FechaPago\") VALUES (?, ?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Compra_id\", \"MontoPagado\", \"FechaPago\" FROM saraitel.\"Pago\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Compra_id\", \"MontoPagado\", \"FechaPago\" FROM saraitel.\"Pago\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Compra_id\", \"MontoPagado\", \"FechaPago\" FROM saraitel.\"Pago\"";
	}

	public static final class PaisPostgreSqlDAO {

		private PaisPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_PAIS = "Se ha presentado un problema tratando de registrar la información del país. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_PAIS = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del país. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_PAIS = "Se ha presentado un problema tratando de consultar la información del país. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAIS = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información del país. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_PAISES = "Se ha presentado un problema tratando de consultar la información de los países. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAISES = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los países. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_PAIS = "Se ha presentado un problema tratando de modificar la información del país. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_PAIS = "Se ha presentado un problema NO CONTROLADO tratando de modificar la información del país. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ELIMINANDO_PAIS = "Se ha presentado un problema tratando de eliminar la información del país. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ELIMINANDO_PAIS = "Se ha presentado un problema NO CONTROLADO tratando de eliminar la información del país. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"Pais\" (\"id\", \"Nombre\") VALUES (?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Nombre\" FROM saraitel.\"Pais\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Nombre\" FROM saraitel.\"Pais\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Nombre\" FROM saraitel.\"Pais\"";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"Pais\" SET \"Nombre\" = ? WHERE \"id\" = ?";
		public static final String SQL_ELIMINAR = "DELETE FROM saraitel.\"Pais\" WHERE \"id\" = ?";
	}

	public static final class PersonaPostgreSqlDAO {

		private PersonaPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_PERSONA = "Se ha presentado un problema tratando de registrar la información de la persona. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_PERSONA = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información de la persona. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_PERSONAS = "Se ha presentado un problema tratando de consultar la información de las personas. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PERSONAS = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de las personas. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_PERSONA = "Se ha presentado un problema tratando de modificar la información de la persona. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_PERSONA = "Se ha presentado un problema NO CONTROLADO tratando de modificar la información de la persona. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ELIMINANDO_PERSONA = "Se ha presentado un problema tratando de eliminar la información de la persona. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ELIMINANDO_PERSONA = "Se ha presentado un problema NO CONTROLADO tratando de eliminar la información de la persona. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_INSERTAR = "INSERT INTO saraitel.\"Persona\" (\"id\", \"TipoDocumento_id\", \"Prefijo_id\", \"NumeroDocumento\", \"Telefono\", \"Nombre\", \"Apellido\", \"Correo\", \"TelefonoConfirmado\", \"CorreoConfirmado\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"TipoDocumento_id\", \"Prefijo_id\", \"NumeroDocumento\", \"Telefono\", \"Nombre\", \"Apellido\", \"Correo\", \"TelefonoConfirmado\", \"CorreoConfirmado\" FROM saraitel.\"Persona\"";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"Persona\" SET \"TipoDocumento_id\" = ?, \"Prefijo_id\" = ?, \"NumeroDocumento\" = ?, \"Telefono\" = ?, \"Nombre\" = ?, \"Apellido\" = ?, \"Correo\" = ?, \"TelefonoConfirmado\" = ?, \"CorreoConfirmado\" = ? WHERE \"id\" = ?";
		public static final String SQL_ELIMINAR = "DELETE FROM saraitel.\"Persona\" WHERE \"id\" = ?";
	}

	public static final class PrefijoPostgreSqlDAO {

		private PrefijoPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_PREFIJOS = "Se ha presentado un problema tratando de consultar la información de los prefijos. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PREFIJOS = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los prefijos. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Codigo\" FROM saraitel.\"Prefijo\"";
	}

	public static final class ProcesoCompraPostgreSqlDAO {

		private ProcesoCompraPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_PROCESO_DE_COMPRA = "Se ha presentado un problema tratando de registrar la información del proceso de compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_PROCESO_DE_COMPRA = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del proceso de compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_PROCESO_DE_COMPRA = "Se ha presentado un problema tratando de consultar la información del proceso de compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PROCESO_DE_COMPRA = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información del proceso de compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_PROCESOS_DE_COMPRA = "Se ha presentado un problema tratando de consultar la información de los procesos de compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PROCESOS_DE_COMPRA = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los procesos de compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_PROCESO_DE_COMPRA = "Se ha presentado un problema tratando de modificar la información del proceso de compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_PROCESO_DE_COMPRA = "Se ha presentado un problema NO CONTROLADO tratando de modificar la información del proceso de compra. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"ProcesoCompra\" (\"id\", \"Cliente_id\", \"Empleado_id\", \"EstadoProcesoCompra_id\", \"FechaInicio\", \"FechaActualizacion\", \"TotalCompra\") VALUES (?, ?, ?, ?, ?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Cliente_id\", \"Empleado_id\", \"EstadoProcesoCompra_id\", \"FechaInicio\", \"FechaActualizacion\", \"TotalCompra\" FROM saraitel.\"ProcesoCompra\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Cliente_id\", \"Empleado_id\", \"EstadoProcesoCompra_id\", \"FechaInicio\", \"FechaActualizacion\", \"TotalCompra\" FROM saraitel.\"ProcesoCompra\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Cliente_id\", \"Empleado_id\", \"EstadoProcesoCompra_id\", \"FechaInicio\", \"FechaActualizacion\", \"TotalCompra\" FROM saraitel.\"ProcesoCompra\"";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"ProcesoCompra\" SET \"Cliente_id\" = ?, \"Empleado_id\" = ?, \"EstadoProcesoCompra_id\" = ?, \"FechaInicio\" = ?, \"FechaActualizacion\" = ?, \"TotalCompra\" = ? WHERE \"id\" = ?";
	}

	public static final class ProductoPostgreSqlDAO {

		private ProductoPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_PRODUCTO = "Se ha presentado un problema tratando de registrar la información del producto. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_PRODUCTO = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del producto. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_PRODUCTOS = "Se ha presentado un problema tratando de consultar la información de los productos. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PRODUCTOS = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los productos. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_PRODUCTO = "Se ha presentado un problema tratando de modificar la información del producto. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_PRODUCTO = "Se ha presentado un problema NO CONTROLADO tratando de modificar la información del producto. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_INSERTAR = "INSERT INTO saraitel.\"Producto\" (\"id\", \"Marca_id\", \"Categoria_id\", \"Modelo\", \"Nombre\", \"Descripcion\") VALUES (?, ?, ?, ?, ?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Marca_id\", \"Categoria_id\", \"Modelo\", \"Nombre\", \"Descripcion\" FROM saraitel.\"Producto\"";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"Producto\" SET \"Marca_id\" = ?, \"Categoria_id\" = ?, \"Modelo\" = ?, \"Nombre\" = ?, \"Descripcion\" = ? WHERE \"id\" = ?";
	}

	public static final class ProductoSedePostgreSqlDAO {

		private ProductoSedePostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_PRODUCTO_POR_SEDE = "Se ha presentado un problema tratando de registrar la información del producto por sede. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_PRODUCTO_POR_SEDE = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del producto por sede. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_PRODUCTO_POR_SEDE = "Se ha presentado un problema tratando de consultar la información del producto por sede. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PRODUCTO_POR_SEDE = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información del producto por sede. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_PRODUCTOS_POR_SEDE = "Se ha presentado un problema tratando de consultar la información de los productos por sede. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PRODUCTOS_POR_SEDE = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los productos por sede. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_PRODUCTO_POR_SEDE = "Se ha presentado un problema tratando de modificar la información del producto por sede. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_PRODUCTO_POR_SEDE = "Se ha presentado un problema NO CONTROLADO tratando de modificar la información del producto por sede. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"ProductoSede\" (\"id\", \"Producto_id\", \"Sede_id\", \"Precio\", \"TieneOferta\", \"Oferta\", \"PrecioTrasOferta\", \"Stock\", \"StockGarantia\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Producto_id\", \"Sede_id\", \"Precio\", \"TieneOferta\", \"Oferta\", \"PrecioTrasOferta\", \"Stock\", \"StockGarantia\" FROM saraitel.\"ProductoSede\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Producto_id\", \"Sede_id\", \"Precio\", \"TieneOferta\", \"Oferta\", \"PrecioTrasOferta\", \"Stock\", \"StockGarantia\" FROM saraitel.\"ProductoSede\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Producto_id\", \"Sede_id\", \"Precio\", \"TieneOferta\", \"Oferta\", \"PrecioTrasOferta\", \"Stock\", \"StockGarantia\" FROM saraitel.\"ProductoSede\"";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"ProductoSede\" SET \"Producto_id\" = ?, \"Sede_id\" = ?, \"Precio\" = ?, \"TieneOferta\" = ?, \"Oferta\" = ?, \"PrecioTrasOferta\" = ?, \"Stock\" = ?, \"StockGarantia\" = ? WHERE \"id\" = ?";
	}

	public static final class SaldoFavorPostgreSqlDAO {

		private SaldoFavorPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_SALDO_A_FAVOR = "Se ha presentado un problema tratando de registrar la información del saldo a favor. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_SALDO_A_FAVOR = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del saldo a favor. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_SALDO_A_FAVOR = "Se ha presentado un problema tratando de consultar la información del saldo a favor. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_SALDO_A_FAVOR = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información del saldo a favor. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_SALDOS_A_FAVOR = "Se ha presentado un problema tratando de consultar la información de los saldos a favor. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_SALDOS_A_FAVOR = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los saldos a favor. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"SaldoFavor\" (\"id\", \"Devolucion_id\", \"EstadoSaldoFavor_id\", \"MontoUsado\") VALUES (?, ?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Devolucion_id\", \"EstadoSaldoFavor_id\", \"MontoUsado\" FROM saraitel.\"SaldoFavor\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Devolucion_id\", \"EstadoSaldoFavor_id\", \"MontoUsado\" FROM saraitel.\"SaldoFavor\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Devolucion_id\", \"EstadoSaldoFavor_id\", \"MontoUsado\" FROM saraitel.\"SaldoFavor\"";
	}

	public static final class SedePostgreSqlDAO {

		private SedePostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_SEDE = "Se ha presentado un problema tratando de registrar la información de la sede. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_SEDE = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información de la sede. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_SEDES = "Se ha presentado un problema tratando de consultar la información de las sedes. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_SEDES = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de las sedes. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_SEDE = "Se ha presentado un problema tratando de modificar la información de la sede. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_SEDE = "Se ha presentado un problema NO CONTROLADO tratando de modificar la información de la sede. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"Sede\" (\"id\", \"Ciudad_id\", \"Nombre\", \"Nit\", \"Direccion\", \"EsActiva\") VALUES (?, ?, ?, ?, ?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Ciudad_id\", \"Nombre\", \"Nit\", \"Direccion\", \"EsActiva\" FROM saraitel.\"Sede\"";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"Sede\" SET \"Ciudad_id\" = ?, \"Nombre\" = ?, \"Nit\" = ?, \"Direccion\" = ?, \"EsActiva\" = ? WHERE \"id\" = ?";
	}

	public static final class TipoDocumentoPostgreSqlDAO {

		private TipoDocumentoPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_TIPOS_DE_DOCUMENTO = "Se ha presentado un problema tratando de consultar la información de los tipos de documento. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_TIPOS_DE_DOCUMENTO = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los tipos de documento. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Tipo\" FROM saraitel.\"TipoDocumento\"";
	}

	public static final class VendedorPostgreSqlDAO {

		private VendedorPostgreSqlDAO() {
		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_VENDEDOR = "Se ha presentado un problema tratando de registrar la información del vendedor. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_VENDEDOR = "Se ha presentado un problema NO CONTROLADO tratando de registrar la información del vendedor. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_VENDEDORES = "Se ha presentado un problema tratando de consultar la información de los vendedores. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_VENDEDORES = "Se ha presentado un problema NO CONTROLADO tratando de consultar la información de los vendedores. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String SQL_CREAR = "INSERT INTO saraitel.\"Vendedor\" (\"id\", \"Empleado_id\") VALUES (?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Empleado_id\" FROM saraitel.\"Vendedor\"";
	}
}
