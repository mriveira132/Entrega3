package uniandes.edu.co.epsandes.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.epsandes.modelo.Cita;
import java.util.Date;
import java.util.List;

public interface CitaRepository extends MongoRepository<Cita, String> {
    List<Cita> findByServicioSaludIdAndFechaBetween(String servicioId, Date inicio, Date fin);

    @Query(value = "{ 'fecha': { $gte: ?0, $lte: ?1 } }", 
       fields = "{ 'servicioSaludId': 1 }")
    List<Cita> findByFechaBetween(Date inicio, Date fin);

}

