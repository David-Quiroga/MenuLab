package Menu.proyecto.crear_plato;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CrearplatoService {
    @Autowired
    private CrearplatoRepository crearplatoRepository;

    public Crearplato save(Crearplato entity) {
        return crearplatoRepository.save(entity);
    }

    public Crearplato findById(Long id) {
        return crearplatoRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        crearplatoRepository.deleteById(id);
    }

    public List<Crearplato> findAll() {
        return crearplatoRepository.findAll();
    }

    public ResponseEntity<Crearplato> updateById(Long id, Crearplato crearplatoActualizada) {
        try {
            Crearplato crearplatoExistente = findById(id);

            if (crearplatoExistente == null)
                return ResponseEntity.notFound().build();

            if (crearplatoActualizada.getNombre() != null)
                crearplatoExistente.setNombre(crearplatoActualizada.getNombre());
            if (crearplatoActualizada.getDescripcion() != null)
                crearplatoExistente.setDescripcion(crearplatoActualizada.getDescripcion());
            if (crearplatoActualizada.getPrecio() != null)
                crearplatoExistente.setPrecio(crearplatoActualizada.getPrecio());

            Crearplato crearplatoGuardada = save(crearplatoExistente);
            return ResponseEntity.ok(crearplatoGuardada);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }

}
