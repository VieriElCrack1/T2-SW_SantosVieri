package pe.edu.cibertec.t2sw_santosvieri.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.cibertec.t2sw_santosvieri.service.IFileService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/file")
public class FileController {

    private final IFileService fileService;

    //subir un archivo maximo tamaño 25MB
    @PostMapping("/archivo")
    public ResponseEntity<String> guardarArchivo(@RequestParam("file") MultipartFile file) {
        try {
            fileService.guardarArchivo(file);
            return new ResponseEntity<>("Se guardo el archivo exitosamente", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("No se subio el archivo : " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //subir 3 archivos en simultaneo
    @PostMapping("/archivos")
    public ResponseEntity<String> guardarArchivos(@RequestParam("files") List<MultipartFile> files) {
        try {
            fileService.guardarArchivos(files);
            return new ResponseEntity<>("Se guardo los archivos exitosamente", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("No se guardo los archivos : " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
