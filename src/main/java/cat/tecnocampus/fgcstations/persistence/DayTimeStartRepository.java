package cat.tecnocampus.fgcstations.persistence;

import cat.tecnocampus.fgcstations.application.DTOs.PopularDayOfWeek;
import cat.tecnocampus.fgcstations.domain.DayTimeStart;
import cat.tecnocampus.fgcstations.domain.FavoriteJourney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface DayTimeStartRepository extends JpaRepository<DayTimeStart, String> {

    @Query("SELECT count(dts.dayOfWeek), dts.dayOfWeek FROM DayTimeStart dts GROUP BY dts.dayOfWeek ORDER BY count(dts.dayOfWeek) DESC")
    List<PopularDayOfWeek> getPopularDayOfWeek(Pageable pageable);

    <S extends DayTimeStart> List<S> saveAll(Iterable<S> entities);

}
