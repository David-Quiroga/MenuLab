package Menu.proyecto.restaurante;

import Menu.proyecto.empleado.Empleado;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Restaurante 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        private long idrestaurante;
        private String nombrerestaurante; 

    public long getIdrestaurante() {
        return idrestaurante;
    }

    public void setIdrestaurante(long idrestaurante) {
        this.idrestaurante = idrestaurante;
    }

    public String getNombrerestaurante() {
        return nombrerestaurante;
    }

    public void setNombrerestaurante(String nombrerestaurante) {
        this.nombrerestaurante = nombrerestaurante;
    }

    @ManyToOne
    private Empleado empleado;

}

 