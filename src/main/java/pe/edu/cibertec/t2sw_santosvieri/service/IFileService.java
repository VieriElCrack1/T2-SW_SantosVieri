package pe.edu.cibertec.t2sw_santosvieri.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFileService {
    void guardarArchivo(MultipartFile file) throws Exception;
    void guardarArchivos(List<MultipartFile> files) throws Exception;
}
