package pe.edu.cibertec.t2sw_santosvieri.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.t2sw_santosvieri.model.bd.Medico;
import pe.edu.cibertec.t2sw_santosvieri.model.dto.request.MedicoRequest;
import pe.edu.cibertec.t2sw_santosvieri.model.dto.response.MedicoResponse;
import pe.edu.cibertec.t2sw_santosvieri.repository.MedicoRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MedicoService implements IMedicoService{

    private final MedicoRepository medicoRepository;

    @Override
    public List<MedicoResponse> listadoMedico() {
        return convertirListaMedicoResponse(medicoRepository.findAll());
    }

    @Override
    public MedicoResponse guardarMedico(MedicoRequest request) {
        Medico medico = new Medico();
        medico.setNommedico(request.getNommedico());
        medico.setApemedico(request.getApemedico());
        medico.setFechnacmedico(request.getFechanacmedico());
        return convertirMedicoResponse(medicoRepository.save(medico));
    }

    @Override
    public MedicoResponse actualizarMedico(int idmedico, MedicoRequest request) {
        Medico medico = medicoRepository.findById(idmedico).orElseThrow(() -> new RuntimeException("No se encontro al medico"));
        medico.setNommedico(request.getNommedico());
        medico.setApemedico(request.getApemedico());
        medico.setFechnacmedico(request.getFechanacmedico());
        return convertirMedicoResponse(medicoRepository.save(medico));
    }

    @Override
    public MedicoResponse buscarMedico(int idmedico) {
        Medico medicoBuscar = medicoRepository.findById(idmedico).orElseThrow(() -> new RuntimeException("No se encontro al medico"));
        return convertirMedicoResponse(medicoBuscar);
    }

    //convertir
    private List<MedicoResponse> convertirListaMedicoResponse(List<Medico> medicos) {
        List<MedicoResponse> response = new ArrayList<>();
        for (Medico medico : medicos) {
            response.add(convertirMedicoResponse(medico));
        }
        return response;
    }

    private MedicoResponse convertirMedicoResponse(Medico medico) {
        return MedicoResponse.builder()
                .idmedico(medico.getIdmedico())
                .nommedico(medico.getNommedico())
                .apemedico(medico.getApemedico())
                .fechanacmedico(medico.getFechnacmedico())
                .build();
    }
}
