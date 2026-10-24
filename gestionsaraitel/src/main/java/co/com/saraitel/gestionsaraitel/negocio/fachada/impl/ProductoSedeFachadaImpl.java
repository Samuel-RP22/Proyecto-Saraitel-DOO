package co.com.saraitel.gestionsaraitel.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dto.ProductoSedeDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.ProductoSedeFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl.ProductoSedeDTOAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.impl.ProductoSedeNegocioImpl;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelFachadaExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.mensajes.CatalogoMensajes;

public class ProductoSedeFachadaImpl implements ProductoSedeFachada {

	@Override
	public void registrarInformacionNuevoProductoSede(ProductoSedeDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var productoSedeNegocio = new ProductoSedeNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var productoSedeDominio = ProductoSedeDTOAssembler.getInstance().convertirADominio(datos);
			productoSedeNegocio.registrarInformacionNuevoProductoSede(productoSedeDominio);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.ProductoSedeFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_PRODUCTO_SEDE;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarInformacionProductoSedeExistente(UUID id, ProductoSedeDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var productoSedeNegocio = new ProductoSedeNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var productoSedeDominio = ProductoSedeDTOAssembler.getInstance().convertirADominio(datos);
			productoSedeNegocio.modificarInformacionProductoSedeExistente(id, productoSedeDominio);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.ProductoSedeFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_MODIFICANDO_PRODUCTO_SEDE;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<ProductoSedeDTO> consultarPorFiltro(ProductoSedeDTO filtro) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var productoSedeNegocio = new ProductoSedeNegocioImpl(daoFactory);

		try {
			var filtroDominio = ProductoSedeDTOAssembler.getInstance().convertirADominio(filtro);
			var listaProductosSede = productoSedeNegocio.consultarPorFiltro(filtroDominio);
			return ProductoSedeDTOAssembler.getInstance().convertirADTO(listaProductosSede);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.ProductoSedeFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PRODUCTOS_SEDE_CON_FILTRO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<ProductoSedeDTO> consultarTodos() {
		var daoFactory = DAOFactory.obtenerFactoria();
		var productoSedeNegocio = new ProductoSedeNegocioImpl(daoFactory);

		try {
			var listaProductosSede = productoSedeNegocio.consultarTodos();
			return ProductoSedeDTOAssembler.getInstance().convertirADTO(listaProductosSede);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.ProductoSedeFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PRODUCTOS_SEDE;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public ProductoSedeDTO consultarPorId(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var productoSedeNegocio = new ProductoSedeNegocioImpl(daoFactory);

		try {
			var productoSedeDominio = productoSedeNegocio.consultarPorid(id);
			return ProductoSedeDTOAssembler.getInstance().convertirADTO(productoSedeDominio);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.ProductoSedeFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PRODUCTO_SEDE_POR_ID;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}