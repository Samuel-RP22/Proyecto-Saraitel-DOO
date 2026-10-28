package co.com.saraitel.gestionsaraitel.configuracion;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.SecurityFilterChain;

import co.com.saraitel.gestionsaraitel.controlador.EmpleadoAutenticado;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SeguridadConfiguracion {

	private static final String CODIGO_EMPLEADO_NO_ACTIVO = "empleado_no_activo";
	private static final String ACCESO_DENEGADO = "/acceso-denegado.html";
	private static final String LOGOUT = "/logout";
	private static final String LOGIN_LOGOUT_INVALIDO = "/login?error";
	private static final String PROCESO_COMPRA = "/proceso-compra.html";
	private static final String SOLICITUD_AUTORIZACION_NO_ENCONTRADA = "authorization_request_not_found";
	private static final String STATE_INVALIDO = "invalid_state_parameter";
	private static final String PARAMETRO_PROMPT = "prompt";
	private static final String SELECCIONAR_CUENTA = "select_account";

	@Bean
	SecurityFilterChain filtroSeguridad(HttpSecurity http, ClientRegistrationRepository repositorioClientes) {
		http.authorizeHttpRequests(
				autorizacion -> autorizacion.requestMatchers(ACCESO_DENEGADO).permitAll().anyRequest().authenticated())
				.oauth2Login(
						oauth -> oauth
								.authorizationEndpoint(autorizacion -> autorizacion
										.authorizationRequestResolver(resolverConSeleccionDeCuenta(repositorioClientes)))
								.userInfoEndpoint(usuario -> usuario.oidcUserService(this::validarEmpleadoActivo))
								.defaultSuccessUrl(PROCESO_COMPRA, true).failureHandler(this::manejarFalloDeIngreso))
				.csrf(csrf -> csrf.spa()).cors(Customizer.withDefaults())
				.logout(logout -> logout.logoutUrl(LOGOUT).logoutSuccessUrl(PROCESO_COMPRA));

		return http.build();
	}

	private OAuth2AuthorizationRequestResolver resolverConSeleccionDeCuenta(
			ClientRegistrationRepository repositorioClientes) {
		var resolver = new DefaultOAuth2AuthorizationRequestResolver(repositorioClientes,
				OAuth2AuthorizationRequestRedirectFilter.DEFAULT_AUTHORIZATION_REQUEST_BASE_URI);
		resolver.setAuthorizationRequestCustomizer(solicitud -> solicitud
				.additionalParameters(parametros -> parametros.put(PARAMETRO_PROMPT, SELECCIONAR_CUENTA)));
		return resolver;
	}

	private OidcUser validarEmpleadoActivo(OidcUserRequest solicitud) {
		var usuario = new OidcUserService().loadUser(solicitud);
		if (!EmpleadoAutenticado.esEmpleadoActivo(usuario)) {
			var mensajeUsuario = CatalogoMensajes.EmpleadoAutenticado.USUARIO_NO_ES_EMPLEADO_ACTIVO_PARA_INGRESAR;
			throw new OAuth2AuthenticationException(new OAuth2Error(CODIGO_EMPLEADO_NO_ACTIVO), mensajeUsuario);
		}
		return usuario;
	}

	private void manejarFalloDeIngreso(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException excepcion) throws IOException {
		var codigoError = excepcion instanceof OAuth2AuthenticationException excepcionOAuth
				? excepcionOAuth.getError().getErrorCode()
				: UtilTexto.VACIA;
		if (CODIGO_EMPLEADO_NO_ACTIVO.equals(codigoError)) {
			cerrarSesionAnterior(request);
			response.sendRedirect(ACCESO_DENEGADO);
		} else if (SOLICITUD_AUTORIZACION_NO_ENCONTRADA.equals(codigoError) || STATE_INVALIDO.equals(codigoError)) {
			cerrarSesionAnterior(request);
			response.sendRedirect(PROCESO_COMPRA);
		} else {
			response.sendRedirect(LOGIN_LOGOUT_INVALIDO);
		}
	}

	private void cerrarSesionAnterior(HttpServletRequest request) {
		var sesionAnterior = request.getSession(false);
		if (!UtilObjeto.esNulo(sesionAnterior)) {
			sesionAnterior.invalidate();
		}
		SecurityContextHolder.clearContext();
	}
}