package Menu.proyecto.reservation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Menu.proyecto.cart.CartItem;
import Menu.proyecto.cart.CartItemService;
import Menu.proyecto.cliente.Cliente;
import Menu.proyecto.cliente.ClienteService;
import Menu.proyecto.reservation.Reservation;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CartItemService cartItemService;

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        // Save customer if not already saved
        Cliente cliente = reservation.getCliente();
        if (cliente.getId() == 0) {
            cliente = clienteService.save(cliente);
        }
        reservation.setCliente(cliente);
        reservation.setReservedAt(LocalDateTime.now());
        reservation.setStatus("Pending");

        // Save reservation
        Reservation savedReservation = reservationService.saveReservation(reservation);

        // Save cart items
        for (CartItem cartItem : reservation.getCartItems()) {
            cartItem.setReservation(savedReservation);
            cartItemService.saveCartItem(cartItem);
        }

        return ResponseEntity.ok(savedReservation);
    }
}
