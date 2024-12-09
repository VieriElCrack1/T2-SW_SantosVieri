package pe.edu.cibertec.t2sw_santosvieri.service;

import pe.edu.cibertec.t2sw_santosvieri.model.dto.request.EspecialidadRequest;
import pe.edu.cibertec.t2sw_santosvieri.model.dto.response.EspecialidadResponse;

import java.util.List;

public interface IEspecialidadService {
    List<EspecialidadResponse> listaEspecialidad();
    EspecialidadResponse guardarEspecialidad(EspecialidadRequest request);
    EspecialidadResponse actualizarEspecialidad(int idespecialidad,EspecialidadRequest request);
    EspecialidadResponse buscarEspecialidad(int idespecialidad);
}
