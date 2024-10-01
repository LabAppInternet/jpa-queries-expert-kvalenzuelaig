package cat.tecnocampus.fgcstations.persistence;

import cat.tecnocampus.fgcstations.application.DTOs.UserDTO;
import cat.tecnocampus.fgcstations.application.DTOs.UserDTOInterface;
import cat.tecnocampus.fgcstations.application.DTOs.UserDTOnoFJ;
import cat.tecnocampus.fgcstations.application.DTOs.UserTopFavoriteJourney;
import cat.tecnocampus.fgcstations.domain.FavoriteJourney;
import cat.tecnocampus.fgcstations.domain.Journey;
import cat.tecnocampus.fgcstations.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    User findUserByUsername(String username);

    @Query("SELECT u FROM User u")
    List<User> findAllUsers();

    UserDTOInterface findViewByUsername(String username);

    List<UserDTOInterface> findUserByNameAndSecondName(String name, String secondName);


    @Query("SELECT fj.user FROM FavoriteJourney fj GROUP BY fj.user ORDER BY count(fj.journey) DESC")
    List<UserTopFavoriteJourney> findTop3UsersWithMoreFavoriteJourney(Pageable pageable);

}
