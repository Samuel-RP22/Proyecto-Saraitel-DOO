package co.com.saraitel.gestionsaraitel.transversal.catalogo;

public final class CatalogoSentenciasSql {

	private CatalogoSentenciasSql() {
	}

	public static final class AdministradorPostgreSqlDAO {

		private AdministradorPostgreSqlDAO() {
		}

		public static final String SQL_CREAR = "INSERT INTO saraitel.\"Administrador\" (\"id\", \"Empleado_id\") VALUES (?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Empleado_id\" FROM saraitel.\"Administrador\"";
	}

	public static final class AplicacionSaldoPostgreSqlDAO {

		private AplicacionSaldoPostgreSqlDAO() {
		}

		public static final String SQL_CREAR = "INSERT INTO saraitel.\"AplicacionSaldo\" (\"id\", \"SaldoFavor_id\", \"Pago_id\", \"ValorAplicado\") VALUES (?, ?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"SaldoFavor_id\", \"Pago_id\", \"ValorAplicado\" FROM saraitel.\"AplicacionSaldo\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"SaldoFavor_id\", \"Pago_id\", \"ValorAplicado\" FROM saraitel.\"AplicacionSaldo\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"SaldoFavor_id\", \"Pago_id\", \"ValorAplicado\" FROM saraitel.\"AplicacionSaldo\"";
	}

	public static final class CategoriaPostgreSqlDAO {

		private CategoriaPostgreSqlDAO() {
		}

		public static final String SQL_INSERTAR = "INSERT INTO saraitel.\"Categoria\" (\"id\", \"Nombre\", \"CategoriaPadre_id\", \"Nivel\") VALUES (?, ?, ?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Nombre\", \"CategoriaPadre_id\", \"Nivel\" FROM saraitel.\"Categoria\"";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"Categoria\" SET \"Nombre\" = ?, \"CategoriaPadre_id\" = ?, \"Nivel\" = ? WHERE \"id\" = ?";
		public static final String SQL_ELIMINAR = "DELETE FROM saraitel.\"Categoria\" WHERE \"id\" = ?";
	}

	public static final class CiudadPostgreSqlDAO {

		private CiudadPostgreSqlDAO() {
		}

		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Departamento_id\", \"Nombre\" FROM saraitel.\"Ciudad\"";
	}

	public static final class ClienteNoRegistradoPostgreSqlDAO {

		private ClienteNoRegistradoPostgreSqlDAO() {
		}

		public static final String SQL_INSERTAR = "INSERT INTO saraitel.\"ClienteNoRegistrado\" (\"id\", \"Cliente_id\", \"Nombre\", \"Apellido\", \"NumeroDocumento\") VALUES (?, ?, ?, ?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Cliente_id\", \"Nombre\", \"Apellido\", \"NumeroDocumento\" FROM saraitel.\"ClienteNoRegistrado\"";
	}

	public static final class ClientePostgreSqlDAO {

		private ClientePostgreSqlDAO() {
		}

		public static final String SQL_INSERTAR = "INSERT INTO saraitel.\"Cliente\" (\"id\", \"EsClienteRegistrado\") VALUES (?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"EsClienteRegistrado\" FROM saraitel.\"Cliente\"";
		public static final String SQL_ELIMINAR = "DELETE FROM saraitel.\"Cliente\" WHERE \"id\" = ?";
	}

	public static final class ClienteRegistradoJPostgreSqlDAO {

		private ClienteRegistradoJPostgreSqlDAO() {
		}

		public static final String SQL_INSERTAR = "INSERT INTO saraitel.\"ClienteRegistradoJ\" (\"id\", \"ClienteRegistrado_id\", \"Prefijo_id\", \"Telefono\", \"Nit\", \"RazonSocial\", \"Correo\", \"TelefonoConfirmado\", \"CorreoConfirmado\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		public static final String SQL_CONSULTAR = "SELECT * FROM (SELECT j.\"id\", j.\"ClienteRegistrado_id\", j.\"Prefijo_id\", j.\"Telefono\", j.\"Nit\", j.\"RazonSocial\", j.\"Correo\", j.\"TelefonoConfirmado\", j.\"CorreoConfirmado\", cr.\"Cliente_id\" FROM saraitel.\"ClienteRegistradoJ\" j JOIN saraitel.\"ClienteRegistrado\" cr ON cr.\"id\" = j.\"ClienteRegistrado_id\") AS clientes_juridicos";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"ClienteRegistradoJ\" SET \"ClienteRegistrado_id\" = ?, \"Prefijo_id\" = ?, \"Telefono\" = ?, \"Nit\" = ?, \"RazonSocial\" = ?, \"Correo\" = ?, \"TelefonoConfirmado\" = ?, \"CorreoConfirmado\" = ? WHERE \"id\" = ?";
		public static final String SQL_ELIMINAR = "DELETE FROM saraitel.\"ClienteRegistradoJ\" WHERE \"id\" = ?";
	}

