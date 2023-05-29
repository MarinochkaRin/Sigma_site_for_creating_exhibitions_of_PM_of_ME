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
    public void createUser(String username, String password,String photoId, String firstName, String secondName, String locationPerson) {
        if(userRepository.countByUsername(username) == 0) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setPhotoId(photoId);
            user.setFirstName(firstName);
            user.setSecondName(secondName);
            user.setLocationPerson(locationPerson);
            user.setRole(Role.USER);
            userRepository.save(user);
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

