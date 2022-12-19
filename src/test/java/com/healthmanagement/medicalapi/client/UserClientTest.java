package com.healthmanagement.medicalapi.client;

import com.healthmanagement.medicalapi.model.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserClientTest {
    @Autowired
    UserClient client;

   // @Test
    void getUser() {
        UserDto user = client.getUserById(5l);
        assertNotNull(user);
    }

}