	public static final class ClienteRegistradoNPostgreSqlDAO {

		private ClienteRegistradoNPostgreSqlDAO() {
		}

		public static final String SQL_INSERTAR = "INSERT INTO saraitel.\"ClienteRegistradoN\" (\"id\", \"ClienteRegistrado_id\", \"Persona_id\") VALUES (?, ?, ?)";
		public static final String SQL_CONSULTAR = "SELECT * FROM (SELECT n.\"id\", n.\"ClienteRegistrado_id\", n.\"Persona_id\", cr.\"Cliente_id\", p.\"TipoDocumento_id\", p.\"Prefijo_id\", p.\"NumeroDocumento\", p.\"Telefono\", p.\"Nombre\", p.\"Apellido\", p.\"Correo\" FROM saraitel.\"ClienteRegistradoN\" n JOIN saraitel.\"ClienteRegistrado\" cr ON cr.\"id\" = n.\"ClienteRegistrado_id\" JOIN saraitel.\"Persona\" p ON p.\"id\" = n.\"Persona_id\") AS clientes_naturales";
		public static final String SQL_ELIMINAR = "DELETE FROM saraitel.\"ClienteRegistradoN\" WHERE \"id\" = ?";
	}

	public static final class ClienteRegistradoPostgreSqlDAO {

		private ClienteRegistradoPostgreSqlDAO() {
		}

		public static final String SQL_INSERTAR = "INSERT INTO saraitel.\"ClienteRegistrado\" (\"id\", \"Cliente_id\") VALUES (?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Cliente_id\" FROM saraitel.\"ClienteRegistrado\"";
		public static final String SQL_ELIMINAR = "DELETE FROM saraitel.\"ClienteRegistrado\" WHERE \"id\" = ?";
	}

	public static final class CompraPostgreSqlDAO {

		private CompraPostgreSqlDAO() {
		}

		public static final String SQL_CREAR = "INSERT INTO saraitel.\"Compra\" (\"id\", \"ProcesoCompra_id\", \"EstadoCompra_id\", \"FechaCompra\") VALUES (?, ?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"ProcesoCompra_id\", \"EstadoCompra_id\", \"FechaCompra\" FROM saraitel.\"Compra\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"ProcesoCompra_id\", \"EstadoCompra_id\", \"FechaCompra\" FROM saraitel.\"Compra\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"ProcesoCompra_id\", \"EstadoCompra_id\", \"FechaCompra\" FROM saraitel.\"Compra\"";
	}

	public static final class DepartamentoPostgreSqlDAO {

		private DepartamentoPostgreSqlDAO() {
		}

		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Pais_id\", \"Nombre\" FROM saraitel.\"Departamento\"";
	}

	public static final class DetalleCompraPostgreSqlDAO {

		private DetalleCompraPostgreSqlDAO() {
		}

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

		public static final String SQL_CREAR = "INSERT INTO saraitel.\"Devolucion\" (\"id\", \"DetalleCompra_id\", \"Motivo_id\", \"FechaDevolucion\", \"Cantidad\", \"MontoDevolucion\", \"Estado\") VALUES (?, ?, ?, ?, ?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"DetalleCompra_id\", \"Motivo_id\", \"FechaDevolucion\", \"Cantidad\", \"MontoDevolucion\", \"Estado\" FROM saraitel.\"Devolucion\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"DetalleCompra_id\", \"Motivo_id\", \"FechaDevolucion\", \"Cantidad\", \"MontoDevolucion\", \"Estado\" FROM saraitel.\"Devolucion\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"DetalleCompra_id\", \"Motivo_id\", \"FechaDevolucion\", \"Cantidad\", \"MontoDevolucion\", \"Estado\" FROM saraitel.\"Devolucion\"";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"Devolucion\" SET \"DetalleCompra_id\" = ?, \"Motivo_id\" = ?, \"FechaDevolucion\" = ?, \"Cantidad\" = ?, \"MontoDevolucion\" = ?, \"Estado\" = ? WHERE \"id\" = ?";
	}

	public static final class EmpleadoPostgreSqlDAO {

		private EmpleadoPostgreSqlDAO() {
		}

