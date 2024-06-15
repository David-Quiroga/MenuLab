package Menu.proyecto.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserRepository, Long> {
    
    Optional<User> findUserByEmail(String email);
}
