package Menu.proyecto.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Menu.proyecto.cliente.Cliente;
import Menu.proyecto.cliente.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired ClienteRepository clienteRepository;

    @Transactional
    public Reservation saveReservation(Reservation reservation) {
        Cliente cliente = reservation.getCliente();
        if (cliente.getId() == null){
            cliente = clienteRepository.save(cliente);
            reservation.setCliente(cliente);
        }
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    
}
