package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoDominio {

    private UUID id;
    private ClienteDominio cliente;
    private boolean clienteNaturalDefecto;

    public ClienteRegistradoDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.cliente = new ClienteDominio();
        this.clienteNaturalDefecto = false;
    }

    public ClienteRegistradoDominio(final UUID id, final ClienteDominio cliente,
            final boolean clienteNaturalDefecto) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
                (cliente, new ClienteDominio());
        this.clienteNaturalDefecto = clienteNaturalDefecto;
    }

    public UUID getId() {
        return id;
    }

    public ClienteDominio getCliente() {
        return cliente;
    }

    public boolean getClienteNaturalDefecto() {
        return clienteNaturalDefecto;
    }
}