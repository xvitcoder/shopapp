package com.xvitcoder.shopapp.userservice.core.service;

import com.xvitcoder.shopapp.userservice.core.domain.User;
import com.xvitcoder.shopapp.userservice.core.repository.UserRepository;
import com.xvitcoder.shopapp.userservice.core.service.exception.UserAlreadyExistsException;
import com.xvitcoder.shopapp.userservice.core.service.exception.UserNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    @Transactional(readOnly = true)
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
    }

    @Transactional
    public User createUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException(user.getUsername());
        }

        user.setId(null);
        user.setCreatedOn(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(Long userId, User user) {
        User existingUser = findUserById(userId);

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setUpdatedOn(LocalDateTime.now());
        return userRepository.save(existingUser);
    }

    @Transactional
    public void deleteUser(Long userId) {
        findUserById(userId);
        userRepository.deleteById(userId);
    }
}
