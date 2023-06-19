package com.mryndina.exhibitions.controller;

import com.mryndina.exhibitions.entity.Book;
import com.mryndina.exhibitions.entity.Exhibition;
import com.mryndina.exhibitions.repository.ModelRepository;
import com.mryndina.exhibitions.repository.ExhibitionBookRepository;
import com.mryndina.exhibitions.repository.ExhibitionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/exhibition-model")
public class ExhibitionBookController {

    private final ExhibitionBookRepository exhibitionBookRepository;
    private final ExhibitionRepository exhibitionRepository;
    private final ModelRepository modelRepository;

    public ExhibitionBookController(
            ExhibitionBookRepository exhibitionBookRepository,
            ExhibitionRepository exhibitionRepository,
            ModelRepository modelRepository) {
        this.exhibitionBookRepository = exhibitionBookRepository;
        this.exhibitionRepository = exhibitionRepository;
        this.modelRepository = modelRepository;
    }

    @GetMapping("/add")
    public String showAddExhibitionBookForm(org.springframework.ui.Model model) {
        model.addAttribute("exhibitions", exhibitionRepository.findAll());
        model.addAttribute("books", modelRepository.findAll());
        return "add-exhibition-model";
    }

    @PostMapping("/add")
    public String addExhibitionBook(@RequestParam("exhibitionId") int id, @RequestParam("bookId") int bookId, RedirectAttributes redirectAttributes) {
/*        Exhibition exhibition = exhibitionRepository.findById(id);
        Book book = modelRepository.findById(bookId);*/

      /*  if (exhibition != null && book != null) {
            ExhibitionBook exhibitionBook = new ExhibitionBook();
            exhibitionBook.setExhibition(exhibition);
            exhibitionBook.setBook(book);
            exhibitionBookRepository.save(exhibitionBook);
        }*/
        redirectAttributes.addFlashAttribute("class", "alert-success");
        redirectAttributes.addFlashAttribute("message", "model_add_exhibition");
        return "redirect:/organizer";
    }
}

