package Menu.proyecto.restaurante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService 
{
     @Autowired
    private RestauranteRepository restauranteRepository;

    public Restaurante save(Restaurante entity)
    {
        return restauranteRepository.save(entity);
    }

    public Restaurante findById(Long id)
    {
        return restauranteRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id)
    {
        restauranteRepository.deleteById(id);
    }

    public List<Restaurante> findAll()
    {
        return restauranteRepository.findAll();
    }

    public ResponseEntity<Restaurante> updateById(Long id, Restaurante restauranteActualizada)
    {
        try
        {
            Restaurante restauranteExistente = findById(id);

            if (restauranteExistente == null)
            {
                return ResponseEntity.notFound().build();
            }

            if(restauranteActualizada.getNombrerestaurante()!= null)restauranteExistente.setNombrerestaurante(restauranteActualizada.getNombrerestaurante());


            Restaurante restauranteGuardada = save(restauranteExistente);
            return ResponseEntity.ok(restauranteGuardada);
        
        }catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }
}
