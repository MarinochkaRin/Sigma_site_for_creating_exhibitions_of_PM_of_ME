package com.mryndina.exhibitions.controller;

import com.mryndina.exhibitions.dto.ExhibitionDto;
import com.mryndina.exhibitions.entity.Exhibition;
import com.mryndina.exhibitions.entity.Image;
import com.mryndina.exhibitions.entity.User;
import com.mryndina.exhibitions.service.ExhibitionService;
import com.mryndina.exhibitions.service.ImageService;
import com.mryndina.exhibitions.service.utility.Cart;
import com.mryndina.exhibitions.service.utility.Search;
import com.mryndina.exhibitions.dto.ExhibitionDetailsDto;
import com.mryndina.exhibitions.service.AuthService;
import com.mryndina.exhibitions.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

/**
 * Consists of main views for user.
 * Placing order by user is separated at OrderController.
 */

@Controller
@AllArgsConstructor
@RequestMapping
@SessionAttributes({"search", "cart"})

public class HomeController {

    private final ExhibitionService exhibitionService;
    private final AuthService authService;
    private final ModelMapper modelMapper;
    @Autowired
    private ImageService imageService;
    @ModelAttribute("search")
    public Search newSearch() {
        return new Search();
    }

    @ModelAttribute("cart")
    public Cart newCart() {
        return new Cart();
    }

    @GetMapping("/")
    public String getHome() {
        return "redirect:/exhibitions?page=1";
    }

    @GetMapping("/exhibitions")
    public String getExhibitions(@ModelAttribute Search search,
                                 @RequestParam(required = false) Integer page,
                                 @RequestParam(required = false) boolean resetFilter,
                                 Model model) {
        authService.addUsernameAttribute(model);
        int pageNumber = page != null && page > 0 ? page : 1;
        if(resetFilter) search = newSearch();
        Page<Exhibition> exhibitionsPage = exhibitionService.searchAndSortActiveExhibitions(
                    search.getFrom(), search.getTo(), pageNumber-1,
                    search.getSort().direction(), search.getSort().field());
        model.addAttribute("totalPages", exhibitionsPage.getTotalPages());
        model.addAttribute("search", search);
        model.addAttribute("exhibitions", exhibitionsPage.getContent());
        model.addAttribute("page", pageNumber);
        return "home";
    }

    @PostMapping("/exhibitions")
    public String SearchExhibitions(@ModelAttribute Search search, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("search", search);
        return "redirect:/exhibitions";
    }

    @GetMapping("/exhibitions/{id}")
    public String getExhibition(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        authService.addUsernameAttribute(model);
        try {
            model.addAttribute("exhibition", modelMapper.map(exhibitionService.getExhibition(id), ExhibitionDetailsDto.class));
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("class", "alert-danger");
            redirectAttributes.addFlashAttribute("message", "exhibition_not_found");
            return "redirect:/exhibitions";
        }
        return "exhibition";
    }

/*    @GetMapping("/profile")
    public String profilePage(Book model) {
        // Получите информацию о пользователе из базы данных или другого источника данных
        User user = UserService.getUser(); // Замените это соответствующим кодом для получения пользователя

        // Поместите пользователя в модель представления
        model.addAttribute("user", user);

        return "profile";
    }*/

    @GetMapping("/cart/add")
    public String addToCart(@RequestParam int id, @RequestParam int quantity, @ModelAttribute Cart cart, RedirectAttributes redirectAttributes) throws Exception {
        ExhibitionDto exhibitionDto = modelMapper.map(exhibitionService.findExhibition(id), ExhibitionDto.class);
        cart.addItem(exhibitionDto, quantity);
        redirectAttributes.addFlashAttribute("class", "alert-success");
        redirectAttributes.addFlashAttribute("message", "added_to_cart");
        return "redirect:/exhibitions";
    }

    @GetMapping("/cart/remove")
    public String removeFromCart(@RequestParam int id, @ModelAttribute Cart cart, RedirectAttributes redirectAttributes) throws Exception {
        cart.removeItem(id);
        redirectAttributes.addFlashAttribute("class", "alert-success");
        redirectAttributes.addFlashAttribute("message", "removed_from_cart");
        return "redirect:/cart";
    }

    @PostMapping("/cart/update")
    public String updateCart(@ModelAttribute Cart cart, RedirectAttributes redirectAttributes) throws Exception {
        cart.updateQuantity();
        redirectAttributes.addFlashAttribute("class", "alert-success");
        redirectAttributes.addFlashAttribute("message", "cart_updated");
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String getCart(@ModelAttribute Cart cart, Model model) {
        authService.addUsernameAttribute(model);
        model.addAttribute("totalQuantity", cart.getQuantityTotal());
        model.addAttribute("totalPrice", cart.getPriceTotal());
        return "cart";
    }
    @GetMapping("/display")
    public ResponseEntity<byte[]> displayImage(@RequestParam("id") long id) throws IOException, SQLException
    {
        Image image = imageService.viewById(id);
        byte [] imageBytes = null;
        imageBytes = image.getImage().getBytes(1,(int) image.getImage().length());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }
    @GetMapping("/al")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("index");
        List<Image> imageList = imageService.viewAll();
        mv.addObject("imageList", imageList);
        return mv;
    }
    @GetMapping("/add")
    public ModelAndView addImage(){
        return new ModelAndView("addimage");
    }

    // add image - post
    @PostMapping("/add")
    public String addImagePost(HttpServletRequest request, @RequestParam("image") MultipartFile file) throws IOException, SerialException, SQLException
    {
        byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

        Image image = new Image();
        image.setImage(blob);
        imageService.create(image);
        return "redirect:/organizer";
    }
}
