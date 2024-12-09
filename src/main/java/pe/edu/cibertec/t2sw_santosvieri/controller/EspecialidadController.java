package pe.edu.cibertec.t2sw_santosvieri.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.t2sw_santosvieri.model.dto.response.EspecialidadResponse;
import pe.edu.cibertec.t2sw_santosvieri.service.IEspecialidadService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/especialidad")
public class EspecialidadController {

    private final IEspecialidadService especialidadService;

    //listado especialidades

}