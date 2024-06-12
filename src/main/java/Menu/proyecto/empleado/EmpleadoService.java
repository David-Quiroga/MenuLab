package Menu.proyecto.empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService 
{
      @Autowired
    private EmpleadoRepository empleadoRepository;

    public Empleado save(Empleado entity)
    {
        return empleadoRepository.save(entity);
    }

    public Empleado findById(Long id)
    {
        return empleadoRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id)
    {
        empleadoRepository.deleteById(id);
    }

    public List<Empleado> findAll()
    {
        return empleadoRepository.findAll();
    }

    public ResponseEntity<Empleado> updateById(Long id, Empleado empleadoActualizada)
    {
        try
        {
            Empleado empleadoExistente = findById(id);

            if (empleadoExistente == null)
            {
                return ResponseEntity.notFound().build();
            }

            if(empleadoActualizada.getNombrecompleto()!= null)empleadoExistente.setNombrecompleto(empleadoActualizada.getNombrecompleto());
            if(empleadoActualizada.getContraseña()!= null)empleadoExistente.setContraseña(empleadoActualizada.getContraseña());
            if(empleadoActualizada.getUsuario()!=null)empleadoExistente.setUsuario(empleadoActualizada.getUsuario());
            if(empleadoActualizada.getCorreoelectronico()!= null)empleadoExistente.setCorreoelectronico(empleadoActualizada.getCorreoelectronico());

            Empleado empleadoGuardada = save(empleadoExistente);
            return ResponseEntity.ok(empleadoGuardada);
        
        }catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }
}
