package pe.edu.cibertec.t2sw_santosvieri.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Table(name = "especialidad")
@Entity
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idespecialidad;
    private String titulo;
    private String funcion;
    private LocalDate fechgraduacion;

    @ManyToOne
    @JoinColumn(name = "idmedico", nullable = false)
    private Medico medico;
}
