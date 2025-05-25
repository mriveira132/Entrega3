package uniandes.edu.co.epsandes.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotBlank;
import java.util.Date;

@Document(collection = "citas")
public class Cita {
    @Id
    private String id;
    
    private Date fecha;
    private String hora;
    
    @NotBlank
    private String afiliadoId;
    
    @NotBlank
    private String medicoId;
    
    @NotBlank
    private String ipsId;
    
    @Field("servicioId")
    private String servicioSaludId;

    
    private String ordenServicioId;

    public Cita() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    
    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }
    
    public String getAfiliadoId() { return afiliadoId; }
    public void setAfiliadoId(String afiliadoId) { this.afiliadoId = afiliadoId; }
    
    public String getMedicoId() { return medicoId; }
    public void setMedicoId(String medicoId) { this.medicoId = medicoId; }
    
    public String getIpsId() { return ipsId; }
    public void setIpsId(String ipsId) { this.ipsId = ipsId; }
    
    public String getServicioSaludId() { return servicioSaludId; }
    public void setServicioSaludId(String servicioSaludId) { this.servicioSaludId = servicioSaludId; }
    
    public String getOrdenServicioId() { return ordenServicioId; }
    public void setOrdenServicioId(String ordenServicioId) { this.ordenServicioId = ordenServicioId; }
}