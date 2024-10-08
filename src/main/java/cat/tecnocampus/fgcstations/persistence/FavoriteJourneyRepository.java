package cat.tecnocampus.fgcstations.persistence;

import cat.tecnocampus.fgcstations.domain.FavoriteJourney;
import cat.tecnocampus.fgcstations.domain.Journey;
import cat.tecnocampus.fgcstations.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavoriteJourneyRepository extends JpaRepository<FavoriteJourney, String> {
    <S extends FavoriteJourney> S save(S entity);

    @Query("SELECT fj FROM FavoriteJourney fj, User u WHERE fj.user = u AND u.username = ?1")
    List<FavoriteJourney> findFavoriteJourneyByUser(String username);

    //TODO optional: Try to implement the query to get the FavoriteJourneysDTO of a user with its list of DayTimeStartDTO.
    // Is it possible to do it with a single query?
}
