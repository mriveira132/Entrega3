package uniandes.edu.co.epsandes.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

@Document(collection = "afiliados")
public class Afiliado {
    @Id
    private String id;
    
    @NotBlank
    private String tipoDocumento;
    
    @Indexed(unique = true)
    @NotBlank
    private String numeroDocumento;
    
    @NotBlank
    private String nombre;
    
    private Date fechaNacimiento;
    private String direccion;
    private String telefono;
    
    @NotBlank
    private String tipoAfiliado;
    
    private String contribuyenteId;
    private String parentesco;

    public Afiliado() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }
    
    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(String numeroDocumento) { this.numeroDocumento = numeroDocumento; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public String getTipoAfiliado() { return tipoAfiliado; }
    public void setTipoAfiliado(String tipoAfiliado) { this.tipoAfiliado = tipoAfiliado; }
    
    public String getContribuyenteId() { return contribuyenteId; }
    public void setContribuyenteId(String contribuyenteId) { this.contribuyenteId = contribuyenteId; }
    
    public String getParentesco() { return parentesco; }
    public void setParentesco(String parentesco) { this.parentesco = parentesco; }
}