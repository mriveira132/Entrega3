package uniandes.edu.co.epsandes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import uniandes.edu.co.epsandes.modelo.ServicioSalud;
import uniandes.edu.co.epsandes.repositorio.ServicioSaludRepository;
import uniandes.edu.co.epsandes.modelo.Cita;
import uniandes.edu.co.epsandes.repositorio.CitaRepository;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

@RestController
@RequestMapping("/servicios")
public class ServicioSaludController {
    
    @Autowired
    private ServicioSaludRepository servicioRepository;
    
    @Autowired
    private CitaRepository citaRepository;

    @PostMapping
    public ResponseEntity<ServicioSalud> crearServicio(@Valid @RequestBody ServicioSalud servicio) {
        try {
            ServicioSalud servicioGuardado = servicioRepository.save(servicio);
            return ResponseEntity.ok(servicioGuardado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ServicioSalud>> listarServicios() {
        return ResponseEntity.ok(servicioRepository.findAll());
    }

    @GetMapping("/{servicioId}/disponibilidad")
    public ResponseEntity<List<Cita>> consultarDisponibilidad(@PathVariable String servicioId) {
        try {
            System.out.println("Consultando disponibilidad para servicio: " + servicioId);
            Date hoy = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(hoy);
            cal.add(Calendar.WEEK_OF_YEAR, 4);
            Date cuatroSemanas = cal.getTime();
            
            List<Cita> citas = citaRepository.findByServicioSaludIdAndFechaBetween(servicioId, hoy, cuatroSemanas);
            System.out.println("Encontradas " + citas.size() + " citas");
            return ResponseEntity.ok(citas);
        } catch (Exception e) {
            System.err.println("Error consultando disponibilidad: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}