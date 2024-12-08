package pe.edu.cibertec.t2sw_santosvieri.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.t2sw_santosvieri.model.dto.response.MedicoResponse;
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

}
