package uniandes.edu.co.epsandes.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

@Document(collection = "ordenes")
public class OrdenServicio {
    @Id
    private String id;
    
    private Date fecha;
    
    @NotBlank
    private String afiliadoId;
    
    @NotBlank
    private String medicoId;
    
    @NotBlank
    private String servicioSaludId;
    
    @NotBlank
    private String estado;

    public OrdenServicio() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    
    public String getAfiliadoId() { return afiliadoId; }
    public void setAfiliadoId(String afiliadoId) { this.afiliadoId = afiliadoId; }
    
    public String getMedicoId() { return medicoId; }
    public void setMedicoId(String medicoId) { this.medicoId = medicoId; }
    
    public String getServicioSaludId() { return servicioSaludId; }
    public void setServicioSaludId(String servicioSaludId) { this.servicioSaludId = servicioSaludId; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}