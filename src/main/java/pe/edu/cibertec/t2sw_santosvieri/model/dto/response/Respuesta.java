package pe.edu.cibertec.t2sw_santosvieri.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Respuesta<T> {
    private String mensaje;
    private String errorMensaje;
    private T data;
}