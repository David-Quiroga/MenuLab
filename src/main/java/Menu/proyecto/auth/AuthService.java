package Menu.proyecto.auth;

public interface AuthService {
    AuthResponse register (RegisterRequest request);

    AuthResponse authenticate (AuthenticateRequest request);
    
}
