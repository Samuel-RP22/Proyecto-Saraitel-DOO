package co.com.saraitel.gestionsaraitel.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dto.ProductoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.ProductoFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl.ProductoDTOAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.impl.ProductoNegocioImpl;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelFachadaExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.mensajes.CatalogoMensajes;

public class ProductoFachadaImpl implements ProductoFachada {

	@Override
	public void registrarInformacionNuevoProducto(ProductoDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var productoNegocio = new ProductoNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var productoDominio = ProductoDTOAssembler.getInstance().convertirADominio(datos);
			productoNegocio.registrarInformacionNuevoProducto(productoDominio);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.ProductoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_PRODUCTO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarInformacionProductoExistente(UUID id, ProductoDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var productoNegocio = new ProductoNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var productoDominio = ProductoDTOAssembler.getInstance().convertirADominio(datos);
			productoNegocio.modificarInformacionProductoExistente(id, productoDominio);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.ProductoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_MODIFICANDO_PRODUCTO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<ProductoDTO> consultarPorFiltro(ProductoDTO filtro) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var productoNegocio = new ProductoNegocioImpl(daoFactory);

		try {
			var filtroDominio = ProductoDTOAssembler.getInstance().convertirADominio(filtro);
			var listaProductos = productoNegocio.consultarPorFiltro(filtroDominio);
			return ProductoDTOAssembler.getInstance().convertirADTO(listaProductos);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.ProductoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PRODUCTOS_CON_FILTRO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<ProductoDTO> consultarTodos() {
		var daoFactory = DAOFactory.obtenerFactoria();
		var productoNegocio = new ProductoNegocioImpl(daoFactory);

		try {
			var listaProductos = productoNegocio.consultarTodos();
			return ProductoDTOAssembler.getInstance().convertirADTO(listaProductos);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.ProductoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PRODUCTOS;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public ProductoDTO consultarPorId(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var productoNegocio = new ProductoNegocioImpl(daoFactory);

		try {
			var productoDominio = productoNegocio.consultarPorid(id);
			return ProductoDTOAssembler.getInstance().convertirADTO(productoDominio);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.ProductoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PRODUCTO_POR_ID;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}