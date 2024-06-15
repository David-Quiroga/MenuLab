package Menu.proyecto.restaurante;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

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
@RequestMapping("/restaurantes")
@CrossOrigin({ "*" })
public class RestauranteController

{
    @Autowired
    private RestauranteService restauranteService;

    @PostMapping("/crear")
    public Restaurante save(@RequestBody Restaurante entity) {
        return restauranteService.save(entity);
    }

    @GetMapping("/obtener/{id}")
    public Restaurante findById(@PathVariable Long id) {
        return restauranteService.findById(id);
    }


    // Delete
    @DeleteMapping("/borrar/{id}")
    public void delete(@PathVariable Long id) {
        restauranteService.deleteById(id);
    }

    // ALl
    @GetMapping("/listar")
    public List<Restaurante> findAll() {
        return restauranteService.findAll();
    }

    @PutMapping("/actualizar/{id}")
    public Restaurante updateById(@PathVariable Long id, @RequestBody Restaurante entity) {
        entity.setIdrestaurante(id);
        
        
        return restauranteService.save( entity);
    }
}
