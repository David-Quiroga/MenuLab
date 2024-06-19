package Menu.proyecto.reservation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/api/reservations")
@CrossOrigin({"*"})
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private MenuItemRepository menuItemRepository;

    // @GetMapping
    // public ResponseEntity<List<Reservation>> getAllReservations() {
    //     return ResponseEntity.ok(reservationService.getAllReservations());
    // }

    @GetMapping
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        // Puedes verificar si las relaciones están inicializadas antes de devolverlas
        // Hibernate.initialize(reservations); // Si es necesario inicializar manualmente
        return reservations;
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long reservationId) {
        Reservation reservation = reservationService.getReservationById(reservationId);
        // Asegúrate de que las relaciones estén inicializadas antes de devolver la respuesta
        if (reservation == null) {
            return ResponseEntity.notFound().build();
        }
        // Hibernate.initialize(reservation.getCartItems());  // Si es necesario inicializar manualmente
        return ResponseEntity.ok(reservation);
    }

    // Endpoint para crear una nueva Reservation
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.saveReservation(reservation);
        return ResponseEntity.ok(createdReservation);
    }

    // Endpoint para añadir un CartItem a una Reservation existente
    @PostMapping("/{reservationId}/cartitems")
    public ResponseEntity<CartItem> addCartItemToReservation(
            @PathVariable Long reservationId,
            @RequestBody CartItem cartItem) {
        CartItem addedCartItem = reservationService.addCartItemToReservation(reservationId, cartItem);
        return ResponseEntity.ok(addedCartItem);
    }
} 