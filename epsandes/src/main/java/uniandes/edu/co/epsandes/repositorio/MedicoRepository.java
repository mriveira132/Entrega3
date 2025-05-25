package uniandes.edu.co.epsandes.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.epsandes.modelo.Medico;
import java.util.Optional;

public interface MedicoRepository extends MongoRepository<Medico, String> {
    Optional<Medico> findByNumeroRegistroMedico(String numero);
}