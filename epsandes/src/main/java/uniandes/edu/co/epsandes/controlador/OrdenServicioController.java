package uniandes.edu.co.epsandes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.epsandes.modelo.OrdenServicio;
import uniandes.edu.co.epsandes.repositorio.OrdenServicioRepository;
import java.util.Date;

@RestController
@RequestMapping("/ordenes-servicio")
public class OrdenServicioController {
    
    @Autowired
    private OrdenServicioRepository ordenRepository;

    @PostMapping
    public ResponseEntity<?> crearOrden(@RequestBody OrdenServicio orden) {
        try {
            System.out.println("Datos recibidos: " + orden.getAfiliadoId() + ", " + orden.getMedicoId() + ", " + orden.getServicioSaludId());
            
            orden.setFecha(new Date());
            orden.setEstado("VIGENTE");
            
            OrdenServicio ordenGuardada = ordenRepository.save(orden);
            return ResponseEntity.ok(ordenGuardada);
        } catch (Exception e) {
            System.err.println("Error al crear orden: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}