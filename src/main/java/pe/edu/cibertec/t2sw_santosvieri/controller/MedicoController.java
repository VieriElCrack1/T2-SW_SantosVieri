package pe.edu.cibertec.t2sw_santosvieri.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.t2sw_santosvieri.service.IMedicoService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/medico")
public class MedicoController {

    private final IMedicoService medicoService;

    //LISTADO

}
