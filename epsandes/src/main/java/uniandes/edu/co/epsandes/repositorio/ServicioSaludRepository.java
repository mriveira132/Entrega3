package uniandes.edu.co.epsandes.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.epsandes.modelo.ServicioSalud;

public interface ServicioSaludRepository extends MongoRepository<ServicioSalud, String> {
}