package cat.tecnocampus.fgcstations.persistence;

import cat.tecnocampus.fgcstations.application.DTOs.UserDTOInterface;
import cat.tecnocampus.fgcstations.application.DTOs.UserDTOnoFJ;
import cat.tecnocampus.fgcstations.application.DTOs.UserTopFavoriteJourney;
import cat.tecnocampus.fgcstations.domain.FavoriteJourney;
import cat.tecnocampus.fgcstations.domain.Journey;
import cat.tecnocampus.fgcstations.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);

}
