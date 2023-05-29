package com.mryndina.exhibitions.controller;

import com.mryndina.exhibitions.dto.ExhibitionDetailsDto;
import com.mryndina.exhibitions.dto.OrderDetailsDto;
import com.mryndina.exhibitions.entity.Book;
import com.mryndina.exhibitions.entity.Exhibition;
import com.mryndina.exhibitions.entity.Order;
import com.mryndina.exhibitions.entity.UserIdNameRole;
import com.mryndina.exhibitions.service.*;
//import com.mryndina.exhibitions.entity.*;
import com.mryndina.exhibitions.service.ExhibitionService;
import com.mryndina.exhibitions.service.utility.DatesLocations;
import com.mryndina.exhibitions.service.utility.Search;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Consists of main view for administrator.
 * The management of exhibitions and locations is separated in the respective controllers (ExhibitionController, LocationController).
 */

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final UserIdNameRoleService userIdNameRoleService;
    private final ExhibitionService exhibitionService;
    private final OrderService orderService;
    private final ModelService modelService;
    @GetMapping
    public String getDashboard(Model model) {
        model.addAttribute("totalExhibitions", exhibitionService.getQuantity());
        model.addAttribute("totalUsers", userService.getUserQuantity());
        model.addAttribute("totalAdmins", userService.getAdminQuantity());
        model.addAttribute("totalTicketPurchases", orderService.getQuantity());
        model.addAttribute("profit", orderService.getProfit());
        return "dashboard";
    }

    @GetMapping("/users")
    public String getUsers(@RequestParam(required = false) Integer page, Model model) {
        int pageNumber = page != null && page > 0 ? page : 1;
        Page<UserIdNameRole> usersPage = userIdNameRoleService.getAllUsers(pageNumber-1);
        model.addAttribute("page", usersPage.getTotalPages());
        model.addAttribute("users", usersPage.getContent());
        return "users";
    }

    private final LocationService locationService;

    private final AuthService authService;
    private final ModelMapper modelMapper;
    @ModelAttribute("search")
    public Search newSearch() {
        return new Search();
    }

    @ModelAttribute("exhibition")
    public Exhibition newExhibition() {
        return new Exhibition();
    }

    @GetMapping("/exhibitions")
    public String getExhibitions(@ModelAttribute Search search,
                                 @RequestParam(required = false) Integer page,
                                 @RequestParam(required = false) boolean resetFilter,
                                 Model model) {
        int pageNumber = page != null && page > 0 ? page : 1;
        if(resetFilter) search = newSearch();
        Page<Exhibition> exhibitionsPage = exhibitionService.searchAndSortExhibitions(
                search.getFrom(), search.getTo(), pageNumber-1,
                search.getSort().direction(), search.getSort().field());
        model.addAttribute("totalPages", exhibitionsPage.getTotalPages());
        model.addAttribute("search", search);
        model.addAttribute("exhibitions", exhibitionsPage.getContent());
        model.addAttribute("page", pageNumber);
        return "admin-exhibitions";
    }





    @PostMapping("/exhibitions")
    public String SearchExhibitions(@ModelAttribute Search search, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("search", search);
        return "redirect:/admin/exhibitions";
    }


    @GetMapping("/exhibitions/{id}")
    public String getExhibition(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        authService.addUsernameAttribute(model);
        try {
            model.addAttribute("exhibition", modelMapper.map(exhibitionService.getExhibition(id), ExhibitionDetailsDto.class));
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("class", "alert-danger");
            redirectAttributes.addFlashAttribute("message", "exhibition_not_found");
            return "redirect:/admin/exhibitions";
        }
        model.addAttribute("orders", orderService.countByExhibitionId(id));
        return "admin-exhibition";
    }


    @GetMapping("/admin/exhibitions/{id}")
    public String getExhibitio(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("exhibition", exhibitionService.getExhibition(id));
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("class", "alert-danger");
            redirectAttributes.addFlashAttribute("message", "exhibition_not_found");
            return "redirect:/admin/exhibitions";
        }

        model.addAttribute("orders", orderService.countByExhibitionId(id));
        return "admin-exhibition";
    }


    @GetMapping("/exhibitions/new/check-locations")
    public String getCheckLocations(Model model) {
        model.addAttribute("datesLocations", new DatesLocations());
        return "check-locations";
    }
    @GetMapping("/exhibitions/new/details")
    public String getDetails(@ModelAttribute DatesLocations datesLocations, Model model) {
        datesLocations.setLocations(locationService.checkAvailability(datesLocations.getStartDate(), datesLocations.getEndDate()));
        Exhibition exhibition = new Exhibition();
        exhibition.setStartDate(datesLocations.getStartDate());
        exhibition.setEndDate(datesLocations.getEndDate());
        model.addAttribute("exhibition", exhibition);
        model.addAttribute("locations", datesLocations.getLocations());
        return "details";
    }

    @PostMapping("/exhibitions/new/details")
    public String postDetails(@ModelAttribute Exhibition exhibition, RedirectAttributes redirectAttributes) {
        exhibitionService.createExhibition(exhibition);
        redirectAttributes.addFlashAttribute("class", "alert-success");
        redirectAttributes.addFlashAttribute("message", "exhibition_created");
        return "redirect:/organizer";
    }

    @GetMapping("/exhibitions/new")
    public String addExhibition(Model model) {
        return "redirect:/organizer/exhibitions/new/check-locations";
    }

    @GetMapping("/exhibitions/cancel/{id}")
    public String getCancelExhibition (@PathVariable int id, Model model) {
        long orders = orderService.countByExhibitionId(id);
        model.addAttribute("orders", orders);
        return "cancel-exhibition";
    }

    @PostMapping("/exhibitions/cancel/{id}")
    public String postCancelExhibition (@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        exhibitionService.cancelExhibition(id);
        redirectAttributes.addFlashAttribute("class", "alert-success");
        redirectAttributes.addFlashAttribute("message", "exhibition_canceled");
        return "redirect:/admin/exhibitions";
    }
    @GetMapping("/orders")
    public String getOrders(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer exhibitionId, Model model) {
        int pageNumber = page != null && page > 0 ? page : 1;
        Page<Order> ordersPage;
        if(exhibitionId == null) {
            ordersPage = orderService.getAllOrders(pageNumber-1);
        } else {
            ordersPage = orderService.getByExhibitionId(exhibitionId, pageNumber-1);
        }
        List<OrderDetailsDto> orders = ordersPage.getContent().stream()
                .map(order -> modelMapper.map(order, OrderDetailsDto.class))
                .collect(toList());
        model.addAttribute("page", ordersPage.getTotalPages());
        model.addAttribute("orders", orders);
        return "admin-orders";
    }
    @RequestMapping("/model")
    public String findAllBooks(Model model) {
        final List<Book> books = modelService.findAllBooks();

        model.addAttribute("books", books);
        return "admin-models";
    }

    @RequestMapping("/remove-book/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        modelService.deleteBook(id);

        model.addAttribute("book", modelService.findAllBooks());
        return "redirect:/admin/model";
    }
}