		public static final String SQL_CREAR = "INSERT INTO saraitel.\"Empleado\" (\"id\", \"Sede_id\", \"Persona_id\", \"EsActivo\") VALUES (?, ?, ?, ?)";
		public static final String SQL_CONSULTAR = "SELECT * FROM (SELECT e.\"id\", e.\"Sede_id\", e.\"Persona_id\", e.\"EsActivo\", p.\"NumeroDocumento\", p.\"Nombre\", p.\"Apellido\", p.\"Correo\", s.\"Nombre\" AS \"NombreSede\" FROM saraitel.\"Empleado\" e JOIN saraitel.\"Persona\" p ON p.\"id\" = e.\"Persona_id\" JOIN saraitel.\"Sede\" s ON s.\"id\" = e.\"Sede_id\") AS empleados";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"Empleado\" SET \"Sede_id\" = ?, \"Persona_id\" = ?, \"EsActivo\" = ? WHERE \"id\" = ?";
	}

	public static final class EstadoCompraPostgreSqlDAO {

		private EstadoCompraPostgreSqlDAO() {
		}

		public static final String SQL_CREAR = "INSERT INTO saraitel.\"EstadoCompra\" (\"id\", \"Codigo\", \"Nombre\") VALUES (?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoCompra\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoCompra\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoCompra\"";
	}

	public static final class EstadoInventarioPostgreSqlDAO {

		private EstadoInventarioPostgreSqlDAO() {
		}

		public static final String SQL_CREAR = "INSERT INTO saraitel.\"EstadoInventario\" (\"id\", \"Codigo\", \"Nombre\") VALUES (?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoInventario\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoInventario\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoInventario\"";
	}

	public static final class EstadoProcesoCompraPostgreSqlDAO {

		private EstadoProcesoCompraPostgreSqlDAO() {
		}

		public static final String SQL_CREAR = "INSERT INTO saraitel.\"EstadoProcesoCompra\" (\"id\", \"Codigo\", \"Nombre\") VALUES (?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoProcesoCompra\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoProcesoCompra\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoProcesoCompra\"";
	}

	public static final class EstadoSaldoFavorPostgreSqlDAO {

		private EstadoSaldoFavorPostgreSqlDAO() {
		}

		public static final String SQL_CREAR = "INSERT INTO saraitel.\"EstadoSaldoFavor\" (\"id\", \"Codigo\", \"Nombre\") VALUES (?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoSaldoFavor\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoSaldoFavor\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Codigo\", \"Nombre\" FROM saraitel.\"EstadoSaldoFavor\"";
	}

	public static final class FacturaPostgreSqlDAO {

		private FacturaPostgreSqlDAO() {
		}

		public static final String SQL_CREAR = "INSERT INTO saraitel.\"Factura\" (\"id\", \"Compra_id\", \"FechaEmision\") VALUES (?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Compra_id\", \"FechaEmision\" FROM saraitel.\"Factura\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Compra_id\", \"FechaEmision\" FROM saraitel.\"Factura\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Compra_id\", \"FechaEmision\" FROM saraitel.\"Factura\"";
	}

	public static final class IngresoInventarioPostgreSqlDAO {

		private IngresoInventarioPostgreSqlDAO() {
		}

		public static final String SQL_INSERTAR = "INSERT INTO saraitel.\"IngresoInventario\" (\"id\", \"Sede_id\", \"EstadoInventario_id\", \"FechaLlegada\", \"Total\") VALUES (?, ?, ?, ?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Sede_id\", \"EstadoInventario_id\", \"FechaLlegada\", \"Total\" FROM saraitel.\"IngresoInventario\"";
	}

	public static final class MarcaPostgreSqlDAO {

		private MarcaPostgreSqlDAO() {
		}

		public static final String SQL_INSERTAR = "INSERT INTO saraitel.\"Marca\" (\"id\", \"Nombre\", \"EsActivo\") VALUES (?, ?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Nombre\", \"EsActivo\" FROM saraitel.\"Marca\"";
	}

	public static final class MetodoPagoPostgreSqlDAO {

		private MetodoPagoPostgreSqlDAO() {
		}

		public static final String SQL_CREAR = "INSERT INTO saraitel.\"MetodoPago\" (\"id\", \"Nombre\", \"EsActivo\") VALUES (?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Nombre\", \"EsActivo\" FROM saraitel.\"MetodoPago\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Nombre\", \"EsActivo\" FROM saraitel.\"MetodoPago\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Nombre\", \"EsActivo\" FROM saraitel.\"MetodoPago\"";
	}

