package com.example.springvidal.controller;

import com.example.springvidal.domain.Specie;
import com.example.springvidal.service.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/specie")
public class SpecieController {
    @Autowired
    SpecieService specieService;

    @Transactional
    @GetMapping()
    public String init(Model model){
        System.out.println("BALLOT");
        List<Specie> sps = specieService.list();
        // on renverra la variable, comme pour symfo
        model.addAttribute("species", sps);
        return "list_specie";
    }

    @Transactional
    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") long id){
        specieService.delete(id);
        return "redirect:/specie";
    }

    @GetMapping("/{id}")
    public String createOrUpdate(@PathVariable("id") long id, Model model){
        Specie sp = null;
        if(id == 0L) sp = new Specie();
        else sp = specieService.get(id);
        model.addAttribute("specie", sp);
        return "create_specie";
    }

    @Transactional
    @PostMapping("")
    public String createOrUpdate(Specie sp, BindResult result, Model model){
        if(sp.getId() == null || sp.getId() == 0L) specieService.create(sp);
        else specieService.update(sp);
        return "redirect:/specie";
    }

}
