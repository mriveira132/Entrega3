package uniandes.edu.co.epsandes.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

@Document(collection = "servicios_salud")
public class ServicioSalud {
    @Id
    private String id;
    
    @Indexed(unique = true)
    private String codigo;
    private String nombre;
    private String descripcion;

    public ServicioSalud() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}