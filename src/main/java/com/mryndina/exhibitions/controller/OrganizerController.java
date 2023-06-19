package com.mryndina.exhibitions.controller;

import com.mryndina.exhibitions.entity.UserIdNameRole;
import com.mryndina.exhibitions.service.ExhibitionService;
import com.mryndina.exhibitions.service.OrderService;
import com.mryndina.exhibitions.service.UserIdNameRoleService;
import com.mryndina.exhibitions.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@AllArgsConstructor
@RequestMapping("/organizer")
public class OrganizerController {

    private final UserService userService;
    private final UserIdNameRoleService userIdNameRoleService;
    private final ExhibitionService exhibitionService;
    private final OrderService orderService;

    @GetMapping
    public String getDashboard(Model model) {
        model.addAttribute("totalExhibitions", exhibitionService.getQuantity());
        model.addAttribute("totalUsers", userService.getUserQuantity());
        model.addAttribute("totalAdmins", userService.getAdminQuantity());
        model.addAttribute("totalTicketPurchases", orderService.getQuantity());
        model.addAttribute("profit", orderService.getProfit());
        return "orgdashboard";
    }

/*    @GetMapping("/users")
    public String getUsers(@RequestParam(required = false) Integer page, Book model) {
        int pageNumber = page != null && page > 0 ? page : 1;
        Page<UserIdNameRole> usersPage = userIdNameRoleService.getAllUsers(pageNumber-1);
        model.addAttribute("page", usersPage.getTotalPages());
        model.addAttribute("users", usersPage.getContent());
        return "users";
    }*/
}
