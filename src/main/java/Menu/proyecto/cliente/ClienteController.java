package Menu.proyecto.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/clientes")
@CrossOrigin({"*"})
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/registro")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
    }

    @GetMapping("/obtener/{id}")
    public Cliente findById(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    // Delete
    @DeleteMapping("/borrar/{id}")
    public void delete(@PathVariable Long id) {
        clienteService.deleteById(id);
    }

    // // ALl
    // @GetMapping("/listar")
    // public List<Cliente> findAll() {
    //     return clienteService.findAll();
    // }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllCLientes() {
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public Cliente updateById(@PathVariable Long id, @RequestBody Cliente entity) {
        entity.setId(id);

        return clienteService.save( entity);
    }
}
