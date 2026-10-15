
package co.com.saraitel.gestionsaraitel.dao.factoria.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.*;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.*;
import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionsaraitelTransversalException;

public class PostgreSqlDaoFactory extends DAOFactory {

    @Override
    protected void abrirConexion() {
        Connection conexion = null;

        try {
            String url = "";6
            String usuario = "";
            String contrasena = "";

            conexion = DriverManager.getConnection(url, usuario, contrasena);
            setConexion(conexion);

        } catch (SQLException excepcion) {
            String mensajeUsuario = "No fue posible conectar con la base de datos PostgreSQL";

            throw GestionsaraitelTransversalException.crear(
                mensajeUsuario,
                excepcion.getMessage(),
                excepcion
            );
        }
    }

    @Override
    public AdministradorDao obtenerAdministradorDao() {
        return new AdministradorPostgreSqlDao();
    }

    @Override
    public AplicacionSaldoDao obtenerAplicacionSaldoDao() {
        return new AplicacionSaldoPostgreSqlDao();
    }

    @Override
    public CategoriaDao obtenerCategoriaDao() {
        return new CategoriaPostgreSqlDao();
    }

    @Override
    public CiudadDao obtenerCiudadDao() {
        return new CiudadPostgreSqlDao();
    }

    @Override
    public ClienteDao obtenerClienteDao() {
        return new ClientePostgreSqlDao();
    }

    @Override
    public ClienteNoRegistradoDao obtenerClienteNoRegistradoDao() {
        return new ClienteNoRegistradoPostgreSqlDao();
    }

    @Override
    public ClienteRegistradoDao obtenerClienteRegistradoDao() {
        return new ClienteRegistradoPostgreSqlDao();
    }

    @Override
    public ClienteRegistradoJDao obtenerClienteRegistradoJDao() {
        return new ClienteRegistradoJPostgreSqlDao();
    }

    @Override
    public ClienteRegistradoNDao obtenerClienteRegistradoNDao() {
        return new ClienteRegistradoNPostgreSqlDao();
    }

    @Override
    public CompraDao obtenerCompraDao() {
        return new CompraPostgreSqlDao();
    }

    @Override
    public DepartamentoDao obtenerDepartamentoDao() {
        return new DepartamentoPostgreSqlDao();
    }

    @Override
    public DetalleCompraDao obtenerDetalleCompraDao() {
        return new DetalleCompraPostgreSqlDao();
    }

    @Override
    public DetalleIngresoDao obtenerDetalleIngresoDao() {
        return new DetalleIngresoPostgreSqlDao();
    }

    @Override
    public DevolucionDao obtenerDevolucionDao() {
        return new DevolucionPostgreSqlDao();
    }

    @Override
    public EmpleadoDao obtenerEmpleadoDao() {
        return new EmpleadoPostgreSqlDao();
    }

    @Override
    public EstadoCompraDao obtenerEstadoCompraDao() {
        return new EstadoCompraPostgreSqlDao();
    }

    @Override
    public EstadoInventarioDao obtenerEstadoInventarioDao() {
        return new EstadoInventarioPostgreSqlDao();
    }

    @Override
    public EstadoProcesoCompraDao obtenerEstadoProcesoCompraDao() {
        return new EstadoProcesoCompraPostgreSqlDao();
    }

    @Override
    public EstadoSaldoFavorDao obtenerEstadoSaldoFavorDao() {
        return new EstadoSaldoFavorPostgreSqlDao();
    }

    @Override
    public FacturaDao obtenerFacturaDao() {
        return new FacturaPostgreSqlDao();
    }

    @Override
    public IngresoInventarioDao obtenerIngresoInventarioDao() {
        return new IngresoInventarioPostgreSqlDao();
    }

    @Override
    public MarcaDao obtenerMarcaDao() {
        return new MarcaPostgreSqlDao();
    }

    @Override
    public MetodoPagoDao obtenerMetodoPagoDao() {
        return new MetodoPagoPostgreSqlDao();
    }

    @Override
    public MotivoDao obtenerMotivoDao() {
        return new MotivoPostgreSqlDao();
    }

    @Override
    public PagoDao obtenerPagoDao() {
        return new PagoPostgreSqlDao();
    }

    @Override
    public PagoNormalDao obtenerPagoNormalDao() {
        return new PagoNormalPostgreSqlDao();
    }

    @Override
    public PaisDao obtenerPaisDao() {
        return new PaisPostgreSqlDao();
    }

    @Override
    public PersonaDao obtenerPersonaDao() {
        return new PersonaPostgreSqlDao();
    }

    @Override
    public PrefijoDao obtenerPrefijoDao() {
        return new PrefijoPostgreSqlDao();
    }

    @Override
    public ProcesoCompraDao obtenerProcesoCompraDao() {
        return new ProcesoCompraPostgreSqlDao();
    }

    @Override
    public ProductoDao obtenerProductoDao() {
        return new ProductoPostgreSqlDao();
    }

    @Override
    public ProductoSedeDao obtenerProductoSedeDao() {
        return new ProductoSedePostgreSqlDao();
    }

    @Override
    public SaldoFavorDao obtenerSaldoFavorDao() {
        return new SaldoFavorPostgreSqlDao();
    }

    @Override
    public SedeDao obtenerSedeDao() {
        return new SedePostgreSqlDao();
    }

    @Override
    public TipoDocumentoDao obtenerTipoDocumentoDao() {
        return new TipoDocumentoPostgreSqlDao();
    }

    @Override
    public VendedorDao obtenerVendedorDao() {
        return new VendedorPostgreSqlDao();
    }
}