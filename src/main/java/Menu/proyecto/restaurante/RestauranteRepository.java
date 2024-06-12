package Menu.proyecto.restaurante;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RestauranteRepository extends CrudRepository<Restaurante, Long>
{
    List<Restaurante> findAll();
}
