package codelab01;

import codelab01.domain.User;
import codelab01.domain.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceIntegrationTest {

    private UserService userService;
    private UserRepository userRepository;

    @BeforeEach
    void init() {
        userRepository = new UserRepository();
        userService = new UserService(userRepository);
    }

    @Test
    void whenAddingCustomer_repoAddsItToDB() {
        //when
        userService.addUser(new User("test"));
        //then
        List<User> users = userRepository.getAll();
        assertEquals(1, users.size());
    }

    @Test
    void whenGettingUserByUUID_repoReturnsCorrectUser() {
        //given
        User userToAdd = new User("test");
        UUID userId = userToAdd.getId();
        userService.addUser(userToAdd);
        //when
        User returnedUser = userService.getUser(userId);
        //then
        assertEquals(userToAdd, returnedUser);
    }

    @Test
    void whenGettingUsersSortedOnNicknameASC_thenUsersAreReturnedInCorrectOrder() {
        //given
        List<User> users = List.of(new User("Beire"), new User("Tobi"), new User("Akki"));
        users.forEach(userService::addUser);
        //when
        List<User> result = userService.getUsersSortedOnNicknameAsc();
        //then
        assertThat(result).containsExactly(users.get(2), users.get(0), users.get(1));
    }
}
