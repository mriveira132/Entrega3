package uniandes.edu.co.epsandes.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.epsandes.modelo.IPS;

public interface IPSRepository extends MongoRepository<IPS, String> {
}