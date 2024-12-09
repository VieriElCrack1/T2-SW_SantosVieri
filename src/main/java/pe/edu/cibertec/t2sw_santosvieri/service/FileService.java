package pe.edu.cibertec.t2sw_santosvieri.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService implements IFileService{

    private final Path folder = Paths.get("archivo");

    @Override
    public void guardarArchivo(MultipartFile file) throws Exception {
        String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        if(file.getSize() <= 25000000 && (extension.equals("pdf") || extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("docx"))) {
            Files.copy(file.getInputStream(), folder.resolve(file.getOriginalFilename()));
        }
        throw new RuntimeException("El maximo peso del archivo es 25MB");
    }

    @Override
    public void guardarArchivos(List<MultipartFile> files) throws Exception {
        if(files.size() != 3) {
            throw new RuntimeException("Se deben de subir 3 archivos");
        }

        for (MultipartFile file : files) {
            guardarArchivo(file);
        }
    }
}
