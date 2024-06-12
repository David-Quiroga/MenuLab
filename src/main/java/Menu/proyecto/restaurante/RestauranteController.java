package Menu.proyecto.restaurante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RestauranteController 

{
    @Autowired
    private RestauranteService restauranteService;

    @PostMapping(value = "restaurante")
    public Restaurante save(@RequestBody Restaurante entity) 
    {
        return restauranteService.save(entity);
    }
    
    @GetMapping(value = "restaurante/{id}")
    public Restaurante findById(@PathVariable Long id) 
    {
        return restauranteService.findById(id);
    }

    @PutMapping(value = "restaurante")
    public Restaurante update(@RequestBody Restaurante entity)
    {
        return restauranteService.save(entity);
    }

    //Delete
    @DeleteMapping(value = "restaurante/{id}")
    public void delete(@PathVariable Long id)
    {
        restauranteService.deleteById(id);
    }

    //ALl
    @GetMapping(value = "restaurante")
    public List<Restaurante> findAll()
    {
        return restauranteService.findAll();
    }

    @PutMapping(value = "restaurante/{id}")
    public ResponseEntity<Restaurante> updateById(@PathVariable Long id, @RequestBody Restaurante entity)
    {
        return restauranteService.updateById(id, entity);
    }
}
