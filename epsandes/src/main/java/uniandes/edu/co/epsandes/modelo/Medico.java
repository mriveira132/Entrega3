package uniandes.edu.co.epsandes.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Document(collection = "medicos")
public class Medico {
    @Id
    private String id;
    
    @Indexed(unique = true)
    @NotBlank
    private String numeroRegistroMedico;
    
    @NotBlank
    private String tipoDocumento;
    
    @NotBlank
    private String numeroDocumento;
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String especialidad;
    
    private List<String> ipsIds;

    public Medico() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getNumeroRegistroMedico() { return numeroRegistroMedico; }
    public void setNumeroRegistroMedico(String numeroRegistroMedico) { this.numeroRegistroMedico = numeroRegistroMedico; }
    
    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }
    
    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(String numeroDocumento) { this.numeroDocumento = numeroDocumento; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    
    public List<String> getIpsIds() { return ipsIds; }
    public void setIpsIds(List<String> ipsIds) { this.ipsIds = ipsIds; }
}