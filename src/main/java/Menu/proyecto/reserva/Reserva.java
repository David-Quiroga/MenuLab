package Menu.proyecto.reserva;


import java.math.BigDecimal;
import java.sql.Date;

import Menu.proyecto.cliente.Cliente;
import Menu.proyecto.restaurante.Restaurante;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Reserva 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date fechaingreso;
    private BigDecimal precio;
    private BigDecimal numeropersonas;
    private String descripcion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getNumeropersonas() {
        return numeropersonas;
    }

    public void setNumeropersonas(BigDecimal numeropersonas) {
        this.numeropersonas = numeropersonas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @ManyToOne 
    private Restaurante restaurante;

    // @ManyToOne 
    // private Restaurante Crearplato;

    @ManyToOne
    private Cliente cliente;
}
