package com.mryndina.exhibitions.service;

import com.mryndina.exhibitions.dto.UserDto;
import com.mryndina.exhibitions.entity.Role;
import com.mryndina.exhibitions.entity.User;

import com.mryndina.exhibitions.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Long getUserQuantity() {
        return userRepository.countByRole(Role.USER);
    }

    public Long getModellerQuantity() {
        return userRepository.countByRole(Role.MODELLER);
    }

    public Long getOrganizerQuantity() {
        return userRepository.countByRole(Role.ORGANIZER);
    }

    public Long getAdminQuantity() {
        return userRepository.countByRole(Role.ADMIN);
    }



    @Transactional
    public void createUser(String username, String password,String photoid, String firstname, String secondName) {
        if(userRepository.countByUsername(username) == 0) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole(Role.USER);
            userRepository.save(user);
            user.setPhotoId(photoid);
            user.setFirstName(firstname);
            user.setSecondName(secondName);
            log.info("User created: {}", user.getUsername());
        }
    }
    @Transactional
    public void createModeller(String username, String password) {
        if(userRepository.countByUsername(username) == 0) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole(Role.MODELLER);
            userRepository.save(user);
            log.info("User created: {}", user.getUsername());
        }
    }
    @Transactional
    public void createOrganizer(String username, String password) {
        if(userRepository.countByUsername(username) == 0) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole(Role.ORGANIZER);
            userRepository.save(user);
            log.info("Organizer created: {}", user.getUsername());
        }
    }
    @Transactional
    public void createAdmin(String username, String password) {
        if(userRepository.countByUsername(username) == 0) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole(Role.ADMIN);
            userRepository.save(user);
            log.info("Admin created: {}", user.getUsername());
        }
    }
}

