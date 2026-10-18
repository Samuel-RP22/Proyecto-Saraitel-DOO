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
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.DepartamentoPostgreSqlDao;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.PaisPostgreSqlDao;
import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionsaraitelTransversalException;

public class PostgreSqlDaoFactory extends DAOFactory {

    private static final String URL =
        "jdbc:postgresql://localhost:5432/saraitel";

    private static final String USUARIO = "admin";
    private static final String CONTRASENA = "123";

    public PostgreSqlDaoFactory() {
        abrirConexion();
    }

    @Override
    protected void abrirConexion() {
        try {
            Connection conexion =
                DriverManager.getConnection(URL, USUARIO, CONTRASENA);

            setConexion(conexion);

        } catch (SQLException excepcion) {
            String mensajeUsuario =
                "No fue posible conectar con la base de datos PostgreSQL";

            throw GestionsaraitelTransversalException.crear(
                mensajeUsuario,
                excepcion.getMessage(),
                excepcion
            );
        }
    }

    @Override
    public AdministradorDAO obtenerAdministradorDao() {
        return new AdministradorPostgreSqlDao(getConexion());
    }

    @Override
    public AplicacionSaldoDAO obtenerAplicacionSaldoDao() {
        return new AplicacionSaldoPostgreSqlDao(getConexion());
    }

    @Override
    public CategoriaDAO obtenerCategoriaDao() {
        return new CategoriaPostgreSqlDao(getConexion());
    }

    @Override
    public CiudadDAO obtenerCiudadDao() {
        return new CiudadPostgreSqlDao(getConexion());
    }

    @Override
    public ClienteDAO obtenerClienteDao() {
        return new ClientePostgreSqlDao(getConexion());
    }

    @Override
    public ClienteNoRegistradoDAO obtenerClienteNoRegistradoDao() {
        return new ClienteNoRegistradoPostgreSqlDao(getConexion());
    }

    @Override
    public ClienteRegistradoDAO obtenerClienteRegistradoDao() {
        return new ClienteRegistradoPostgreSqlDao(getConexion());
    }

    @Override
    public ClienteRegistradoJDAO obtenerClienteRegistradoJDao() {
        return new ClienteRegistradoJPostgreSqlDao(getConexion());
    }

    @Override
    public ClienteRegistradoNDAO obtenerClienteRegistradoNDao() {
        return new ClienteRegistradoNPostgreSqlDao(getConexion());
    }

    @Override
    public CompraDAO obtenerCompraDao() {
        return new CompraPostgreSqlDao(getConexion());
    }

    @Override
    public DepartamentoDAO obtenerDepartamentoDao() {
        return new DepartamentoPostgreSqlDao(getConexion());
    }

    @Override
    public DetalleCompraDAO obtenerDetalleCompraDao() {
        return new DetalleCompraPostgreSqlDao(getConexion());
    }

    @Override
    public DetalleIngresoDAO obtenerDetalleIngresoDao() {
        return new DetalleIngresoPostgreSqlDao(getConexion());
    }

    @Override
    public DevolucionDAO obtenerDevolucionDao() {
        return new DevolucionPostgreSqlDao(getConexion());
    }

    @Override
    public EmpleadoDAO obtenerEmpleadoDao() {
        return new EmpleadoPostgreSqlDao(getConexion());
    }

    @Override
    public EstadoCompraDAO obtenerEstadoCompraDao() {
        return new EstadoCompraPostgreSqlDao(getConexion());
    }

    @Override
    public EstadoInventarioDAO obtenerEstadoInventarioDao() {
        return new EstadoInventarioPostgreSqlDao(getConexion());
    }

    @Override
    public EstadoProcesoCompraDAO obtenerEstadoProcesoCompraDao() {
        return new EstadoProcesoCompraPostgreSqlDao(getConexion());
    }

    @Override
    public EstadoSaldoFavorDAO obtenerEstadoSaldoFavorDao() {
        return new EstadoSaldoFavorPostgreSqlDao(getConexion());
    }

    @Override
    public FacturaDAO obtenerFacturaDao() {
        return new FacturaPostgreSqlDao(getConexion());
    }

    @Override
    public IngresoInventarioDAO obtenerIngresoInventarioDao() {
        return new IngresoInventarioPostgreSqlDao(getConexion());
    }

    @Override
    public MarcaDAO obtenerMarcaDao() {
        return new MarcaPostgreSqlDao(getConexion());
    }

    @Override
    public MetodoPagoDAO obtenerMetodoPagoDao() {
        return new MetodoPagoPostgreSqlDao(getConexion());
    }

    @Override
    public MotivoDAO obtenerMotivoDao() {
        return new MotivoPostgreSqlDao(getConexion());
    }

    @Override
    public PagoDAO obtenerPagoDao() {
        return new PagoPostgreSqlDao(getConexion());
    }

    @Override
    public PagoNormalDAO obtenerPagoNormalDao() {
        return new PagoNormalPostgreSqlDao(getConexion());
    }

    @Override
    public PaisDAO obtenerPaisDao() {
        return new PaisPostgreSqlDao(getConexion());
    }

    @Override
    public PersonaDAO obtenerPersonaDao() {
        return new PersonaPostgreSqlDao(getConexion());
    }

    @Override
    public PrefijoDAO obtenerPrefijoDao() {
        return new PrefijoPostgreSqlDao(getConexion());
    }

    @Override
    public ProcesoCompraDAO obtenerProcesoCompraDao() {
        return new ProcesoCompraPostgreSqlDao(getConexion());
    }

    @Override
    public ProductoDAO obtenerProductoDao() {
        return new ProductoPostgreSqlDao(getConexion());
    }

    @Override
    public ProductoSedeDAO obtenerProductoSedeDao() {
        return new ProductoSedePostgreSqlDao(getConexion());
    }

    @Override
    public SaldoFavorDAO obtenerSaldoFavorDao() {
        return new SaldoFavorPostgreSqlDao(getConexion());
    }

    @Override
    public SedeDAO obtenerSedeDao() {
        return new SedePostgreSqlDao(getConexion());
    }

    @Override
    public TipoDocumentoDAO obtenerTipoDocumentoDao() {
        return new TipoDocumentoPostgreSqlDao(getConexion());
    }

    @Override
    public VendedorDAO obtenerVendedorDao() {
        return new VendedorPostgreSqlDao(getConexion());
    }
}