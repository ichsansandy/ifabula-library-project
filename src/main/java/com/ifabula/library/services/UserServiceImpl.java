package com.ifabula.library.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import com.ifabula.library.model.Role;
import com.ifabula.library.model.User;
import com.ifabula.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ifabula.library.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        if (userRepository.findByEmail(registrationDto.getEmail()) != null) {
            throw new Error("Email already exists");
        }

        if (!isValidPassword(registrationDto.getPassword())) {
            throw new Error("Password at least 8 character and 1 uppercase, no special character or symbol allowed");
        }

        User user = new User(registrationDto.getFirstName(),
            registrationDto.getLastName(), registrationDto.getEmail(),
            passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection < ? extends GrantedAuthority > mapRolesToAuthorities(Collection < Role > roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    private boolean isValidPassword(String password) {
        // Password should be at least 8 characters, alphanumeric, and have at least 1 uppercase
        return password.length() >= 8 && password.matches("^(?=.*[a-zA-Z])(?=.*[A-Z]).*$");
    }

}
