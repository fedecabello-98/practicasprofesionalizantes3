package teccellsoft.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Celular {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    private String marca;
    private String modelo;
    private String observacion;
    
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    
    private int IdCliente;
    
    private int IdTecnico;
   
    private int IdEstado;
    private Double monto;

    public Celular() {
    }

    public Celular(Integer codigo, String marca, String modelo, String observacion, Date fechaIngreso, Date fechaEntrega, int IdCliente, int IdTecnico, int IdEstado, Double monto) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.observacion = observacion;
        this.fechaIngreso = fechaIngreso;
        this.fechaEntrega = fechaEntrega;
        this.IdCliente = IdCliente;
        this.IdTecnico = IdTecnico;
        this.IdEstado = IdEstado;
        this.monto = monto;
    }

   
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getIdTecnico() {
        return IdTecnico;
    }

    public void setIdTecnico(int IdTecnico) {
        this.IdTecnico = IdTecnico;
    }

    public int getIdEstado() {
        return IdEstado;
    }

    public void setIdEstado(int IdEstado) {
        this.IdEstado = IdEstado;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
    
    
}
