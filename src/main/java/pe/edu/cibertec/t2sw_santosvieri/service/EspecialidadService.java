package pe.edu.cibertec.t2sw_santosvieri.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.t2sw_santosvieri.model.bd.Especialidad;
import pe.edu.cibertec.t2sw_santosvieri.model.bd.Medico;
import pe.edu.cibertec.t2sw_santosvieri.model.dto.request.EspecialidadRequest;
import pe.edu.cibertec.t2sw_santosvieri.model.dto.response.EspecialidadResponse;
import pe.edu.cibertec.t2sw_santosvieri.model.dto.response.MedicoResponse;
import pe.edu.cibertec.t2sw_santosvieri.repository.EspecialidadRepository;
import pe.edu.cibertec.t2sw_santosvieri.repository.MedicoRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EspecialidadService implements IEspecialidadService{

    private final EspecialidadRepository especialidadRepository;
    private final MedicoRepository medicoRepository;

    @Override
    public List<EspecialidadResponse> listaEspecialidad() {
        return convertirListEspecialidadResponse(especialidadRepository.findAll());
    }

    @Override
    public EspecialidadResponse guardarEspecialidad(EspecialidadRequest request) {
        Especialidad especialidad = new Especialidad();
        especialidad.setIdespecialidad(request.getIdespecialidad());
        especialidad.setTitulo(request.getTitulo());
        especialidad.setFuncion(request.getFuncion());
        especialidad.setFechgraduacion(request.getFechgraduacion());
        Medico medico = medicoRepository.findById(request.getIdmedico()).orElseThrow(() -> new RuntimeException("No se encontro el medico"));
        especialidad.setMedico(medico);
        return convertirEspecialidadResponse(especialidadRepository.save(especialidad));
    }

    @Override
    public EspecialidadResponse buscarEspecialidad(int idespecialidad) {
        Especialidad especialidadBuscar = especialidadRepository.findById(idespecialidad).orElseThrow(() -> new RuntimeException("No se encontro doctores con especialidades"));
        return convertirEspecialidadResponse(especialidadBuscar);
    }

    //convertir
    private List<EspecialidadResponse> convertirListEspecialidadResponse(List<Especialidad> especialidades) {
        List<EspecialidadResponse> response = new ArrayList<>();
        for (Especialidad especialidad : especialidades) {
            response.add(convertirEspecialidadResponse(especialidad));
        }
        return response;
    }

    private EspecialidadResponse convertirEspecialidadResponse(Especialidad especialidad) {
        return EspecialidadResponse.builder()
                .idespecialidad(especialidad.getIdespecialidad())
                .titulo(especialidad.getTitulo())
                .funcion(especialidad.getFuncion())
                .fechgraduacion(especialidad.getFechgraduacion())
                .medico(convertirMedicoResponse(especialidad.getMedico()))
                .build();
    }

    private MedicoResponse convertirMedicoResponse(Medico medico) {
        return MedicoResponse.builder()
                .idmedico(medico.getIdmedico())
                .nommedico(medico.getNommedico())
                .apemedico(medico.getApemedico())
                .fechanacmedico(medico.getFechanacmedico())
                .build();
    }
}
