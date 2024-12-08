package pe.edu.cibertec.t2sw_santosvieri.service;

import pe.edu.cibertec.t2sw_santosvieri.model.dto.request.MedicoRequest;
import pe.edu.cibertec.t2sw_santosvieri.model.dto.response.MedicoResponse;

import java.util.List;

public interface IMedicoService {
    List<MedicoResponse> listadoMedico();
    MedicoResponse guardarMedico(MedicoRequest request);
    MedicoResponse actualizarMedico(int idmedico, MedicoRequest request);
    MedicoResponse buscarMedico(int idmedico);
}
