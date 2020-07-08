package com.xvitcoder.shopapp.userservice.utils;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
abstract public class IntegrationAbstractTest {
    private static final String CONTAINER_VERSION = "postgres:10.6";
    private static final String DATABASE_NAME = "shopapp";
    private static final String DATABASE_USERNAME = "shopapp";
    private static final String DATABASE_PASSWORD = "shopapp";

    @Container
    private static final PostgreSQLContainer postgres = new PostgreSQLContainer(CONTAINER_VERSION)
            .withDatabaseName(DATABASE_NAME)
            .withUsername(DATABASE_USERNAME)
            .withPassword(DATABASE_PASSWORD);

    @DynamicPropertySource
    static void postgresProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }
}
