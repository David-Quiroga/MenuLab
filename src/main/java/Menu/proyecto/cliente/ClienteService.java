package Menu.proyecto.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ClienteService 
{
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente entity)
    {
        return clienteRepository.save(entity);
    }

    public Cliente findById(Long id)
    {
        return clienteRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id)
    {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> findAll()
    {
        return clienteRepository.findAll();
    }

    public ResponseEntity<Cliente> updateById(Long id, Cliente clienteActualizada)
    {
        try
        {
            Cliente clienteExistente = findById(id);

            if (clienteExistente == null)return ResponseEntity.notFound().build();
            if(clienteActualizada.getNombre()!= null)clienteExistente.setNombre(clienteActualizada.getNombre());


            Cliente clienteGuardada = save(clienteExistente);
            return ResponseEntity.ok(clienteGuardada);
        
        }catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }
}
