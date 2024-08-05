package com.LoversDogs.Lovers.config;

import com.LoversDogs.Lovers.entity.User;
import com.LoversDogs.Lovers.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User save(User form) {
        form.setPassword(passwordEncoder.encode(form.getPassword()));
        return userRepository.save(form);
    }

    public Optional<User> findByUserEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
