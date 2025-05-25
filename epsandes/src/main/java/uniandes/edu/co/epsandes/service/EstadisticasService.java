package uniandes.edu.co.epsandes.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import uniandes.edu.co.epsandes.repositorio.CitaRepository;
import uniandes.edu.co.epsandes.repositorio.ServicioSaludRepository;
import uniandes.edu.co.epsandes.modelo.Cita;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class EstadisticasService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private ServicioSaludRepository servicioRepository;

    public List<Map<String, Object>> serviciosMasSolicitados(Date inicio, Date fin) {
        List<Cita> citas = citaRepository.findByFechaBetween(inicio, fin);

        // Contar ocurrencias por servicioId
        Map<String, Long> conteo = citas.stream()
                .collect(Collectors.groupingBy(Cita::getServicioSaludId, Collectors.counting()));

        // Ordenar y limitar a 20
        return conteo.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(20)
                .map(entry -> {
                    Map<String, Object> resultado = new HashMap<>();
                    resultado.put("cantidad", entry.getValue());
                    servicioRepository.findById(entry.getKey())
                            .ifPresent(servicio -> resultado.put("servicio", servicio.getNombre()));
                    return resultado;
                }).collect(Collectors.toList());
    }
}
