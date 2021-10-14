
package teccellsoft.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estado {
    @Id
    private int id;
    private String descripcion;

    public Estado() {
    }

    public Estado(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    
    
}
