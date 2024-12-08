package pe.edu.cibertec.t2sw_santosvieri.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.t2sw_santosvieri.model.dto.request.MedicoRequest;
import pe.edu.cibertec.t2sw_santosvieri.model.dto.response.MedicoResponse;
import pe.edu.cibertec.t2sw_santosvieri.model.dto.response.Respuesta;
import pe.edu.cibertec.t2sw_santosvieri.service.IMedicoService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/medico")
public class MedicoController {

    private final IMedicoService medicoService;

    //LISTADO MEDICO
    @GetMapping
    public ResponseEntity<List<MedicoResponse>> listaMedico() {
        List<MedicoResponse> medicoResponse = medicoService.listadoMedico();
        return new ResponseEntity<>(medicoResponse, HttpStatus.OK);
    }

    //buscar medicos
    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponse> buscarMedico(@PathVariable("id") Integer idmedico) {
        MedicoResponse response = medicoService.buscarMedico(idmedico);
        if(response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //registrar medico
    @PostMapping
    public ResponseEntity<Respuesta<MedicoResponse>> guardarMedico(@RequestBody MedicoRequest request) {
        try {
            MedicoResponse medico = medicoService.guardarMedico(request);
            Respuesta<MedicoResponse> respuesta = Respuesta.<MedicoResponse>builder()
                    .mensaje("Medico registrado exitosamente")
                    .data(medico)
                    .build();
            return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
        }catch (DataAccessException e) {
            Respuesta<MedicoResponse> respuesta = Respuesta.<MedicoResponse>builder()
                    .mensaje("No se pudo acceder a la base de datos")
                    .errorMensaje(HttpStatus.INTERNAL_SERVER_ERROR.name())
                    .build();
            return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e) {
            Respuesta<MedicoResponse> respuesta = Respuesta.<MedicoResponse>builder()
                    .mensaje("No se realizo el registro del medico")
                    .errorMensaje(HttpStatus.BAD_REQUEST.name())
                    .build();
            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    //actualizar medico
    @PutMapping
}
