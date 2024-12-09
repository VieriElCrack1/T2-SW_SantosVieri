package pe.edu.cibertec.t2sw_santosvieri.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.t2sw_santosvieri.service.IFileService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/file")
public class FileController {

    private final IFileService fileService;

    //subir un archivo maximo tamaño 25MB

}
