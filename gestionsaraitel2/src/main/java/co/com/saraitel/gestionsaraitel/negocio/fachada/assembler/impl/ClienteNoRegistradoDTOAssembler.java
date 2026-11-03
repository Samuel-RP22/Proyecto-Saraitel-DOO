
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.ClienteDominio;
import co.com.saraitel.gestionsaraitel.dominio.ClienteNoRegistradoDominio;
import co.com.saraitel.gestionsaraitel.dto.ClienteDTO;
import co.com.saraitel.gestionsaraitel.dto.ClienteNoRegistradoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ClienteNoRegistradoDTOAssembler
        implements DTOAssembler<ClienteNoRegistradoDominio, ClienteNoRegistradoDTO> {

    private static final DTOAssembler<ClienteNoRegistradoDominio, ClienteNoRegistradoDTO> instancia =
            new ClienteNoRegistradoDTOAssembler();

    private ClienteNoRegistradoDTOAssembler() {
    }

    public static DTOAssembler<ClienteNoRegistradoDominio, ClienteNoRegistradoDTO> obtenerInstancia() {
        return instancia;
    }

    @Override
    public ClienteNoRegistradoDTO convertirADTO(ClienteNoRegistradoDominio dominio) {
        var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                dominio, ClienteNoRegistradoDominio.obtenerValorDefecto());

        ClienteDTO clienteDTO = ClienteDTOAssembler.obtenerInstancia()
                .convertirADTO(dominioTmp.getCliente());

        return new ClienteNoRegistradoDTO(
                dominioTmp.getId(),
                clienteDTO,
                dominioTmp.getNombre(),
                dominioTmp.getApellido(),
                dominioTmp.getNumeroDocumento());
    }

    @Override
    public ClienteNoRegistradoDominio convertirADominio(ClienteNoRegistradoDTO dto) {
        var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                dto, new ClienteNoRegistradoDTO());

        ClienteDominio clienteDominio = ClienteDTOAssembler.obtenerInstancia()
                .convertirADominio(dtoTmp.getCliente());

        return new ClienteNoRegistradoDominio(
                dtoTmp.getId(),
                clienteDominio,
                dtoTmp.getNombre(),
                dtoTmp.getApellido(),
                dtoTmp.getNumeroDocumento());
    }

    @Override
    public List<ClienteNoRegistradoDTO> convertirADTO(
            List<ClienteNoRegistradoDominio> listaDominios) {

        var listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                listaDominios, new ArrayList<ClienteNoRegistradoDominio>());

        List<ClienteNoRegistradoDTO> listaDTO = new ArrayList<>();

        for (ClienteNoRegistradoDominio dominio : listaDominiosTmp) {
            listaDTO.add(convertirADTO(dominio));
        }

        return listaDTO;
    }
}
