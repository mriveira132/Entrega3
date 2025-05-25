package uniandes.edu.co.epsandes.controlador;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import uniandes.edu.co.epsandes.service.EstadisticasService; // Add this import, adjust the package if needed
import java.util.Date;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticasController {

    @Autowired
    private EstadisticasService estadisticasService;

    @GetMapping("/top-servicios")
    public ResponseEntity<?> topServicios(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fin) {

        return ResponseEntity.ok(estadisticasService.serviciosMasSolicitados(inicio, fin));
    }
}
