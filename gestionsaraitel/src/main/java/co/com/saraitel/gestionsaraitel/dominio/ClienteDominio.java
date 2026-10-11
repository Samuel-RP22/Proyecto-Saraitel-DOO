package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteDominio {

    private UUID id;
    private boolean esClienteRegistrado;

    public ClienteDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.esClienteRegistrado = true;
    }

    public ClienteDominio(final UUID id, final boolean esClienteRegistrado) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.esClienteRegistrado = esClienteRegistrado;
    }

    public UUID getId() {
        return id;
    }

    public boolean getEsClienteRegistrado() {
        return esClienteRegistrado;
    }
}