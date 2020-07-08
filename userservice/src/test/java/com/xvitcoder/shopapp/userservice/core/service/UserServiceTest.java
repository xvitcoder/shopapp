package com.xvitcoder.shopapp.userservice.core.service;

import com.xvitcoder.shopapp.userservice.core.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.Assert.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Testcontainers
class UserServiceTest {

    @Container
    private static final PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:10.6")
            .withDatabaseName("shopapp")
            .withUsername("shopapp")
            .withPassword("shopapp");

    @DynamicPropertySource
    static void postgresProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Autowired
    private UserService userService;

    @Test
    void findUsers() {
        List<User> users = userService.findUsers();
        assertTrue("findUsers count is empty", !users.isEmpty());
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