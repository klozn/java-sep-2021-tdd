package codelab01;

import codelab01.domain.User;
import codelab01.domain.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

class UserServiceTest {

    private UserService userService;
    private UserRepository mockRepo;

    @BeforeEach
    void init() {
        mockRepo = Mockito.mock(UserRepository.class);
        userService = new UserService(mockRepo);
    }

    @Test
    void whenAddingUser_thenCallRepoAddMethodOnce() {
        //given
        User toAdd = new User("Akki");
        //when
        userService.addUser(toAdd);
        //then
        Mockito.verify(mockRepo, Mockito.times(1)).add(toAdd);
    }

    @Test
    void whenGettingUserById_thenCallRepoGetByIdMethodOnce() {
        //given
        UUID uuidToGet = UUID.randomUUID();
        //when
        userService.getUser(uuidToGet);
        //then
        Mockito.verify(mockRepo, Mockito.times(1)).getForId(uuidToGet);
    }

    @Test
    void whenGettingUsersSortedByNicknameAsc_thenReturnUsersInCorrectOrder() {
        //given
        List<User> users = List.of(new User("Akki"), new User("Tillo"), new User("Beire"));
        Mockito.when(mockRepo.getAll()).thenReturn(users);
        //when
        List<User> result = userService.getUsersSortedOnNicknameAsc();
        //then
        assertThat(result).containsExactly(users.get(0), users.get(2), users.get(1));
    }
}