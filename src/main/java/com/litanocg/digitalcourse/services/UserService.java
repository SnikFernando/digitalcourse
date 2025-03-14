package com.litanocg.digitalcourse.services;

import com.litanocg.digitalcourse.entities.User;
import com.litanocg.digitalcourse.entities.dtos.UserDTO;
import com.litanocg.digitalcourse.entities.mappers.UserMapper;
import com.litanocg.digitalcourse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper = UserMapper.INSTANCE;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    public Flux<User> getAllUsers() {
        return userRepository.findAll();//.map(userMapper::toDTO);
    }

    public Mono<UserDTO> getUserById(Long id) {
        return userRepository.findById(id).map(userMapper::toDTO);
    }

    public Mono<UserDTO> createUser(UserDTO userDTO) {
        if (userDTO == null) {
            return Mono.error(new IllegalArgumentException("UserDTO cannot be null"));
        }

        String hashedPassword = passwordEncoder.encode(userDTO.getPassword());

        User user = userMapper.toEntity(userDTO);
        user.setPasswordHash(hashedPassword);

        return userRepository.save(user).map(userMapper::toDTO);
//        return userRepository.save(userMapper.toEntity(userDTO)).map(userMapper::toDTO);
    }

    public Mono<UserDTO> updateUser(Long id, UserDTO userDTO) {
        if (userDTO == null) {
            return Mono.error(new IllegalArgumentException("UserDTO cannot be null"));
        }
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found for id: " + id)))
                .flatMap(existingUser -> {
                    userMapper.updateUserFromDTO(userDTO, existingUser); // MapStruct actualiza los campos automáticamente
                    return userRepository.save(existingUser)
                            .map(userMapper::toDTO);
                });
    }


    public Mono<Void> deleteUser(Long id) {
        return userRepository.deleteById(id);
    }
}

