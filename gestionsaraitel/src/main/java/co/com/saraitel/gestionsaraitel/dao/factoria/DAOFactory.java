
package co.com.saraitel.gestionsaraitel.dao.factoria;

import java.sql.Connection;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.*;
import co.com.saraitel.gestionsaraitel.dao.factoria.enums.FactoriaEnum;
import co.com.saraitel.gestionsaraitel.dao.factoria.impl.PostgreSqlDaoFactory;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionsaraitelTransversalException;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilSQL;

public abstract class DAOFactory {

    private Connection conexion;
    private static FactoriaEnum factoria = FactoriaEnum.POSTGRESQL;

    public static DAOFactory obtenerFactoria() {
        switch (factoria) {
        case POSTGRESQL:
            return new PostgreSqlDaoFactory();
        default:
            var mensajeUsuario = CatalogoMensajes.DAOFactory
                .USUARIO_ERROR_FUENTE_INFORMACION_NO_HABILITADA;
            throw GestionsaraitelTransversalException
                .crear(mensajeUsuario);
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

    public abstract AdministradorDao obtenerAdministradorDao();

    public abstract AplicacionSaldoDao obtenerAplicacionSaldoDao();

    public abstract CategoriaDao obtenerCategoriaDao();

    public abstract CiudadDao obtenerCiudadDao();

    public abstract ClienteDao obtenerClienteDao();

    public abstract ClienteNoRegistradoDao obtenerClienteNoRegistradoDao();

    public abstract ClienteRegistradoDao obtenerClienteRegistradoDao();

    public abstract ClienteRegistradoJDao obtenerClienteRegistradoJDao();

    public abstract ClienteRegistradoNDao obtenerClienteRegistradoNDao();

    public abstract CompraDao obtenerCompraDao();

    public abstract DepartamentoDao obtenerDepartamentoDao();

    public abstract DetalleCompraDao obtenerDetalleCompraDao();

    public abstract DetalleIngresoDao obtenerDetalleIngresoDao();

    public abstract DevolucionDao obtenerDevolucionDao();

    public abstract EmpleadoDao obtenerEmpleadoDao();

    public abstract EstadoCompraDao obtenerEstadoCompraDao();

    public abstract EstadoInventarioDao obtenerEstadoInventarioDao();

    public abstract EstadoProcesoCompraDao obtenerEstadoProcesoCompraDao();

    public abstract EstadoSaldoFavorDao obtenerEstadoSaldoFavorDao();

    public abstract FacturaDao obtenerFacturaDao();

    public abstract IngresoInventarioDao obtenerIngresoInventarioDao();

    public abstract MarcaDao obtenerMarcaDao();

    public abstract MetodoPagoDao obtenerMetodoPagoDao();

    public abstract MotivoDao obtenerMotivoDao();

    public abstract PagoDao obtenerPagoDao();

    public abstract PagoNormalDao obtenerPagoNormalDao();

    public abstract PaisDao obtenerPaisDao();

    public abstract PersonaDao obtenerPersonaDao();

    public abstract PrefijoDao obtenerPrefijoDao();

    public abstract ProcesoCompraDao obtenerProcesoCompraDao();

    public abstract ProductoDao obtenerProductoDao();

    public abstract ProductoSedeDao obtenerProductoSedeDao();

    public abstract SaldoFavorDao obtenerSaldoFavorDao();

    public abstract SedeDao obtenerSedeDao();

    public abstract TipoDocumentoDao obtenerTipoDocumentoDao();

    public abstract VendedorDao obtenerVendedorDao();
}