package Menu.proyecto.reserva;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping

public class ReservaController 
{
    @Autowired
    private ReservaService reservaService;

    @PostMapping(value = "reserva")
    public Reserva save(@RequestBody Reserva entity) 
    {
        return reservaService.save(entity);
    }
    
    @GetMapping(value = "reserva/{id}")
    public Reserva findById(@PathVariable Long id) 
    {
        return reservaService.findById(id);
    }

    @PutMapping(value = "reserva")
    public Reserva update(@RequestBody Reserva entity)
    {
        return reservaService.save(entity);
    }

    //Delete
    @DeleteMapping(value = "reserva/{id}")
    public void delete(@PathVariable Long id)
    {
        reservaService.deleteById(id);
    }

    //ALl
    @GetMapping(value = "reserva")
    public List<Reserva> findAll()
    {
        return reservaService.findAll();
    }

    @PutMapping(value = "reserva/{id}")
    public ResponseEntity<Reserva> updateById(@PathVariable Long id, @RequestBody Reserva entity)
    {
        return reservaService.updateById(id, entity);
    }
}
