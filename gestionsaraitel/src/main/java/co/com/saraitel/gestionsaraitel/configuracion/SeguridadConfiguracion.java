package co.com.saraitel.gestionsaraitel.configuracion;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.SecurityFilterChain;

import co.com.saraitel.gestionsaraitel.controlador.EmpleadoAutenticado;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SeguridadConfiguracion {

	private static final String CODIGO_EMPLEADO_NO_ACTIVO = "empleado_no_activo";

	@Bean
	SecurityFilterChain filtroSeguridad(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(autorizacion -> autorizacion.requestMatchers("/acceso-denegado.html").permitAll()
				.anyRequest().authenticated())
				.oauth2Login(oauth -> oauth
						.userInfoEndpoint(usuario -> usuario.oidcUserService(this::validarEmpleadoActivo))
						.defaultSuccessUrl("/proceso-compra.html", true).failureHandler(this::manejarFalloDeIngreso))
				.csrf(csrf -> csrf.ignoringRequestMatchers("/api/**", "/logout"))
				.logout(logout -> logout.logoutSuccessUrl("/login?logout"));

		return http.build();
	}

	// Después de que Google autentica al usuario, solo se le deja entrar si su
	// correo
	// pertenece a un empleado activo. Si no, no se crea la sesión.
	private OidcUser validarEmpleadoActivo(OidcUserRequest solicitud) {
		var usuario = new OidcUserService().loadUser(solicitud);

		if (EmpleadoAutenticado.buscarEmpleadoActivo(usuario.getEmail()).isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.EmpleadoAutenticado.USUARIO_NO_ES_EMPLEADO_ACTIVO_PARA_INGRESAR;
			throw new OAuth2AuthenticationException(new OAuth2Error(CODIGO_EMPLEADO_NO_ACTIVO), mensajeUsuario);
		}

		return usuario;
	}

	// - No es empleado activo: se cierra cualquier sesión anterior y se muestra la
	// página de acceso denegado.
	// - Atrás o recargar sobre la respuesta de Google ya usada: se cierra la sesión
	// anterior y se vuelve a
	// pedir el login, para que la cuenta que se escoja ahora pase otra vez por la
	// validación de empleado activo.
	// - Cualquier otro error: la página de login de siempre.
	private void manejarFalloDeIngreso(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException excepcion) throws IOException {
		var codigoError = excepcion instanceof OAuth2AuthenticationException excepcionOAuth
				? excepcionOAuth.getError().getErrorCode()
				: "";

		if (CODIGO_EMPLEADO_NO_ACTIVO.equals(codigoError)) {
			cerrarSesionAnterior(request);
			response.sendRedirect("/acceso-denegado.html");
		} else if ("authorization_request_not_found".equals(codigoError)
				|| "invalid_state_parameter".equals(codigoError)) {
			cerrarSesionAnterior(request);
			response.sendRedirect("/proceso-compra.html");
		} else {
			response.sendRedirect("/login?error");
		}
	}

	// Un intento de ingreso fallido nunca debe dejar viva la sesión de una cuenta
	// anterior.
	private void cerrarSesionAnterior(HttpServletRequest request) {
		var sesionAnterior = request.getSession(false);

		if (sesionAnterior != null) {
			sesionAnterior.invalidate();
		}

		SecurityContextHolder.clearContext();
	}
}