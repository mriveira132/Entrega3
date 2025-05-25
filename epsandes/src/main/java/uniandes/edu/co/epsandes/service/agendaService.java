package uniandes.edu.co.epsandes.service;

import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import uniandes.edu.co.epsandes.repositorio.CitaRepository;
import uniandes.edu.co.epsandes.repositorio.ServicioSaludRepository;
import uniandes.edu.co.epsandes.repositorio.IPSRepository;
import uniandes.edu.co.epsandes.repositorio.MedicoRepository;
import uniandes.edu.co.epsandes.modelo.Cita;

@Service
public class agendaService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private ServicioSaludRepository servicioRepository;

    @Autowired
    private IPSRepository ipsRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Map<String, Object>> consultarDisponibilidad(String servicioId) {
        Date inicio = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(inicio);
        cal.add(Calendar.WEEK_OF_YEAR, 4);
        Date fin = cal.getTime();

        List<Cita> citas = citaRepository.findByServicioSaludIdAndFechaBetween(servicioId, inicio, fin);

        return citas.stream().map(cita -> {
            Map<String, Object> data = new HashMap<>();

            data.put("fecha", cita.getFecha());
            data.put("hora", cita.getHora());

            servicioRepository.findById(cita.getServicioSaludId()).ifPresent(servicio -> data.put("servicio", servicio.getNombre()));
            ipsRepository.findById(cita.getIpsId()).ifPresent(ips -> data.put("ips", ips.getNombre()));
            medicoRepository.findById(cita.getMedicoId()).ifPresent(medico -> data.put("medico", medico.getNombre()));

            return data;
        }).collect(Collectors.toList());
    }
}
