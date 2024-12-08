package pe.edu.cibertec.t2sw_santosvieri.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Table(name = "medico")
@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmedico;
    private String nommedico;
    private String apemedico;
    private LocalDate fechanacmedico;

    @OneToMany(mappedBy = "medico", fetch = FetchType.EAGER)
    private List<Especialidad> especialidadList;
}
