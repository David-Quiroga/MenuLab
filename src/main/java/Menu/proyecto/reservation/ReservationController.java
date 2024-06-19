package Menu.proyecto.reservation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import Menu.proyecto.menu.MenuItemRepository;
import Menu.proyecto.reservation.Reservation;

@RestController
@RequestMapping("/api")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @PostMapping("/reservations")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        // Guarda cada MenuItem antes de guardar CartItem
        for (CartItem cartItem : reservation.getCartItems()) {
            if (cartItem.getMenuItem() != null) {
                menuItemRepository.save(cartItem.getMenuItem());
            }
        }

        // Guarda la reserva
        reservationService.saveReservation(reservation);

        return ResponseEntity.status(HttpStatus.CREATED).body(reservation);
    }
} 