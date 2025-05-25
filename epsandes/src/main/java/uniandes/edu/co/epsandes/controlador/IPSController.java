package uniandes.edu.co.epsandes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import uniandes.edu.co.epsandes.modelo.IPS;
import uniandes.edu.co.epsandes.repositorio.IPSRepository;

@RestController
@RequestMapping("/ips")
public class IPSController {
    
    @Autowired
    private IPSRepository ipsRepository;

    @PostMapping
    public ResponseEntity<IPS> crearIPS(@Valid @RequestBody IPS ips) {
        try {
            IPS ipsGuardada = ipsRepository.save(ips);
            return ResponseEntity.ok(ipsGuardada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<java.util.List<IPS>> listarIPS() {
        return ResponseEntity.ok(ipsRepository.findAll());
    }

    @PutMapping("/{ipsId}/servicios")
    public ResponseEntity<IPS> asignarServicios(@PathVariable String ipsId, @RequestBody java.util.List<String> serviciosIds) {
        try {
            java.util.Optional<IPS> ipsOpt = ipsRepository.findById(ipsId);
            if (ipsOpt.isPresent()) {
                IPS ips = ipsOpt.get();
                ips.setServiciosIds(serviciosIds);
                ipsRepository.save(ips);
                return ResponseEntity.ok(ips);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}