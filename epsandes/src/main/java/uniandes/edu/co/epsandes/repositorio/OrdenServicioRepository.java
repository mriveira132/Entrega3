package uniandes.edu.co.epsandes.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.epsandes.modelo.OrdenServicio;

public interface OrdenServicioRepository extends MongoRepository<OrdenServicio, String> {
}