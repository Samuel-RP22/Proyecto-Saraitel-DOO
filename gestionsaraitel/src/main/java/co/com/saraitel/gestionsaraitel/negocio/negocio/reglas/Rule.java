package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas;

public interface Rule<O> {

	void ejecutar(O... datos);

}
