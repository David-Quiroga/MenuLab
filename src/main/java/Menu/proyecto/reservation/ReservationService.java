package Menu.proyecto.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Menu.proyecto.cart.CartItem;
import Menu.proyecto.cart.CartItemRepository;
import Menu.proyecto.cliente.Cliente;
import Menu.proyecto.cliente.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired 
    ClienteRepository clienteRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Transactional
    public Reservation saveReservation(Reservation reservation) {
        Cliente cliente = reservation.getCliente();
        if (cliente == null){
            cliente = clienteRepository.save(cliente);
            reservation.setCliente(cliente);
        }
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public CartItem addCartItemToReservation(Long reservationId, CartItem cartItem) {
        // Obtener la Reservation a la que se añadirá el CartItem
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        // Asignar la Reservation al CartItem
        cartItem.setReservation(reservation);

        // Guardar el CartItem (se asocia automáticamente con la Reservation)
        return cartItemRepository.save(cartItem);
    }


    public Reservation getReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId)
                                    .orElse(null);
    }

    
}
