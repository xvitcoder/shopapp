package com.xvitcoder.shopapp.userservice.core.service;

import com.xvitcoder.shopapp.userservice.core.domain.User;
import com.xvitcoder.shopapp.userservice.utils.IntegrationAbstractTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserServiceTest extends IntegrationAbstractTest {

    @Autowired
    private UserService userService;

    @Test
    void findUsers() {
        List<User> users = userService.findUsers();
        assertFalse("findUsers count is empty", users.isEmpty());
        assertEquals("findUsers count is not 2", users.size(), 2);
    }

    @Test
    void findUserById() {
    }

    @Test
    void findUserByUsername() {
    }

    @Test
    void createUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}