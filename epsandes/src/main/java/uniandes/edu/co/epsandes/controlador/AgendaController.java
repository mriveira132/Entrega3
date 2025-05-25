package uniandes.edu.co.epsandes.controlador;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import uniandes.edu.co.epsandes.service.agendaService;


@RestController
@RequestMapping("/api/agenda")
public class AgendaController {

    @Autowired
    private agendaService agendaService;

    @GetMapping("/disponibilidad")
    public ResponseEntity<?> consultarAgenda(@RequestParam String servicioId) {
        return ResponseEntity.ok(agendaService.consultarDisponibilidad(servicioId));
    }
}
