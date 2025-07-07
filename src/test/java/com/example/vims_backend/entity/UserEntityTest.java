package com.example.vims_backend.entity;

import com.example.vims_backend.entity.enums.Role;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class UserEntityTest {

    @Test
    public void testUserCreation() {
        User user = new User();
        user.setName("Tester");
        user.setEmail("t@t.com");
        user.setDob(LocalDate.of(1999, 1, 1));
        user.setPassword("test");
        user.setAadhaar("111122223333");
        user.setPan("ABCDE1234F");
        user.setRole(Role.USER);

        assertThat(user.getName()).isEqualTo("Tester");
        assertThat(user.getEmail()).contains("@");
    }
}
