package Menu.proyecto.crear_plato;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CrearplatoRepository extends CrudRepository<Crearplato, Long>
{
    List<Crearplato> findAll();
}