	public static final class MotivoPostgreSqlDAO {

		private MotivoPostgreSqlDAO() {
		}

		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Nombre\" FROM saraitel.\"Motivo\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Nombre\" FROM saraitel.\"Motivo\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Nombre\" FROM saraitel.\"Motivo\"";
	}

	public static final class PagoNormalPostgreSqlDAO {

		private PagoNormalPostgreSqlDAO() {
		}

		public static final String SQL_CREAR = "INSERT INTO saraitel.\"PagoNormal\" (\"id\", \"MetodoPago_id\", \"Pago_id\", \"MontoPagar\") VALUES (?, ?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"MetodoPago_id\", \"Pago_id\", \"MontoPagar\" FROM saraitel.\"PagoNormal\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"MetodoPago_id\", \"Pago_id\", \"MontoPagar\" FROM saraitel.\"PagoNormal\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"MetodoPago_id\", \"Pago_id\", \"MontoPagar\" FROM saraitel.\"PagoNormal\"";
	}

	public static final class PagoPostgreSqlDAO {

		private PagoPostgreSqlDAO() {
		}

		public static final String SQL_CREAR = "INSERT INTO saraitel.\"Pago\" (\"id\", \"Compra_id\", \"MontoPagado\", \"FechaPago\") VALUES (?, ?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Compra_id\", \"MontoPagado\", \"FechaPago\" FROM saraitel.\"Pago\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Compra_id\", \"MontoPagado\", \"FechaPago\" FROM saraitel.\"Pago\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Compra_id\", \"MontoPagado\", \"FechaPago\" FROM saraitel.\"Pago\"";
	}

	public static final class PaisPostgreSqlDAO {

		private PaisPostgreSqlDAO() {
		}

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

		public static final String SQL_INSERTAR = "INSERT INTO saraitel.\"Persona\" (\"id\", \"TipoDocumento_id\", \"Prefijo_id\", \"NumeroDocumento\", \"Telefono\", \"Nombre\", \"Apellido\", \"Correo\", \"TelefonoConfirmado\", \"CorreoConfirmado\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"TipoDocumento_id\", \"Prefijo_id\", \"NumeroDocumento\", \"Telefono\", \"Nombre\", \"Apellido\", \"Correo\", \"TelefonoConfirmado\", \"CorreoConfirmado\" FROM saraitel.\"Persona\"";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"Persona\" SET \"TipoDocumento_id\" = ?, \"Prefijo_id\" = ?, \"NumeroDocumento\" = ?, \"Telefono\" = ?, \"Nombre\" = ?, \"Apellido\" = ?, \"Correo\" = ?, \"TelefonoConfirmado\" = ?, \"CorreoConfirmado\" = ? WHERE \"id\" = ?";
		public static final String SQL_ELIMINAR = "DELETE FROM saraitel.\"Persona\" WHERE \"id\" = ?";
	}

	public static final class PrefijoPostgreSqlDAO {

		private PrefijoPostgreSqlDAO() {
		}

		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Codigo\" FROM saraitel.\"Prefijo\"";
	}

	public static final class ProcesoCompraPostgreSqlDAO {

		private ProcesoCompraPostgreSqlDAO() {
		}

		public static final String SQL_CREAR = "INSERT INTO saraitel.\"ProcesoCompra\" (\"id\", \"Cliente_id\", \"Empleado_id\", \"EstadoProcesoCompra_id\", \"FechaInicio\", \"FechaActualizacion\", \"TotalCompra\") VALUES (?, ?, ?, ?, ?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Cliente_id\", \"Empleado_id\", \"EstadoProcesoCompra_id\", \"FechaInicio\", \"FechaActualizacion\", \"TotalCompra\" FROM saraitel.\"ProcesoCompra\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Cliente_id\", \"Empleado_id\", \"EstadoProcesoCompra_id\", \"FechaInicio\", \"FechaActualizacion\", \"TotalCompra\" FROM saraitel.\"ProcesoCompra\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Cliente_id\", \"Empleado_id\", \"EstadoProcesoCompra_id\", \"FechaInicio\", \"FechaActualizacion\", \"TotalCompra\" FROM saraitel.\"ProcesoCompra\"";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"ProcesoCompra\" SET \"Cliente_id\" = ?, \"Empleado_id\" = ?, \"EstadoProcesoCompra_id\" = ?, \"FechaInicio\" = ?, \"FechaActualizacion\" = ?, \"TotalCompra\" = ? WHERE \"id\" = ?";
	}

	public static final class ProductoPostgreSqlDAO {

		private ProductoPostgreSqlDAO() {
		}

