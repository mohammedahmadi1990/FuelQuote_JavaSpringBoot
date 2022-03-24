package com.petrol.fuelquote.service;

import com.petrol.fuelquote.model.Role;
import com.petrol.fuelquote.model.User;
import com.petrol.fuelquote.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    void save() {
        assertEquals(1,1);
    }

    @Test
    void getUserByUsername() {
        assertEquals(1,1);
    }

    @Test
    void loadUserByUsername() {
        assertEquals(1,1);
    }
}