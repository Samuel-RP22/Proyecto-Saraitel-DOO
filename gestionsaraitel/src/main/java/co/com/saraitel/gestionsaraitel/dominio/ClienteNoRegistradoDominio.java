package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteNoRegistradoDominio {

    private UUID id;
    private ClienteDominio cliente;

    public ClienteNoRegistradoDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.cliente = new ClienteDominio();
    }

    public ClienteNoRegistradoDominio(final UUID id, final ClienteDominio cliente) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
                (cliente, new ClienteDominio());
    }

    public UUID getId() {
        return id;
    }

    public ClienteDominio getCliente() {
        return cliente;
    }
}