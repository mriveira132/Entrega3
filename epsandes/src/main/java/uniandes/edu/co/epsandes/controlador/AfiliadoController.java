package uniandes.edu.co.epsandes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import uniandes.edu.co.epsandes.modelo.Afiliado;
import uniandes.edu.co.epsandes.repositorio.AfiliadoRepository;

@RestController
@RequestMapping("/afiliados")
public class AfiliadoController {
    
    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @PostMapping
    public ResponseEntity<Afiliado> crearAfiliado(@Valid @RequestBody Afiliado afiliado) {
        try {
            Afiliado afiliadoGuardado = afiliadoRepository.save(afiliado);
            return ResponseEntity.ok(afiliadoGuardado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}