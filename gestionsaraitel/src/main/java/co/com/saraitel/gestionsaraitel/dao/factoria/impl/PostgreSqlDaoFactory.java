package co.com.saraitel.gestionsaraitel.dao.factoria.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelTransversalExcepcion;

public class PostgreSqlDaoFactory extends DAOFactory {

	private static final String URL = System.getenv("DATABASE_URL");
	private static final String USUARIO = System.getenv("DATABASE_USER");
	private static final String CONTRASENA = System.getenv("DATABASE_PASSWORD");

	public PostgreSqlDaoFactory() {
		abrirConexion();
	}

	@Override
	protected void abrirConexion() {
		try {
			Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
			setConexion(conexion);
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.PostgreSqlDaoFactory.USUARIO_ERROR_PROBLEMA_ABRIENDO_CONEXION_POSTGRESQL;
			throw GestionSaraitelTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.PostgreSqlDaoFactory.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ABRIENDO_CONEXION_POSTGRESQL;
			throw GestionSaraitelTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
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