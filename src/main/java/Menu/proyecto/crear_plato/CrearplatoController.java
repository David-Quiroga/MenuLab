package Menu.proyecto.crear_plato;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
@CrossOrigin({ "*" })
public class CrearplatoController {
    @Autowired
    private CrearplatoService crearplatoService;

    @PostMapping("/crearplato")
    public Crearplato save(@RequestBody Crearplato entity) {
        return crearplatoService.save(entity);
    }

    @GetMapping("/obtenerplato/{id}")
    public Crearplato findById(@PathVariable Long id) {
        return crearplatoService.findById(id);
    }

    @PutMapping("/actualizarplato/{id}")
    public Crearplato updateById(@PathVariable Long id, @RequestBody Crearplato entity) {
        entity.setId(id);
        return crearplatoService.save(entity);
    }

    @DeleteMapping("/borrarplato/{id}")
    public void delete(@PathVariable Long id) {
        crearplatoService.deleteById(id);
    }

    @GetMapping("/listar")
    public List<Crearplato> findAll() {
        return crearplatoService.findAll();
    }
}