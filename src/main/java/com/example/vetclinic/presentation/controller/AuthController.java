package com.example.vetclinic.presentation.controller;

import com.example.vetclinic.application.dto.CreateUserDTO;
import com.example.vetclinic.application.dto.UserDTO;
import com.example.vetclinic.application.mapper.UserMapper;
import com.example.vetclinic.domain.model.User;
import com.example.vetclinic.infrastructure.persistence.UserJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserJpaRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public AuthController(UserJpaRepository userRepo, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody CreateUserDTO dto) {
        User user = User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();

        user = userRepo.save(user);
        return ResponseEntity.ok(userMapper.toDto(user));
    }
}
