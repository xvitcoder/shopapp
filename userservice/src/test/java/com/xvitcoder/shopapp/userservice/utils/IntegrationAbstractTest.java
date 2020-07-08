package com.xvitcoder.shopapp.userservice.utils;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
abstract public class IntegrationAbstractTest {

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
}
