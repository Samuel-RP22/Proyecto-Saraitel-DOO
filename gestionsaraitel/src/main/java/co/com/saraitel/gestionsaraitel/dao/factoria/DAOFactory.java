package co.com.saraitel.gestionsaraitel.dao.factoria;

import java.sql.Connection;

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
import co.com.saraitel.gestionsaraitel.dao.factoria.enums.FactoriaEnum;
import co.com.saraitel.gestionsaraitel.dao.factoria.impl.PostgreSqlDaoFactory;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionsaraitelTransversalException;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilSQL;

public abstract class DAOFactory {

    private Connection conexion;
    private static FactoriaEnum factoria = FactoriaEnum.POSTGRESQL;

    public static DAOFactory obtenerFactoria() {
    	if (factoria == FactoriaEnum.POSTGRESQL) {
    	    return new PostgreSqlDaoFactory();
    	} else {
    	    var mensajeUsuario = CatalogoMensajes.DAOFactory
    	            .USUARIO_ERROR_FUENTE_INFORMACION_NO_HABILITADA;
    	    throw GestionsaraitelTransversalException.crear(mensajeUsuario);
    	}
    }

    protected DAOFactory() {
    }

    protected DAOFactory(Connection conexion) {
        setConexion(conexion);
    }

    protected Connection getConexion() {
        return conexion;
    }

    protected void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    protected abstract void abrirConexion();

    public void cerrarConexion() {
        UtilSQL.cerrarConexion(conexion);
    }

    public void iniciarTransaccion() {
        UtilSQL.iniciarTransaccion(conexion);
    }

    public void confirmarTransaccion() {
        UtilSQL.confirmarTransaccion(conexion);
    }

    public void cancelarTransaccion() {
        UtilSQL.cancelarTransaccion(conexion);
    }

    public abstract AdministradorDAO obtenerAdministradorDao();

    public abstract AplicacionSaldoDAO obtenerAplicacionSaldoDao();

    public abstract CategoriaDAO obtenerCategoriaDao();

    public abstract CiudadDAO obtenerCiudadDao();

    public abstract ClienteDAO obtenerClienteDao();

    public abstract ClienteNoRegistradoDAO obtenerClienteNoRegistradoDao();

    public abstract ClienteRegistradoDAO obtenerClienteRegistradoDao();

    public abstract ClienteRegistradoJDAO obtenerClienteRegistradoJDao();

    public abstract ClienteRegistradoNDAO obtenerClienteRegistradoNDao();

    public abstract CompraDAO obtenerCompraDao();

    public abstract DepartamentoDAO obtenerDepartamentoDao();

    public abstract DetalleCompraDAO obtenerDetalleCompraDao();

    public abstract DetalleIngresoDAO obtenerDetalleIngresoDao();

    public abstract DevolucionDAO obtenerDevolucionDao();

    public abstract EmpleadoDAO obtenerEmpleadoDao();

    public abstract EstadoCompraDAO obtenerEstadoCompraDao();

    public abstract EstadoInventarioDAO obtenerEstadoInventarioDao();

    public abstract EstadoProcesoCompraDAO obtenerEstadoProcesoCompraDao();

    public abstract EstadoSaldoFavorDAO obtenerEstadoSaldoFavorDao();

    public abstract FacturaDAO obtenerFacturaDao();

    public abstract IngresoInventarioDAO obtenerIngresoInventarioDao();

    public abstract MarcaDAO obtenerMarcaDao();

    public abstract MetodoPagoDAO obtenerMetodoPagoDao();

    public abstract MotivoDAO obtenerMotivoDao();

    public abstract PagoDAO obtenerPagoDao();

    public abstract PagoNormalDAO obtenerPagoNormalDao();

    public abstract PaisDAO obtenerPaisDao();

    public abstract PersonaDAO obtenerPersonaDao();

    public abstract PrefijoDAO obtenerPrefijoDao();

    public abstract ProcesoCompraDAO obtenerProcesoCompraDao();

    public abstract ProductoDAO obtenerProductoDao();

    public abstract ProductoSedeDAO obtenerProductoSedeDao();

    public abstract SaldoFavorDAO obtenerSaldoFavorDao();

    public abstract SedeDAO obtenerSedeDao();

    public abstract TipoDocumentoDAO obtenerTipoDocumentoDao();

    public abstract VendedorDAO obtenerVendedorDao();
}