		public static final String SQL_INSERTAR = "INSERT INTO saraitel.\"Producto\" (\"id\", \"Marca_id\", \"Categoria_id\", \"Modelo\", \"Nombre\", \"Descripcion\") VALUES (?, ?, ?, ?, ?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Marca_id\", \"Categoria_id\", \"Modelo\", \"Nombre\", \"Descripcion\" FROM saraitel.\"Producto\"";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"Producto\" SET \"Marca_id\" = ?, \"Categoria_id\" = ?, \"Modelo\" = ?, \"Nombre\" = ?, \"Descripcion\" = ? WHERE \"id\" = ?";
	}

	public static final class ProductoSedePostgreSqlDAO {

		private ProductoSedePostgreSqlDAO() {
		}

		public static final String SQL_CREAR = "INSERT INTO saraitel.\"ProductoSede\" (\"id\", \"Producto_id\", \"Sede_id\", \"Precio\", \"TieneOferta\", \"Oferta\", \"PrecioTrasOferta\", \"Stock\", \"StockGarantia\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Producto_id\", \"Sede_id\", \"Precio\", \"TieneOferta\", \"Oferta\", \"PrecioTrasOferta\", \"Stock\", \"StockGarantia\" FROM saraitel.\"ProductoSede\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Producto_id\", \"Sede_id\", \"Precio\", \"TieneOferta\", \"Oferta\", \"PrecioTrasOferta\", \"Stock\", \"StockGarantia\" FROM saraitel.\"ProductoSede\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Producto_id\", \"Sede_id\", \"Precio\", \"TieneOferta\", \"Oferta\", \"PrecioTrasOferta\", \"Stock\", \"StockGarantia\" FROM saraitel.\"ProductoSede\"";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"ProductoSede\" SET \"Producto_id\" = ?, \"Sede_id\" = ?, \"Precio\" = ?, \"TieneOferta\" = ?, \"Oferta\" = ?, \"PrecioTrasOferta\" = ?, \"Stock\" = ?, \"StockGarantia\" = ? WHERE \"id\" = ?";
	}

	public static final class SaldoFavorPostgreSqlDAO {

		private SaldoFavorPostgreSqlDAO() {
		}

		public static final String SQL_CREAR = "INSERT INTO saraitel.\"SaldoFavor\" (\"id\", \"Devolucion_id\", \"EstadoSaldoFavor_id\", \"MontoUsado\") VALUES (?, ?, ?, ?)";
		public static final String SQL_CONSULTAR_POR_ID = "SELECT \"id\", \"Devolucion_id\", \"EstadoSaldoFavor_id\", \"MontoUsado\" FROM saraitel.\"SaldoFavor\" WHERE \"id\" = ?";
		public static final String SQL_CONSULTAR_POR_FILTRO = "SELECT \"id\", \"Devolucion_id\", \"EstadoSaldoFavor_id\", \"MontoUsado\" FROM saraitel.\"SaldoFavor\"";
		public static final String SQL_CONSULTAR_TODOS = "SELECT \"id\", \"Devolucion_id\", \"EstadoSaldoFavor_id\", \"MontoUsado\" FROM saraitel.\"SaldoFavor\"";
	}

	public static final class SedePostgreSqlDAO {

		private SedePostgreSqlDAO() {
		}

		public static final String SQL_CREAR = "INSERT INTO saraitel.\"Sede\" (\"id\", \"Ciudad_id\", \"Nombre\", \"Nit\", \"Direccion\", \"EsActiva\") VALUES (?, ?, ?, ?, ?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Ciudad_id\", \"Nombre\", \"Nit\", \"Direccion\", \"EsActiva\" FROM saraitel.\"Sede\"";
		public static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"Sede\" SET \"Ciudad_id\" = ?, \"Nombre\" = ?, \"Nit\" = ?, \"Direccion\" = ?, \"EsActiva\" = ? WHERE \"id\" = ?";
	}

	public static final class TipoDocumentoPostgreSqlDAO {

		private TipoDocumentoPostgreSqlDAO() {
		}

		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Tipo\" FROM saraitel.\"TipoDocumento\"";
	}

	public static final class VendedorPostgreSqlDAO {

		private VendedorPostgreSqlDAO() {
		}

		public static final String SQL_CREAR = "INSERT INTO saraitel.\"Vendedor\" (\"id\", \"Empleado_id\") VALUES (?, ?)";
		public static final String SQL_CONSULTAR = "SELECT \"id\", \"Empleado_id\" FROM saraitel.\"Vendedor\"";
	}
}