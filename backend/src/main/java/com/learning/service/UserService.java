package com.learning.service;

import com.learning.dto.LoginRequest;
import com.learning.dto.SignupRequest;
import com.learning.dto.UserDTO;
import com.learning.model.User;
import com.learning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserDTO signup(SignupRequest signupRequest) {
        // Check if user already exists
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            throw new RuntimeException("User with this email already exists");
        }

        // Create new user
        User user = new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        User savedUser = userRepository.save(user);

        return new UserDTO(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }

    public UserDTO login(LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());

        if (userOptional.isEmpty()) {
            throw new RuntimeException("Invalid email or password");
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
