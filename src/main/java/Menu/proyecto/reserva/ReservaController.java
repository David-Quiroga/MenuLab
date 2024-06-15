package Menu.proyecto.reserva;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin("*")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @PostMapping("/crear")
    public Reserva save(@RequestBody Reserva entity) {
        return reservaService.save(entity);
    }

    @GetMapping("/obtener/{id}")
    public Reserva findById(@PathVariable Long id) {
        return reservaService.findById(id);
    }

    

    // Delete
    @DeleteMapping("/borrar/{id}")
    public void delete(@PathVariable Long id) {
        reservaService.deleteById(id);
    }

    // ALl
    @GetMapping("/listar")
    public List<Reserva> findAll() {
        return reservaService.findAll();
    }

    @PutMapping("/actualizar/{id}")
    public Reserva updateById(@PathVariable Long id, @RequestBody Reserva entity) {
        entity.setId(id);
        return reservaService.save( entity);
    }
}
