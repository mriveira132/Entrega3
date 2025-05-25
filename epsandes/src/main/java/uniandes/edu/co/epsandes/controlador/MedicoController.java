package uniandes.edu.co.epsandes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import uniandes.edu.co.epsandes.modelo.Medico;
import uniandes.edu.co.epsandes.repositorio.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public ResponseEntity<Medico> crearMedico(@Valid @RequestBody Medico medico) {
        try {
            Medico medicoGuardado = medicoRepository.save(medico);
            return ResponseEntity.ok(medicoGuardado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}