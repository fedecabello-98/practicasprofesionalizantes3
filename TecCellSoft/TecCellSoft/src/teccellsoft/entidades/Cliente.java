package teccellsoft.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import teccellsoft.enumeraciones.Rol;
import com.sun.istack.internal.NotNull;
import javax.persistence.OneToMany;

@Entity
public class Cliente {

    @Id
    @NotNull
    @Column(unique = true)
    private int dni;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String email;

    @OneToMany
    private Celular celular;
    @Enumerated(EnumType.STRING)
    private Rol rol;

    public Cliente() {
    }

    public Cliente(int dni, String nombre, String apellido, String domicilio, String email, Celular celular, Rol rol) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.email = email;
        this.celular = celular;
        this.rol = rol;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Celular getCelular() {
        return celular;
    }

    public void setCelular(Celular celular) {
        this.celular = celular;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

}
