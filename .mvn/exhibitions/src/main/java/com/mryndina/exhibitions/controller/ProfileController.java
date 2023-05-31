package com.mryndina.exhibitions.controller;

import com.mryndina.exhibitions.entity.User;
import com.mryndina.exhibitions.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class ProfileController {

    private final UserRepository userRepository;

    public ProfileController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/profile")
    public String showProfilePage(Model model, Principal principal) {
        String username = principal.getName();
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            // Обработка, если пользователь не найден
            return "redirect:/error";
        }

        User user = userOptional.get();
        model.addAttribute("user", user);
        return "profile";
    }
}

