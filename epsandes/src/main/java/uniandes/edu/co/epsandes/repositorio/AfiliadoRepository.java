package uniandes.edu.co.epsandes.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.epsandes.modelo.Afiliado;
import java.util.Optional;

public interface AfiliadoRepository extends MongoRepository<Afiliado, String> {
    Optional<Afiliado> findByNumeroDocumento(String numero);
}