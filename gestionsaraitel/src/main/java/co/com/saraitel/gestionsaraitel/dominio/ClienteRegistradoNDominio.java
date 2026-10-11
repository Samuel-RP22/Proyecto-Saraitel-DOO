package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoNDominio {

    private UUID id;
    private ClienteRegistradoDominio clienteRegistrado;
    private PersonaDominio persona;

    public ClienteRegistradoNDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.clienteRegistrado = new ClienteRegistradoDominio();
        this.persona = new PersonaDominio();
    }

    public ClienteRegistradoNDominio(final UUID id,
            final ClienteRegistradoDominio clienteRegistrado,
            final PersonaDominio persona) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.clienteRegistrado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
                (clienteRegistrado, new ClienteRegistradoDominio());
        this.persona = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
                (persona, new PersonaDominio());
    }

    public UUID getId() {
        return id;
    }

    public ClienteRegistradoDominio getClienteRegistrado() {
        return clienteRegistrado;
    }

    public PersonaDominio getPersona() {
        return persona;
    }
}