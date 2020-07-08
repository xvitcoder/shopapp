package com.xvitcoder.shopapp.userservice.core.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userId) {
        super(String.format("User with id %d, not found", userId));
    }

    public UserNotFoundException(String username) {
        super(String.format("User with username %s, not found", username));
    }
}
