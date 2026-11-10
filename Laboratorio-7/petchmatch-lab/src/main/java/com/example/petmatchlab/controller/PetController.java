package com.example.petmatchlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.petmatchlab.dto.PetForm;
import com.example.petmatchlab.model.Pet;
import com.example.petmatchlab.service.PetService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("pets", petService.findAll());
        return "pets/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable("id") long id, Model model) {
        var pet = petService.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Pet not found"
            ));

        model.addAttribute("pet", pet);
        return "pets/detail";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("petForm", new PetForm());
        model.addAttribute("editing", false);
        return "pets/form";
    }

    @PostMapping
    public String create(
        @Valid @ModelAttribute("petForm") PetForm petForm,
        BindingResult bindingResult,
        Model model,
        RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("editing", false);
            return "pets/form";
        }

        Pet pet = petService.create(petForm);
        redirectAttributes.addFlashAttribute(
            "successMessage",
            "Mascota registrada correctamente."
        );
        return "redirect:/pets/" + pet.getId();
    }
}