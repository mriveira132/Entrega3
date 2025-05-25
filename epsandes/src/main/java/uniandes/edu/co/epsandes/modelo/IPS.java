package uniandes.edu.co.epsandes.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;
import java.util.List;

@Document(collection = "ips")
public class IPS {
    @Id
    private String id;
    
    @Indexed(unique = true)
    private String nit;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<String> serviciosIds;

    public IPS() {}
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getNit() { return nit; }
    public void setNit(String nit) { this.nit = nit; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public List<String> getServiciosIds() { return serviciosIds; }
    public void setServiciosIds(List<String> serviciosIds) { this.serviciosIds = serviciosIds; }
}