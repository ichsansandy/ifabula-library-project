package com.ifabula.library.services;

import com.ifabula.library.dto.UserRegistrationDto;
import com.ifabula.library.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService{
 User save(UserRegistrationDto registrationDto);
}