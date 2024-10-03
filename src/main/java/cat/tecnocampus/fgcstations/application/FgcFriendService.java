package cat.tecnocampus.fgcstations.application;


import cat.tecnocampus.fgcstations.application.DTOs.FriendUserDTO;
import cat.tecnocampus.fgcstations.application.DTOs.UserFriendsDTO;
import cat.tecnocampus.fgcstations.application.DTOs.UserTopFriend;
import cat.tecnocampus.fgcstations.application.mapper.MapperHelper;
import cat.tecnocampus.fgcstations.domain.Friend;
import cat.tecnocampus.fgcstations.domain.User;
import cat.tecnocampus.fgcstations.persistence.FriendRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class FgcFriendService {
    private final FriendRepository friendRepository;
    private final FcgUserService fcgUserService;

    public FgcFriendService(FriendRepository friendRepository, FcgUserService fcgUserService) {
        this.friendRepository = friendRepository;
        this.fcgUserService = fcgUserService;
    }

    public UserFriendsDTO getUserFriends(String username) {
        User user = fcgUserService.getDomainUser(username);

        // DONE 20: find all the friends of a user given her username. You can solve this exercise without any sql query
        List<Friend> friends = new ArrayList<>(); //feed the list with the friends of the user
        friends = friendRepository.findFriendByUsername(username);

        return MapperHelper.listOfAUserFriendsToUserFriendsDTO(friends);
    }

    public List<UserFriendsDTO> getAllUserFriends() {
        // DONE 21: find all the friends (domain) of all users. You can solve this exercise without leaving this file
        //  note that domain objects are mapped to DTOs
        List<Friend> friends = friendRepository.findAll();
        return MapperHelper.allUserFriendListToListUserFriendsDTO(friends); // replace the empty list with the list of all users
    }

    public void saveFriends(UserFriendsDTO userFriendsDTO) {
        User user = fcgUserService.getDomainUser(userFriendsDTO.getUsername());
        friendRepository.saveAll(MapperHelper.friendsDTOToUserListOfFriends(user, userFriendsDTO));
    }

    public List<UserTopFriend> getTop3UsersWithMostFriends() {
        // DONE 22: find the top 3 users with the most friends.
        Pageable pageable = (Pageable) PageRequest.of(0, 3);
        return friendRepository.getTopUsersWithMostFriends(pageable);
    }

    // Find all users whose friends have a certain name
    public List<FriendUserDTO> getUsersByFriend(String friendName) {
        // DONE 23: find all users whose friends have a certain name.
        List<FriendUserDTO> friends = new ArrayList<>();
        friends = friendRepository.findAllByIdUsername(friendName);
        return friends;
    }

}
