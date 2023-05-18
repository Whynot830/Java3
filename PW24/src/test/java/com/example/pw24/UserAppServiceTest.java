package com.example.pw24;

import com.example.pw24.Repos.UserRepo;
import com.example.pw24.Services.UserAppService;
import com.example.pw24.Tables.User;
import com.example.pw24.Tables.UserApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserAppServiceTest {
    @Mock
    private UserRepo userRepo;
    private UserAppService userAppService;

    @BeforeEach
    void init() {
        this.userAppService = new UserAppService(userRepo, new BCryptPasswordEncoder());
    }
    @Test
    void getUsers() {
        User user1 = new User();
        user1.setUsername("whynot");
        User user2 = new User();
        user2.setUsername("admin");
        Mockito.when(userRepo.findAll()).thenReturn(List.of(user1, user2));
        assertEquals(2, userAppService.getUsers().size());
        assertEquals("whynot", userAppService.getUsers().get(0).getUsername());
    }

    @Test
    void loadUserByUsername() {
        User user = new User();
        user.setUsername("whynot");
        user.setPassword("password");

        UserApp userApp = new UserApp(user);

        Mockito.when(userRepo.findUserByUsername(userApp.getUsername())).thenReturn(user);

        assertEquals(userRepo.findUserByUsername(userApp.getUsername()), user);
    }
}
