package co.com.saraitel.gestionsaraitel.dao.factoria.impl;

import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.AdministradorDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.AplicacionSaldoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.CategoriaDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.CiudadDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ClienteDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ClienteNoRegistradoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ClienteRegistradoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ClienteRegistradoJDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ClienteRegistradoNDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.CompraDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.DepartamentoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.DetalleCompraDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.DetalleIngresoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.DevolucionDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.EmpleadoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.EstadoCompraDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.EstadoInventarioDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.EstadoProcesoCompraDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.EstadoSaldoFavorDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FacturaDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.IngresoInventarioDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.MarcaDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.MetodoPagoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.MotivoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.PagoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.PagoNormalDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.PaisDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.PersonaDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.PrefijoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ProcesoCompraDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ProductoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ProductoSedeDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SaldoFavorDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SedeDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.TipoDocumentoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.VendedorDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.AdministradorPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.AplicacionSaldoPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.CategoriaPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.CiudadPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.ClienteNoRegistradoPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.ClientePostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.ClienteRegistradoJPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.ClienteRegistradoNPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.ClienteRegistradoPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.CompraPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.DepartamentoPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.DetalleCompraPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.DetalleIngresoPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.DevolucionPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.EmpleadoPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.EstadoCompraPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.EstadoInventarioPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.EstadoProcesoCompraPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.EstadoSaldoFavorPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.FacturaPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.IngresoInventarioPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.MarcaPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.MetodoPagoPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.MotivoPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.PagoNormalPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.PagoPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.PaisPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.PersonaPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.PrefijoPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.ProcesoCompraPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.ProductoPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.ProductoSedePostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.SaldoFavorPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.SedePostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.TipoDocumentoPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.VendedorPostgreSqlDAO;
import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelTransversalExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public class PostgreSqlDaoFactory extends DAOFactory {

	private static final String VARIABLE_URL = "DATABASE_URL";
	private static final String VARIABLE_USUARIO = "DATABASE_USER";
	private static final String VARIABLE_CONTRASENA = "DATABASE_PASSWORD";
	private static final String NOMBRE_POOL = "PoolGestionSaraitel";
	private static final int MAXIMO_CONEXIONES = 10;
	private static final int MINIMO_CONEXIONES_INACTIVAS = 2;
	private static final long TIEMPO_MAXIMO_ESPERA_MILISEGUNDOS = 30_000L;

	private static HikariDataSource fuenteDatos;

	public PostgreSqlDaoFactory() {
		abrirConexion();
	}

	@Override
	protected void abrirConexion() {
		try {
			setConexion(obtenerFuenteDatos().getConnection());
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.PostgreSqlDaoFactory.USUARIO_ERROR_PROBLEMA_ABRIENDO_CONEXION_POSTGRESQL;
			throw GestionSaraitelTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.PostgreSqlDaoFactory.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ABRIENDO_CONEXION_POSTGRESQL;
			throw GestionSaraitelTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
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
			var mensajeUsuario = CatalogoMensajes.PostgreSqlDaoFactory.USUARIO_ERROR_PROBLEMA_CREANDO_POOL_CONEXIONES_POSTGRESQL;
			throw GestionSaraitelTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	private static String obtenerVariableEntorno(final String nombreVariable) {
		var valor = System.getenv(nombreVariable);
		if (UtilTexto.esVacia(valor)) {
			var mensajeUsuario = CatalogoMensajes.PostgreSqlDaoFactory.USUARIO_ERROR_CONFIGURACION_CONEXION_POSTGRESQL_INCOMPLETA;
			var mensajeTecnico = UtilTexto.concatenar(
					CatalogoMensajes.PostgreSqlDaoFactory.TECNICO_ERROR_VARIABLE_ENTORNO_NO_DEFINIDA, nombreVariable);
			throw GestionSaraitelTransversalExcepcion.crear(mensajeUsuario, mensajeTecnico);
		}
		return valor;
	}

	@Override
	public AdministradorDAO obtenerAdministradorDao() {
		return new AdministradorPostgreSqlDAO(getConexion());
	}

	@Override
	public AplicacionSaldoDAO obtenerAplicacionSaldoDao() {
		return new AplicacionSaldoPostgreSqlDAO(getConexion());
	}

	@Override
	public CategoriaDAO obtenerCategoriaDao() {
		return new CategoriaPostgreSqlDAO(getConexion());
	}

	@Override
	public CiudadDAO obtenerCiudadDao() {
		return new CiudadPostgreSqlDAO(getConexion());
	}

	@Override
	public ClienteDAO obtenerClienteDao() {
		return new ClientePostgreSqlDAO(getConexion());
	}

	@Override
	public ClienteNoRegistradoDAO obtenerClienteNoRegistradoDao() {
		return new ClienteNoRegistradoPostgreSqlDAO(getConexion());
	}

	@Override
	public ClienteRegistradoDAO obtenerClienteRegistradoDao() {
		return new ClienteRegistradoPostgreSqlDAO(getConexion());
	}

	@Override
	public ClienteRegistradoJDAO obtenerClienteRegistradoJDao() {
		return new ClienteRegistradoJPostgreSqlDAO(getConexion());
	}

	@Override
	public ClienteRegistradoNDAO obtenerClienteRegistradoNDao() {
		return new ClienteRegistradoNPostgreSqlDAO(getConexion());
	}

	@Override
	public CompraDAO obtenerCompraDao() {
		return new CompraPostgreSqlDAO(getConexion());
	}

	@Override
	public DepartamentoDAO obtenerDepartamentoDao() {
		return new DepartamentoPostgreSqlDAO(getConexion());
	}

	@Override
	public DetalleCompraDAO obtenerDetalleCompraDao() {
		return new DetalleCompraPostgreSqlDAO(getConexion());
	}

	@Override
	public DetalleIngresoDAO obtenerDetalleIngresoDao() {
		return new DetalleIngresoPostgreSqlDAO(getConexion());
	}

	@Override
	public DevolucionDAO obtenerDevolucionDao() {
		return new DevolucionPostgreSqlDAO(getConexion());
	}

	@Override
	public EmpleadoDAO obtenerEmpleadoDao() {
		return new EmpleadoPostgreSqlDAO(getConexion());
	}

	@Override
	public EstadoCompraDAO obtenerEstadoCompraDao() {
		return new EstadoCompraPostgreSqlDAO(getConexion());
	}

	@Override
	public EstadoInventarioDAO obtenerEstadoInventarioDao() {
		return new EstadoInventarioPostgreSqlDAO(getConexion());
	}

	@Override
	public EstadoProcesoCompraDAO obtenerEstadoProcesoCompraDao() {
		return new EstadoProcesoCompraPostgreSqlDAO(getConexion());
	}

	@Override
	public EstadoSaldoFavorDAO obtenerEstadoSaldoFavorDao() {
		return new EstadoSaldoFavorPostgreSqlDAO(getConexion());
	}

	@Override
	public FacturaDAO obtenerFacturaDao() {
		return new FacturaPostgreSqlDAO(getConexion());
	}

	@Override
	public IngresoInventarioDAO obtenerIngresoInventarioDao() {
		return new IngresoInventarioPostgreSqlDAO(getConexion());
	}

	@Override
	public MarcaDAO obtenerMarcaDao() {
		return new MarcaPostgreSqlDAO(getConexion());
	}

	@Override
	public MetodoPagoDAO obtenerMetodoPagoDao() {
		return new MetodoPagoPostgreSqlDAO(getConexion());
	}

	@Override
	public MotivoDAO obtenerMotivoDao() {
		return new MotivoPostgreSqlDAO(getConexion());
	}

	@Override
	public PagoDAO obtenerPagoDao() {
		return new PagoPostgreSqlDAO(getConexion());
	}

	@Override
	public PagoNormalDAO obtenerPagoNormalDao() {
		return new PagoNormalPostgreSqlDAO(getConexion());
	}

	@Override
	public PaisDAO obtenerPaisDao() {
		return new PaisPostgreSqlDAO(getConexion());
	}

	@Override
	public PersonaDAO obtenerPersonaDao() {
		return new PersonaPostgreSqlDAO(getConexion());
	}

	@Override
	public PrefijoDAO obtenerPrefijoDao() {
		return new PrefijoPostgreSqlDAO(getConexion());
	}

	@Override
	public ProcesoCompraDAO obtenerProcesoCompraDao() {
		return new ProcesoCompraPostgreSqlDAO(getConexion());
	}

	@Override
	public ProductoDAO obtenerProductoDao() {
		return new ProductoPostgreSqlDAO(getConexion());
	}

	@Override
	public ProductoSedeDAO obtenerProductoSedeDao() {
		return new ProductoSedePostgreSqlDAO(getConexion());
	}

	@Override
	public SaldoFavorDAO obtenerSaldoFavorDao() {
		return new SaldoFavorPostgreSqlDAO(getConexion());
	}

	@Override
	public SedeDAO obtenerSedeDao() {
		return new SedePostgreSqlDAO(getConexion());
	}

	@Override
	public TipoDocumentoDAO obtenerTipoDocumentoDao() {
		return new TipoDocumentoPostgreSqlDAO(getConexion());
	}

	@Override
	public VendedorDAO obtenerVendedorDao() {
		return new VendedorPostgreSqlDAO(getConexion());
	}
}