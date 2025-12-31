package com.speed.user.service.repositories;

import com.speed.user.service.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void existsUserByUserIdTest() {

        User userTest1 = new User("testUserId","testuser","test@springboot","Dev-Test",new ArrayList<>());
        userRepository.save(userTest1);

        Boolean actResult = userRepository.existsUserByUserId("testUserId");
        assertThat(actResult).isTrue();

    }
}