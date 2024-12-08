package pe.edu.cibertec.t2sw_santosvieri.model.dto.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class EspecialidadRequest {
    private Integer idespecialidad;
    private String titulo;
    private String funcion;
    private LocalDate fechgraduacion;
    private Integer idmedico;
}
