package Menu.proyecto.crear_plato;

import java.math.BigDecimal;

import Menu.proyecto.reserva.Reserva;
import Menu.proyecto.restaurante.Restaurante;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Crearplato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    // private String categoria;
    // private String imagen;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    // public String getCategoria() {
    // return categoria;
    // }

    // public void setCategoria(String categoria) {
    // this.categoria = categoria;
    // }

    // public String getImagen() {
    // return imagen;
    // }

    // public void setImagen(String imagen) {
    // this.imagen = imagen;
    // }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @ManyToOne
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;
}
