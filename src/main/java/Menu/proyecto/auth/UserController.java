package Menu.proyecto.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin({"*"})
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public boolean login(@RequestBody User user){
        User usuarioexistente = userRepository.findByEmail(user.getEmail());
        return usuarioexistente != null && usuarioexistente.getPassword().equals(usuarioexistente.getPassword());
    }
    
}
