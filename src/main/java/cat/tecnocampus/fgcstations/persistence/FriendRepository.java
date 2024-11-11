package cat.tecnocampus.fgcstations.persistence;

import cat.tecnocampus.fgcstations.application.DTOs.FriendUserDTO;
import cat.tecnocampus.fgcstations.application.DTOs.UserFriendsDTO;
import cat.tecnocampus.fgcstations.application.DTOs.UserTopFriend;
import cat.tecnocampus.fgcstations.domain.Friend;
import cat.tecnocampus.fgcstations.domain.FriendId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, FriendId> {

    @Query("SELECT u FROM Friend f JOIN f.user u GROUP BY f.user ORDER BY count(f)")
    List<UserTopFriend> getTop3UsersWithMostFriends(Pageable pageable);

    List<FriendUserDTO> findAllByIdUsername(String username);

    @Query("SELECT f FROM Friend f JOIN f.user u WHERE u.username = ?1")
    List<Friend> findFriendViewByUsername(String username);

}
