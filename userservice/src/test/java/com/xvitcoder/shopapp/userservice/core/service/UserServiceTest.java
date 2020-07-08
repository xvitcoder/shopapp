package com.xvitcoder.shopapp.userservice.core.service;

import com.xvitcoder.shopapp.userservice.core.domain.User;
import com.xvitcoder.shopapp.userservice.utils.IntegrationAbstractTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.Assert.*;

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
        User foundUser = userService.findUserById(1L);
        assertNotNull("findUserById not found", foundUser);
        assertEquals("findUserById found wrong user", "user1", foundUser.getUsername());
    }

    @Test
    void findUserByUsername() {
        User foundUser = userService.findUserByUsername("user1");
        assertNotNull("findUserByUsername not found", foundUser);
        assertEquals("findUserByUsername found wrong user", "user1", foundUser.getUsername());
    }

    @Test
    void createUser() {
        User user = new User();
        user.setUsername("newuser");
        user.setPassword("newpass");
        user.setFirstName("first");
        user.setLastName("last");
        user = userService.createUser(user);

        assertNotNull("createUser not created", user.getId());
    }

    @Test
    void updateUser() {
        User foundUser = userService.findUserById(1L);
        foundUser.setFirstName("firstname-updated");
        foundUser.setLastName("lastname-updated");
        foundUser.setUsername("username-updated");
        foundUser.setPassword("password-updated");

        assertNull(foundUser.getUpdatedOn());

        foundUser = userService.updateUser(foundUser.getId(), foundUser);

        assertNotNull(foundUser.getUpdatedOn());
        assertEquals("firstname-updated", foundUser.getFirstName());
        assertEquals("lastname-updated", foundUser.getLastName());
        assertEquals("user1", foundUser.getUsername());
        assertEquals("pass1", foundUser.getPassword());
    }

    @Test
    void deleteUser() {
        assertEquals(userService.findUsers().size(), 3);
        userService.deleteUser(1L);
        assertEquals(userService.findUsers().size(), 2);
    }
}