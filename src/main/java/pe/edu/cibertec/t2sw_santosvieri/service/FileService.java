package pe.edu.cibertec.t2sw_santosvieri.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService implements IFileService{

    private final Path folderArchivo = Paths.get("archivo");
    private final Path folderArchivos = Paths.get("archivos");

    @Override
    public void guardarArchivo(MultipartFile file) throws Exception {
        if(file.getSize() > 25000000) {
            throw new RuntimeException("El maximo peso del archivo es 25MB");
        }

        String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        if (!(extension.equals("pdf") || extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("docx"))) {
            throw new RuntimeException("La extension es invalida");
        }

        Files.copy(file.getInputStream(), folderArchivo.resolve(file.getOriginalFilename()));
    }

    @Override
    public void guardarArchivos(List<MultipartFile> files) throws Exception {
        if(files.size() != 3) {
            throw new RuntimeException("Se deben de subir 3 archivos");
        }

        for (MultipartFile file : files) {
            cargarArchivos(file);
        }
    }

    private void cargarArchivos(MultipartFile file) throws Exception{
        Files.copy(file.getInputStream(), folderArchivos.resolve(file.getOriginalFilename()));
    }
}
