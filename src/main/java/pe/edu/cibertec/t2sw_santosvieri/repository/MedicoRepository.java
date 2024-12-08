package pe.edu.cibertec.t2sw_santosvieri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.t2sw_santosvieri.model.bd.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}
