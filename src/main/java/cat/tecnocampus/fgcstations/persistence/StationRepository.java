package cat.tecnocampus.fgcstations.persistence;

import cat.tecnocampus.fgcstations.application.DTOs.StationDTO;
import cat.tecnocampus.fgcstations.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StationRepository extends JpaRepository<Station, String> {
    @Query("SELECT s FROM Station s")
    List<StationDTO> findAllDTO();

    Station findStationByName(String name);

    @Query("SELECT s FROM Station s WHERE s.name = :name")
    StationDTO findStationDTOByName(@Param("name") String name);

}
