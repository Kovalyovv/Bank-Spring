package bank.service;

import bank.entity.User;
import bank.repository.UserRepository;
import bank.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this); // Инициализация мока
    }

    @Test
    void testGetUserById() {

        User user = new User();
        user.setId(1L);
        user.setName("John Doe");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        assertEquals("John Doe", result.getName());
        assertEquals(1L, result.getId());
    }
}
