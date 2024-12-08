package pe.edu.cibertec.t2sw_santosvieri.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MedicoResponse {
    private Integer idmedico;
    private String nommedico;
    private String apemedico;
    private LocalDate fechanacmedico;
}
