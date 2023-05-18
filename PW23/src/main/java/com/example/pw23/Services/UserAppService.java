package com.example.pw23.Services;

import com.example.pw23.Repos.UserRepo;
import com.example.pw23.Tables.User;
import com.example.pw23.Tables.UserApp;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAppService implements UserDetailsService {

    private final PasswordEncoder encoder;

    private final UserRepo userRepo;

    UserAppService(UserRepo userRepo, PasswordEncoder encoder) {
        this.encoder = encoder;
        this.userRepo = userRepo;
    }
    public String addUser(User user) {
        if (userRepo.findUserByUsername(user.getUsername()) != null) {
            throw new IllegalStateException("User with username " + user.getUsername() + " already exists");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return "login";
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserApp userApp = new UserApp(userRepo.findUserByUsername(username));
        if (userApp.getUser() == null)
            throw new UsernameNotFoundException("user with username " + username + " does not exist");
        return userApp;
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }
}
