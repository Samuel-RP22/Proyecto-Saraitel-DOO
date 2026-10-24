
package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.PersonaDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.PersonaNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.PersonaEntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PersonaNegocioImpl implements PersonaNegocio {

    private final DAOFactory daoFactory;

    public PersonaNegocioImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void registrarInformacionNuevoPais(final PersonaDominio datos) {
        var personaEntidad = PersonaEntidadAssembler.getInstance().convertirAEntidad(datos);

        personaEntidad.setId(generarIdPersonaUnico());

        daoFactory.obtenerPersonaDao().crear(personaEntidad);
    }

    private UUID generarIdPersonaUnico() {
        UUID id;
        boolean existe;

        do {
            id = UUID.randomUUID();
            var personaExistente = daoFactory.obtenerPersonaDao().consultarPorId(id);
            existe = !personaExistente.getId().equals(UtilUUID.obtenerUUIDDefecto());
        } while (existe);

        return id;
    }

    @Override
    public void modificarInformacionPaisExistente(final UUID id, final PersonaDominio datos) {
        var personaExistente = daoFactory.obtenerPersonaDao().consultarPorId(id);

        if (personaExistente.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
            return;
        }

        var entidadActualizada = PersonaEntidadAssembler.getInstance().convertirAEntidad(datos);

        daoFactory.obtenerPersonaDao().actualizar(id, entidadActualizada);
    }

    @Override
    public void darBajaInformacionPaisExistente(final UUID id) {
        var personaExistente = daoFactory.obtenerPersonaDao().consultarPorId(id);

        if (personaExistente.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
            return;
        }

        daoFactory.obtenerPersonaDao().eliminar(id);
    }

    @Override
    public List<PersonaDominio> consultarPorFiltro(final PersonaDominio filtro) {
        var entidadFiltro = PersonaEntidadAssembler.getInstance().convertirAEntidad(filtro);

        return daoFactory.obtenerPersonaDao().consultarPorFiltro(entidadFiltro).stream()
                .map(PersonaEntidadAssembler.getInstance()::convertirADominio).toList();
    }

    @Override
    public List<PersonaDominio> consultarTodos() {
        return daoFactory.obtenerPersonaDao().consultarTodos().stream()
                .map(PersonaEntidadAssembler.getInstance()::convertirADominio).toList();
    }

    @Override
    public PersonaDominio consultarPorid(final UUID id) {
        var entidad = daoFactory.obtenerPersonaDao().consultarPorId(id);

        if (entidad.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
            return PersonaDominio.obtenerValorDefecto();
        }

        return PersonaEntidadAssembler.getInstance().convertirADominio(entidad);
    }
}
