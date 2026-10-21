package co.com.saraitel.gestionsaraitel.controlador.impl;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.saraitel.gestionsaraitel.controlador.AbstractRestController;
import co.com.saraitel.gestionsaraitel.controlador.respuesta.RespuestaOk;
import co.com.saraitel.gestionsaraitel.dto.PaisDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.PaisFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.impl.PaisFachadaImpl;

//...../api/v1/paises?id=valor&nombre=Colombia
// ...../api/v1/paises?nombre=Colombia&id=valor
// ...../api/v1/paises?id=valor
// ...../api/v1/paises?nombre=Colombia
// ...../api/v1/paises
//...../api/v1/paises?paisResidencia=valor  BAD PRACTICE
//...../api/v1/paises?pais-residencia=valor  BEST PRACTICE

@RestController
@RequestMapping("/api/v1/paises")
public class PaisControlador extends AbstractRestController {
	MENSAJE DE ERROR SI NO ENCUENTRA OBJETO DE DOMINIO CON ID CORRESPONDIENTE
    private PaisFachada fachada = new PaisFachadaImpl();

    @GetMapping("/dummy")
    public PaisDTO obtenerDummy() {
        return new PaisDTO();
    }

    @PostMapping
    public ResponseEntity<RespuestaOk<String>> registrarInformacionNuevoPais(@RequestBody PaisDTO pais) {
        fachada.registrarInformacionNuevoPais(pais);
        RespuestaOk<String> respuesta = RespuestaOk
                .crear("Se ha registrado la información del nuevo país de forma exitosa");
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaOk<PaisDTO>> consultarPorId(@PathVariable UUID id) {
        var pais = fachada.consultarPorid(id);
        RespuestaOk<PaisDTO> respuesta = RespuestaOk.crear(pais);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping
    public ResponseEntity<RespuestaOk<PaisDTO>> consultarPorFiltro(PaisDTO filtro) {
        var paises = fachada.consultarPorFiltro(filtro);
        RespuestaOk<PaisDTO> respuesta = RespuestaOk.crear(paises);
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespuestaOk<String>> modificarInformacionPaisExistente(@PathVariable UUID id,
            @RequestBody PaisDTO datos) {
        fachada.modificarInformacionPaisExistente(id, datos);
        RespuestaOk<String> respuesta = RespuestaOk.crear("Se ha modificado la información del país de forma exitosa");
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RespuestaOk<String>> darBajaInformacionPaisExistente(@PathVariable UUID id) {
        fachada.darBajaInformacionPaisExistente(id);
        RespuestaOk<String> respuesta = RespuestaOk
                .crear("Se ha dado de baja la información del país de forma exitosa");
        return ResponseEntity.ok(respuesta);
    }
}