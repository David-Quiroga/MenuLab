package Menu.proyecto.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Menu.proyecto.config.JwtService;
import Menu.proyecto.user.Rol;
import Menu.proyecto.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // @Override
    // public AuthResponse register(RegisterRequest request) {
    //     var user = User.builder()
    //             .name(request.getName())
    //             .lastname(request.getLastname())
    //             .email(request.getEmail())
    //             .password(passwordEncoder.encode(request.getPassword()))
    //             .role(Rol.USER)
    //             .build();
    //     userRepository.save(user);
    //     var jwtToken = jwtService.generateToken(user);
    //     return AuthResponse.builder()
    //             .token(jwtToken).build();
    
    // }

    @Override
    public AuthResponse authenticate(AuthenticateRequest request) {

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
            )
        );
        
        var user = userRepository.findUserByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder().token(jwtToken).build();
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

 
    
}
