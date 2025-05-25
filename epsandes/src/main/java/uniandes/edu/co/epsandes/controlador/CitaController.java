package uniandes.edu.co.epsandes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import uniandes.edu.co.epsandes.modelo.Cita;
import uniandes.edu.co.epsandes.repositorio.CitaRepository;

@RestController
@RequestMapping("/citas")
public class CitaController {
    
    @Autowired
    private CitaRepository citaRepository;

    @PostMapping
    public ResponseEntity<Cita> crearCita(@Valid @RequestBody Cita cita) {
        try {
            Cita citaGuardada = citaRepository.save(cita);
            return ResponseEntity.ok(citaGuardada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}