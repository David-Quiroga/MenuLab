package Menu.proyecto.empleado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/empleados")
@CrossOrigin("*")
public class EmpleadoController 
{
    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping("/crear")
    public Empleado save(@RequestBody Empleado entity) 
    {
        return empleadoService.save(entity);
    }
    
    @GetMapping("/obtener/{id}")
    public Empleado findById(@PathVariable Long id) 
    {
        return empleadoService.findById(id);
    }

    @PutMapping("/actualizar")
    public Empleado update(@RequestBody Empleado entity)
    {
        return empleadoService.save(entity);
    }

    //Delete
    @DeleteMapping("/borrar/{id}")
    public void delete(@PathVariable Long id)
    {
        empleadoService.deleteById(id);
    }

    //ALl
    @GetMapping("/listar")
    public List<Empleado> findAll()
    {
        return empleadoService.findAll();
    }

    @PutMapping(value = "empleado/{id}")
    public ResponseEntity<Empleado> updateById(@PathVariable Long id, @RequestBody Empleado entity)
    {
        return empleadoService.updateById(id, entity);
    }
}
