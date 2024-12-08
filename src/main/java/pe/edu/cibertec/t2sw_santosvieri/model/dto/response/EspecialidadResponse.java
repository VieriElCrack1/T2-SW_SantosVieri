package pe.edu.cibertec.t2sw_santosvieri.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EspecialidadResponse {
    private Integer idespecialidad;
    private String titulo;
    private String funcion;
    private LocalDate fechgraduacion;
    private MedicoResponse medico;
}
