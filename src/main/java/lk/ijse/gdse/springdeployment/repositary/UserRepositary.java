package lk.ijse.gdse.springdeployment.repositary;

import lk.ijse.gdse.springdeployment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositary extends JpaRepository<User, Integer> {
    Optional<User> findByUserEmailAndPassword(String userEmail, String password);
}
