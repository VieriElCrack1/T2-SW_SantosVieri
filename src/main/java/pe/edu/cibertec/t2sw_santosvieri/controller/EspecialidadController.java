package pe.edu.cibertec.t2sw_santosvieri.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.t2sw_santosvieri.model.dto.request.EspecialidadRequest;
import pe.edu.cibertec.t2sw_santosvieri.model.dto.response.EspecialidadResponse;
import pe.edu.cibertec.t2sw_santosvieri.model.dto.response.Respuesta;
import pe.edu.cibertec.t2sw_santosvieri.service.IEspecialidadService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/especialidad")
public class EspecialidadController {

    private final IEspecialidadService especialidadService;

    //listado especialidades
    @GetMapping
    public ResponseEntity<List<EspecialidadResponse>> listaEspecialidad() {
        return new ResponseEntity<>(especialidadService.listaEspecialidad(), HttpStatus.OK);
    }

    //buscar especialidad
    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadResponse> buscarEspecialidad(@PathVariable("id") Integer idespecialidad) {
        EspecialidadResponse response = especialidadService.buscarEspecialidad(idespecialidad);
        if(response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //registrar especialidad
    @PostMapping
    public ResponseEntity<Respuesta<EspecialidadResponse>> registrarEspecialidad(@RequestBody EspecialidadRequest request) {
        try{
            EspecialidadResponse especialidad = especialidadService.guardarEspecialidad(request);
            Respuesta<EspecialidadResponse> respuesta = Respuesta.<EspecialidadResponse>builder()
                    .mensaje("Especialidad registrado exitosamente")
                    .data(especialidad)
                    .build();
            return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
        }catch (DataAccessException e) {
            Respuesta<EspecialidadResponse> respuesta = Respuesta.<EspecialidadResponse>builder()
                    .mensaje("No se pudo acceder a la base de datos")
                    .errorMensaje(HttpStatus.INTERNAL_SERVER_ERROR.name())
                    .build();
            return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e) {
            Respuesta<EspecialidadResponse> respuesta = Respuesta.<EspecialidadResponse>builder()
                    .mensaje("No se realizo el registro de especialidad")
                    .errorMensaje(HttpStatus.BAD_REQUEST.name())
                    .build();
            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }
}
