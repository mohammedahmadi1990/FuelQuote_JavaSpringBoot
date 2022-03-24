package com.petrol.fuelquote.service;
import com.petrol.fuelquote.model.User;
import com.petrol.fuelquote.web.dto.UserRegisterationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
        User save(UserRegisterationDto registerationDto);
        User getUserByUsername(String username);
}
