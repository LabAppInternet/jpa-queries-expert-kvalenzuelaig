package cat.tecnocampus.fgcstations.persistence;

import cat.tecnocampus.fgcstations.application.DTOs.JourneyDTO;
import cat.tecnocampus.fgcstations.domain.FavoriteJourney;
import cat.tecnocampus.fgcstations.domain.Journey;
import cat.tecnocampus.fgcstations.domain.JourneyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JourneyRepository extends JpaRepository<Journey, JourneyId> {

    <S extends Journey> S save(S entity);

    @Query("SELECT j FROM Journey j")
    List<JourneyDTO> findAllJourneyDTO();

    @Query("SELECT j FROM Journey j WHERE j.origin = ?1 AND j.destination = ?2")
    Journey getJourneyByOriginAndDestination(String origin, String destination);

    @Query("SELECT j.id FROM Journey j WHERE j.destination = ?2 AND j.origin = ?1")
    JourneyId getJourneyIdByOriginAndDestination(String origin, String destination);

}
