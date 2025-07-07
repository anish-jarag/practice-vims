package com.example.vims_backend.repository;

import com.example.vims_backend.entity.User;
import com.example.vims_backend.entity.enums.Role;
import com.example.vims_backend.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveAndFindByEmail() {
        User user = new User();
        user.setName("Test User");
        user.setEmail("test@example.com");
        user.setPassword("test123");
        user.setDob(LocalDate.of(2000, 1, 1));
        user.setAadhaar("123412341234");
        user.setPan("ABCDE1234F");
        user.setRole(Role.USER);

        userRepository.save(user);

        User fetched = userRepository.findByEmail("test@example.com");
        assertThat(fetched).isNotNull();
        assertThat(fetched.getName()).isEqualTo("Test User");
        assertThat(fetched.getRole()).isEqualTo(Role.USER);
    }
}
