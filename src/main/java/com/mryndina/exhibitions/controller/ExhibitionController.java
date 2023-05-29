package com.mryndina.exhibitions.controller;

import com.mryndina.exhibitions.dto.ExhibitionDetailsDto;
import com.mryndina.exhibitions.service.AuthService;
import com.mryndina.exhibitions.service.ExhibitionService;
import com.mryndina.exhibitions.service.utility.DatesLocations;
import com.mryndina.exhibitions.service.utility.Search;
import com.mryndina.exhibitions.entity.Exhibition;
import com.mryndina.exhibitions.service.LocationService;
import com.mryndina.exhibitions.service.OrderService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Consists of views related to manage exhibitions.
 * Only for administrator.
 */

@Controller
@AllArgsConstructor
@SessionAttributes({"search", "exhibition"})
@RequestMapping("/organizer")
public class ExhibitionController {
    private final ExhibitionService exhibitionService;
    private final LocationService locationService;
    private final OrderService orderService;


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
        return "exhibitions";
    }





    @PostMapping("/exhibitions")
    public String SearchExhibitions(@ModelAttribute Search search, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("search", search);
        return "redirect:/organizer/exhibitions";
    }


    @GetMapping("/exhibitions/{id}")
    public String getExhibition(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        authService.addUsernameAttribute(model);
        try {
            model.addAttribute("exhibition", modelMapper.map(exhibitionService.getExhibition(id), ExhibitionDetailsDto.class));
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("class", "alert-danger");
            redirectAttributes.addFlashAttribute("message", "exhibition_not_found");
            return "redirect:/organizer/exhibitions";
        }
        model.addAttribute("orders", orderService.countByExhibitionId(id));
        return "organizer-exhibition";
    }


    @GetMapping("/organizer/exhibitions/{id}")
    public String getExhibitio(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("exhibition", exhibitionService.getExhibition(id));
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("class", "alert-danger");
            redirectAttributes.addFlashAttribute("message", "exhibition_not_found");
            return "redirect:/organizer/exhibitions";
        }

        model.addAttribute("orders", orderService.countByExhibitionId(id));
        return "organizer-exhibition";
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
        return "organizer-cancel-exhibitions";
    }

    @PostMapping("/exhibitions/cancel/{id}")
    public String postCancelExhibition (@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        exhibitionService.cancelExhibition(id);
        redirectAttributes.addFlashAttribute("class", "alert-success");
        redirectAttributes.addFlashAttribute("message", "exhibition_canceled");
        return "redirect:/organizer/exhibitions";
    }
}
