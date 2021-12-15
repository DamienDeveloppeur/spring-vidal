package com.example.springvidal.controller;

import com.example.springvidal.domain.Animal;
import com.example.springvidal.domain.Specie;
import com.example.springvidal.service.AnimalService;
import com.example.springvidal.service.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    AnimalService animalsService;
    @Autowired
    SpecieService specieService;

    @GetMapping("")
    public String init(Model model){
        model.addAttribute("animals", animalsService.list());
        return "list_animal";
    }

    @GetMapping ("/delete")
    public String delete(@RequestParam(name = "id") long id){
        animalsService.delete(id);
        return "redirect:/animal";
    }

    @GetMapping("/{id}")
    public String create(@PathVariable("id") long id, Model model) {
        Animal anim = null;
        if(id == 0L) anim = new Animal();
        else anim = animalsService.get(id);
        model.addAttribute("animal", anim);
        model.addAttribute("species", specieService.list());
        return "create_animal";
    }

    @PostMapping("")
    public String create(Animal sp, BindResult result, Model model){
        if(sp.getId() == null || sp.getId() == 0L) animalsService.create(sp);
        else animalsService.update(sp);
        return "redirect:/animal";
    }


}
