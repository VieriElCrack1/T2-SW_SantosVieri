package pe.edu.cibertec.t2sw_santosvieri.model.dto.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class MedicoRequest {
    private Integer idmedico;
    private String nommedico;
    private String apemedico;
    private LocalDate fechanacmedico;
}
