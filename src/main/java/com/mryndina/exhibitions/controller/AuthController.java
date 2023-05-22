package com.mryndina.exhibitions.controller;

import com.mryndina.exhibitions.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

/**
 * Consists of views related to register and authenticate users.
 * Both for the user and the administrator.
 */

@Controller
@AllArgsConstructor
@RequestMapping
public class AuthController {
    private final UserService userService;


    @GetMapping("/signin")
    public String getSignin(Model model) {
        return "signin";
    }

    @GetMapping("/bad-credentials")
    public String getBadCredentials(Model model, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("class", "alert-danger");
        redirectAttributes.addFlashAttribute("message", "bad_credentials");
        return "redirect:/signin";
    }
/*    @GetMapping("/user/profile/{userId}")
    public String getUserProfile(@PathVariable("userId") Long userId, Model model) {
        // Получение данных пользователя по идентификатору userId
        User user = userService.getUserById(userId);

        // Передача данных пользователя в модель
        model.addAttribute("user", user);

        // Возвращение имени представления для отображения страницы с данными пользователя
        return "user-profile";
    }*/

    @GetMapping("/register")
    public String getRegister(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam Map<String, String> body, @RequestParam("role") String role, Model model, RedirectAttributes redirectAttributes) {
        if (role.equals("ADMIN")) {
            userService.createAdmin(body.get("username"), body.get("password"));
            redirectAttributes.addFlashAttribute("message", "admin_created");
        } else if (role.equals("ORGANIZER")) {
            userService.createOrganizer(body.get("username"), body.get("password"));
            redirectAttributes.addFlashAttribute("message", "organizer_created");
        } else if (role.equals("MODELLER")) {
            userService.createModeller(body.get("username"), body.get("password"));
            redirectAttributes.addFlashAttribute("message", "modeller_created");
        } else {
            userService.createUser(body.get("username"), body.get("password"),body.get("photoid"), body.get("firstname"), body.get("secondname"));
            redirectAttributes.addFlashAttribute("message", "user_registered");
        }

        redirectAttributes.addFlashAttribute("class", "alert-success");
        return "redirect:/";
    }

    @GetMapping("admin/new-admin")
    public String getNewAdmin(Model model) {
        return "new-admin";
    }

    @PostMapping("admin/new-admin")
    public String registerAdmin(@RequestParam Map<String, String> body, Model model, RedirectAttributes redirectAttributes) {

        userService.createAdmin(body.get("username"), body.get("password"));
        redirectAttributes.addFlashAttribute("class", "alert-success");
        redirectAttributes.addFlashAttribute("message", "admin_created");
        return "redirect:/admin";
    }
}
